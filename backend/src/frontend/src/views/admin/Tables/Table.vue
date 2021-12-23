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
      @click:row="goMemberDetail">
    </v-data-table>
  </v-card>
</template>

<script>
//import axios from "axios";

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
    deleteMbr() {

    },
    goMemberDetail() {
      console.log();
      this.$router.push({ name: "AdminMemberDetail", params: { mbrNo: this.mbrNo } });
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
