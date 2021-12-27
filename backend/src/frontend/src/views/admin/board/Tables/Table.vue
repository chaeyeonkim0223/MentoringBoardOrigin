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
      :search="search"
    >

      <template v-slot:item.pstartTitlNm="{ item }">
        <a class="text-decoration-none text-decoration-underline" @click="goDetail(item.pstartNo)">{{item.pstartTitlNm}}</a>  
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
      pstartNo: null,
      search: "",
    };
  },
  methods: {
    goDetail(record) {
      this.pstartNo = record;
      this.$router.push({ name: "AdminBoardDetail", params: { pstartNo: this.pstartNo } });
    },
    deleteItem(item) {
      axios.delete(`/api/boards/${Number(item.pstartNo)}`).then((res) => {
        this.item = res.data;
        console.log(this.item);
        window.alert("삭제완료");
        this.$router.push({ name: "AdminBoardView" });
      });
    }
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
