<template>
  <div>

    <input type="radio" id="all" value="all" v-model="picked" @click="getMemberList()">전체보기<br>
    <input type="radio" id="admin" value="MB001" v-model="picked" @click="getMemberTypeList('MB001')">관리자만 보기<br>
    <input type="radio" id="mentor" value="MB002" v-model="picked" @click="getMemberTypeList('MB002')">멘토만 보기<br>
    <input type="radio" id="mentee" value="MB003" v-model="picked" @click="getMemberTypeList('MB003')">멘티만 보기<br>
    <br>
    <span>선택: {{ picked }}</span>

    <Table v-if="items.length !== 0" 
    :items="items" 
    :headers="headers" 
    :title="'회원관리'" />

  </div>
</template>

<script>
import axios from "axios";
axios.defaults.headers.post["Content-Type"] = "application/json";
import Table from "./Tables/Table.vue";

export default {
  components: {
    Table,
  },
  methods: {
    getMemberList() {
      axios.get("/api/admin/memberList").then((res) => {
        console.log(res.data);
        this.items = res.data;
      });
    },
    getMemberTypeList(data) {
      this.picked = data;
      axios.get(`/api/admin/memberList/type/${this.picked}`).then((res) => {
        console.log(res.data);
        this.items = res.data;
      });
    },
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
        { text: "멤버유형", value: "mbrTypeCd" },
        { text: "멘토아이디", value: "mtrId" },
        { text: "회원가입일시", value: "mbrSbscDt" },
        { text: "삭제버튼", value: 'delete', sortable: false},
      ],
      mbrNo: null,
      picked: '',
    };
  },
};
</script>

<style scoped>

</style>