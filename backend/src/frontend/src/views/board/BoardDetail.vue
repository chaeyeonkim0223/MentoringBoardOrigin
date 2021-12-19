<template lang="">
  <div class="p-3">
    <div class="text">
      <h3>
        {{ item.pstartTitlNm }}
      </h3>
      <v-divider></v-divider>
      <p class="text">
        {{ item.rgtrNm }} | {{ item.rgtrMbrCd }} | 작성일 {{ item.regDt }} | 답변여부 :
        {{ item.slctnYn }} | 댓글 수 : {{ item.cmntCnt }}
      </p>
      <v-divider></v-divider>
      <vue-editor class="text editor" v-html="item.pstartCn"></vue-editor>
      <v-divider></v-divider>
    </div>

    <div class="btn-group">
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
  </div>
</template>
<script>
import axios from "axios";
import { VueEditor } from "vue2-editor";
export default {
  components: {
    VueEditor,
  },
  data() {
    return {
      item: {},
      input: String,
    };
  },
  created() {
    axios.get(`/api/boards/${this.$route.params.pstartNo}`).then((res) => {
      this.item = res.data;
      this.input = res.data.pstartCn;
      console.log(this.item);
    });
  },
  methods: {
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
