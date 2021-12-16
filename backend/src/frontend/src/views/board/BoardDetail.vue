<template lang="">
  <div>
    {{ JSON.stringify(item) }}
    <b-button v-if="checkMyPost(item.pstartNo)" @click="goModify(item.pstartNo)">수정</b-button>
    <b-button v-if="checkMyPost(item.pstartNo)" @click="deleteBoard(item.pstartNo)">삭제</b-button>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      item: {},
    };
  },
  created() {
    axios.get(`/api/boards/${this.$route.params.pstartNo}`).then((res) => {
      this.item = res.data;
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
<style lang=""></style>
