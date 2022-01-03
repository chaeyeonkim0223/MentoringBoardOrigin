<template>
  <div>

    <v-container class="d-flex align-end flex-row-reverse">
    <v-chip-group
      v-model="selected"
      column
      multiple
      color="light-blue accent-4"
    >
      <v-chip dense value="MB001" @click="getMemberTypeList('MB001')">관리자</v-chip>
      <v-chip dense value="MB002" @click="getMemberTypeList('MB002')">멘토</v-chip>
      <v-chip dense value="MB003" @click="getMemberTypeList('MB003')">멘티</v-chip>
    </v-chip-group>
    </v-container>
    
    <Table
    :items="items" 
    :headers="headers" 
    :title="'회원 관리'" />

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
    getMemberTypeList(mbrType) {
      this.items = this.allItems.filter(m => {
        if (this.selected.includes(m.mbrTypeCd) && m.mbrTypeCd == mbrType) { 
          return false; 
        } else if (!this.selected.includes(m.mbrTypeCd) && m.mbrTypeCd == mbrType) { 
          return true; 
        }
        return this.selected.includes(m.mbrTypeCd);
      });
    },
  },
  created() {
    axios.get("/api/admin/memberList").then((res) => {
      console.log(res.data);
      this.items = res.data;
      this.allItems = res.data;
    });
  },
  data() {
    return {
      checkItems: ["멘토", "멘티"],
      selected: ['MB001', 'MB002', 'MB003'],
      allItems: [],
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
      dialog: false,
      snackbar: false,
    };
  },
};
</script>

<style scoped>

</style>