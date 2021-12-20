<template lang="">
  <div class="p-3">
    <v-text-field
      label="글 제목"
      placeholder="글 제목을 입력하세요"
      v-model="item.pstartTitlNm"
      trim
    ></v-text-field>

    <vue-editor v-model="item.pstartCn"></vue-editor>
    <v-btn class="mt-4" depressed color="primary" @click="ModifyBoard(item)"> 수정완료 </v-btn>
  </div>
</template>
<script>
import axios from "axios";
axios.defaults.headers.post["Content-Type"] = "application/json";

import { VueEditor } from "vue2-editor";
export default {
  components: {
    VueEditor,
  },
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
