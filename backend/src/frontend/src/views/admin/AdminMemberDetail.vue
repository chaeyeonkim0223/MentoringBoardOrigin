<template>

  <div>
    <Table :items="memberHistory" :headers="headers" :title="'로그인 이력'" />
  </div>

</template>

<script>
import axios from "axios";
axios.defaults.headers.post["Content-Type"] = "application/json";
import Table from "./Tables/DetailTable.vue";

export default {
  components: {
    Table,
  },
  methods: {
  },
  created() {
    axios.get(`/api/member/${this.$route.params.mbrNo}`).then((res) => {
      this.member = res.data;
      console.log(this.item);
    });
    axios.get(`/api/memberLogin/${this.$route.params.mbrNo}`).then((res) => {
      this.memberHistory = res.data;
      console.log(this.memberHistory);
    });
  },
  data() {
    return {
      member: {},
      memberHistory: {},
      headers: [
        { text: "번호", value: "mbrLoginSeq" },
        { text: "로그인 아이디", value: "loginId" },
        { text: "로그인 IP", value: "loginIp" },
        { text: "로그인 일시", value: "loginDt" },
      ],
    }
  },
}
</script>

<style scoped>

</style>