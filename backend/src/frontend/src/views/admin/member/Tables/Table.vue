<template>
  <v-card>
    <v-card-title>
      {{ title }}
      <v-spacer></v-spacer>
      <v-text-field
        class="search-bar"
        v-model="search"
        append-icon="mdi-magnify"
        label="두 글자 이상 검색하세요"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>

    <v-data-table
      :headers="headers"
      :items="items"
      :search="search">
      <!-- @click:row="goMemberDetail"> -->

      <template v-slot:item.loginId="{ item }">
        <a class="text-decoration-none text-decoration-underline" @click="goMemberDetail">{{item.loginId}}</a>  
      </template>

      <template v-slot:item.delete="{ item }">
        <v-btn text color="error" @click="deleteItem(item)">삭제</v-btn>
      </template>
      
    </v-data-table>
  </v-card>
</template>

<script>
import axios from 'axios';
export default {
  props: {
    items: Array,
    headers: Array,
    title: String,
  },
  data() {
    return {
      search: "",
      mbrNo: null,
    };
  },
  methods: {

    goMemberDetail(record) {
      console.log(record);
      this.mbrNo = record.mbrNo;
      this.$router.push({ name: "AdminMemberDetail", params: { mbrNo: this.mbrNo } });
    },
    
    deleteItem (item) {
      axios.delete(`/api/admin/memberList/${item}`).then(() => {
        this.$router.push({ name: "AdminMemberView" });
        window.alert("삭제완료");
      });
    },
  },
};
</script>
<style scoped>
.v-sheet.v-card {
  box-shadow: none !important;
}
.search-bar {
  margin-right: 10%;
}
</style>
