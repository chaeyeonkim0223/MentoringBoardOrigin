<template lang="">
  <div class="p-3">
    <v-text-field
      label="글 제목"
      placeholder="글 제목을 입력하세요"
      v-model="pstartTitlNm"
      trim
    ></v-text-field>

    <vue-editor v-model="pstartCn"></vue-editor>
    <div>
      <v-btn small class="mx-2 wirte-btn mt-4" fab dark color="indigo" @click="writeBoard">
        <v-icon dark> mdi-plus </v-icon>
      </v-btn>
    </div>
  </div>
</template>
<script>
import axios from "axios";
// import axios from "@/assets/conf/axiosCondig.js";
axios.defaults.headers.post["Content-Type"] = "application/json";
import { VueEditor } from "vue2-editor";
// import Editor from "./Editor.vue";
export default {
  components: {
    VueEditor,
  },
  data() {
    return {
      pstartTitlNm: "",
      pstartCn: "",
    };
  },
  methods: {
    writeBoard() {
      let self = this;
      const param = {
        pstartTitlNm: this.pstartTitlNm,
        pstartCn: this.pstartCn,
      };
      console.log(param);
      axios
        .post("/api/boards", param)
        .then(function (res) {
          console.log(res.data);
          self.$router.push({ name: "BoardView" });
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
<style lang=""></style>
