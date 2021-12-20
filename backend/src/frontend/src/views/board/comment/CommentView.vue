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
      </div>
    </div>
    <!-- 댓글 수정하는 form -->
    <!-- <div v-if="isModifyShow" class="comment">
      <div class="head">{{ c_cmt.userid }}</div>
      <div class="content">
        <v-textarea v-model="c_cmt.content" solo></v-textarea>
      </div>
      <v-row class="mb-3" offset-lg11>
        <v-col class="text-muted">{{ c_cmt.regtime }}</v-col>
        <v-col cols="1" class="cbtn text-right">
          <button @click="modify">확인</button> |
          <button @click="cancle">취소</button>
        </v-col>
      </v-row>
    </div> -->
  </div>
</template>
<script>
export default {
  props: ["comment"],
  data() {
    return {
      //현재 댓글이 보기 상태인지 수정 상태인지를 나타낸다
      isModifyShow: false,
      //copy_comment의 약자, props가 변경되는 걸 막기 위해 현재 .vue에서 사용할 comment 복사
      // c_cmt: this.copy_comment(),
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
      // this.isModifyShow = true;
      // // 서버 통신
      // http
      //   .put(`/comment/`, {
      //     bid: this.c_cmt.bid,
      //     seq: this.c_cmt.seq,
      //     content: this.c_cmt.content,
      //   })
      //   .then(({ data }) => {
      //     if (!data) {
      //       let msg = "수정 처리시 문제가 발생했습니다.";
      //       alert(msg);
      //     }
      //     // 수정했으니 댓글 다시 얻기
      //     this.$store.dispatch("getComments", this.c_cmt.bid);
      //     //수정 폼 다시 되돌리기
      //     this.isModifyShow = false;
      //   });
    },
    remove() {
      // if (confirm("정말로 삭제할까요?")) {
      //   http.delete(`/comment/${this.comment.bid}/${this.comment.seq}`).then(({ data }) => {
      //     if (!data) {
      //       let msg = "삭제 처리시 문제가 발생했습니다.";
      //       alert(msg);
      //     }
      //     // 삭제했으니 보여줄 댓글들 다시 얻기.
      //     this.$store.dispatch("getComments", this.comment.bid);
      //   });
      // }
    },
    cancle() {
      this.isModifyShow = false;
      this.c_cmt.content = this.comment.content;
    },
    enterToBr(str) {
      if (str) return str.replace(/(?:\r\n|\r|\n)/g, "<br />");
    },
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
