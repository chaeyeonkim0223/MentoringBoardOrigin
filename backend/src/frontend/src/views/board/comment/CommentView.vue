<template lang="">
  <div>
    <!-- 댓글 보여주는 form -->
    <div v-if="!isModifyShow" class="comment">
      <div class="head">
        {{ comment.rgtrNm }} | {{ checkMemberCode(comment.rgtrMbrCd) }} | {{ comment.regDt }}
      </div>
      <div class="content" v-html="enterToBr(comment.cmntCn)"></div>

      <div class="btn-group" v-if="checkMyComment()">
        <p class="p-1" @click="isModifyShow = true">수정</p>

        <p class="p-1" @click="remove">삭제</p>

          <p v-if="(comment.slctnYn != 'Y')" class="p-1" @click="select(comment)">채택</p>
      </div>
    </div>
    <!-- 댓글 수정하는 form -->
    <div v-if="isModifyShow" class="comment">
      <div class="head">
        {{ mComment.rgtrNm }} | {{ checkMemberCode(mComment.rgtrMbrCd) }} | {{ mComment.regDt }}
      </div>
      <v-textarea v-model="mComment.cmntCn" solo></v-textarea>
      <div class="btn-group" v-if="checkMyComment()">
        <p class="p-1" @click="modify">확인</p>
        <p class="p-1" @click="cancle">취소</p>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
axios.defaults.headers.post["Content-Type"] = "application/json";

export default {
  props: ["comment"],
  data() {
    return {
      isModifyShow: false,
      mComment: this.comment
    };
  },
  methods: {
    checkMemberCode(code) {
      if (code == "MB001") return "관리자";
      else if (code == "MB002") return "멘토";
      else if (code == "MB003") return "멘티";
    },
    checkMyComment() {
      //내가 쓴 게시글인지 확인
      return true;
    },
    // 댓글 수정
    modify() {
      this.isModifyShow = true;
      // 서버 통신
      axios.put("/api/comments", this.comment).then((res) => {
        console.log(res.data);
        this.isModifyShow = false;
      });
    },
    remove() {
      if (confirm("정말로 삭제할까요?")) {
        console.log(this.comment.cmntSn);
        axios.delete(`/api/comments/${Number(this.comment.cmntSn)}`).then(() => {
          this.$emit("getCommentInit", this.comment.pstartNo);
        });
      }
    },
    cancle() {
      this.isModifyShow = false;
      this.mComment = this.comment;
    },
    enterToBr(str) {
      if (str) return str.replace(/(?:\r\n|\r|\n)/g, "<br />");
    },
    select(comment) {
      comment.slctnYn = 'Y'
      // 서버 통신
      // 댓글 채택 업데이트
      axios.put("/api/comments", comment).then((res) => {
        console.log(res.data);
        this.$emit("getCommentInit", res.data.pstartNo);

        //게시글 채택 업데이트
        this.$emit("getBoardInit", res.data.pstartNo);

      });

    }
    // copy_comment(comment) {
    //   return {
    //     bid: this.comment.bid,
    //     seq: this.comment.seq,
    //     content: this.comment.content,
    //     regtime: this.comment.regtime,
    //     userid: this.comment.userid,
    //   };
    // },
  },
  // watch: {
  //   comment: function (newVal) {
  //     this.c_cmt = this.copy_comment(this.comment);
  //   },
  // },
};
</script>

<style scoped>
.comment {
  text-align: left;
  border-radius: 5px;
  background-color: #ffffff;
  padding: 10px 20px;
  margin: 10px;
}
.head {
  font-weight: bold;
  margin-bottom: 5px;
}
.content {
  min-height: 50px;
}
.cbtn {
  color: steelblue;
}
.btn-group {
  width: 100%;
  text-align: right;
  justify-content: right;
  vertical-align: middle;
  color: rgb(65, 170, 255);
}
</style>
