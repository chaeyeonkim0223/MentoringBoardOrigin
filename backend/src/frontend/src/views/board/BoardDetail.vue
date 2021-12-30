<template lang="">
  <div class="p-3">
    <div class="text">
      <h3>
        {{ item.pstartTitlNm }}
      </h3>
      <v-divider></v-divider>
      <p class="text">
        {{ item.rgtrNm }} | {{ checkMemberCode(item.rgtrMbrCd) }} | 작성일 {{ item.regDt }} |
        답변여부 : {{ item.slctnYn }} | 댓글 수 : {{ item.cmntCnt }}
      </p>
      <v-divider></v-divider>
      <div class="text editor" v-html="item.pstartCn"></div>
      <!-- <vue-editor ></vue-editor> -->
      <v-divider></v-divider>
    </div>

    <div class="btn-group">
      <v-btn class="m-1" depressed color="primary" @click="$router.push({ name: 'BoardView' })">
        목록
      </v-btn>
      <v-btn
        class="m-1"
        depressed
        color="primary"
        v-if="checkMyPost(item.pstartNo)"
        @click="goModify(item.pstartNo)"
      >
        수정
      </v-btn>
      <v-btn
        class="m-1"
        depressed
        color="error"
        v-if="checkMyPost(item.pstartNo)"
        @click="deleteBoard(item.pstartNo)"
      >
        삭제
      </v-btn>
    </div>
    <!-- 댓글 구간 시작 -->
    <CommentWrite v-if="true" @getCommentInit="getCommentInit" :pstartNo="item.pstartNo" />
    <div v-for="(comment, index) in comments" :key="index">
      <v-divider></v-divider>
      <CommentView :comment="comment" @getCommentInit="getCommentInit" />
    </div>
    <!-- 댓글 구간 끝 -->
  </div>
</template>
<script>
import axios from "axios";
// import { VueEditor } from "vue2-editor";
import CommentWrite from "./comment/CommentWrite.vue";
import CommentView from "./comment/CommentView.vue";
export default {
  components: {
    // VueEditor,
    CommentWrite,
    CommentView,
  },
  data() {
    return {
      item: {},
      input: String,
      comments: [],
    };
  },
  created() {
    axios.get(`/api/boards/${this.$route.params.pstartNo}`).then((res) => {
      this.item = res.data;
      this.input = res.data.pstartCn;
      console.log(this.item);
    });
    axios.get(`/api/comments/${this.$route.params.pstartNo}`).then((res) => {
      this.comments = res.data;
      console.log(this.comments);
    });
  },
  methods: {
    getCommentInit(pstartNo) {
      axios.get(`/api/comments/${pstartNo}`).then((res) => {
        this.comments = res.data;
        console.log(this.comments);
      });
    },
    checkMemberCode(code) {
      if (code == "MB001") return "관리자";
      else if (code == "MB002") return "멘토";
      else if (code == "MB003") return "멘티";
    },
    checkMyPost() {
      //내가 쓴 글이면
      return true;
    },
    goModify(pstartNo) {
      this.$router.push({ name: "BoardModify", params: { pstartNo: pstartNo } });
    },
    deleteBoard(pstartNo) {
      axios.delete(`/api/boards/${Number(pstartNo)}`).then((res) => {
        this.item = res.data;
        console.log(this.item);
        window.alert("삭제완료");
        this.$router.push({ name: "BoardView" });
      });
    },
  },
};
</script>
<style scoped>
.text {
  text-align: left;
}
.editor {
  min-height: 300px;
}
.btn-group {
  width: 100%;
  text-align: right;
  justify-content: right;
}
</style>