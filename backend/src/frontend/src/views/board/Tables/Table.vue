<template>
  <v-card>
    <v-card-title>
      {{ title }}
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="items"
      :search="search"
      @click:row="goDetail"
    ></v-data-table>
  </v-card>
</template>

<script>
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
      console.log(record);
      this.pstartNo = record.pstartNo;
      this.$router.push({ name: "BoardDetail", params: { pstartNo: this.pstartNo } });
    },
  },
};
</script>
<style scoped>
.v-sheet.v-card {
  box-shadow: none !important;
}
</style>
