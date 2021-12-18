<template>
  <div>
    <v-checkbox
        v-model="checkItems"
        label="멘토"
        color="indigo darken-3"
        value="mentor"
        hide-details
    ></v-checkbox>
    <v-checkbox
        v-model="checkItems"
        label="멘티"
        color="indigo darken-3"
        value="mentee"
        hide-details
    ></v-checkbox>
    <Table v-if="items.length !== 0" :items="items" :headers="headers" :title="'회원관리'" />
  </div>
</template>

<script>
import axios from "axios";
import Table from "../board/Tables/Table.vue";
export default {
  components: {
    Table,
  },
  created() {
    axios.get("/api/admin/memberList").then((res) => {
      console.log(res.data);
      this.items = res.data;
    });
  },
  data() {
    return {
      checkItems: ["멘토", "멘티"],
      items: [],
      headers: [
        { text: "번호", value: "mbrNo" },
        { text: "이름", value: "mbrNm" },
        { text: "아이디", value: "loginId" },
        { text: "전화번호", value: "telno" },
        { text: "멤버유형", value: "mtrId" },
        { text: "멘토아이디", value: "mtrId" },
        { text: "회원가입일시", value: "mbrSbscDt" },
      ],
      mbrNo: null,
    };
  },
};
</script>

<style scoped>

</style>