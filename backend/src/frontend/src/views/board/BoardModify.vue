<template lang="">
  <div>
    {{ JSON.stringify(item) }}
    <b-input v-model="item.pstartTitlNm"></b-input>
    <b-input v-model="item.pstartCn"></b-input>
    <b-button @click="ModifyBoard(item)">수정완료</b-button>
  </div>
</template>
<script>
import axios from "axios";
// import axios from "@/assets/conf/axiosCondig.js";
axios.defaults.headers.post["Content-Type"] = "application/json";
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
    ModifyBoard(item) {
      let self = this;
      axios
        .put("/api/boards", item)
        .then(function (res) {
          console.log(res.data);
          self.$router.push({ name: "BoardDetail", params: { pstartNo: res.data.pstartNo } });
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
<style lang=""></style>
