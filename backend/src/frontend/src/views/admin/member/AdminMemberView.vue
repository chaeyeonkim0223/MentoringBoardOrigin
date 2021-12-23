<template>
  <div>

    <v-card class="d-flex align-end flex-row-reverse">
        <v-radio-group v-model="picked" row>
            <v-radio style="font-size: 3px" label="전체보기" color="primary" value="all" @click="getMemberList()" ></v-radio>
            <v-radio label="관리자만 보기" color="primary" value="MB001" @click="getMemberTypeList('MB001')"></v-radio>
            <v-radio label="멘토만 보기" color="primary" value="MB002" @click="getMemberTypeList('MB002')"></v-radio>
            <v-radio label="멘티만 보기" color="primary" value="MB003" @click="getMemberTypeList('MB003')"></v-radio>
        </v-radio-group>
    </v-card>
    
    <Table
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
    goMemberDetail(record) {
      this.mbrNo = record.mbrNo;
      this.$router.push({ name: "AdminMemberDetail", params: { mbrNo: this.mbrNo } }); 
    },
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
        { text: "이름", value: "mbrNm", sortable: false },
        { text: "아이디", value: "loginId", sortable: false },
        // { text: "전화번호", value: "telno", sortable: false },
        { text: "멤버유형", value: "mbrTypeCd", sortable: false },
        { text: "멘토아이디", value: "mtrId", sortable: false },
        // { text: "회원가입일시", value: "mbrSbscDt", sortable: false },
        { text: "", value: "delete", sortable: false},
      ],
      mbrNo: null,
      picked: '',
      dialog: false,
    };
  },
};
</script>

<style scoped>

</style>