<template>
  <v-card>
    <v-card-title>
      {{ title }}
      <v-spacer></v-spacer>
    </v-card-title>

    <v-data-table
      :headers="headers"
      :items="items"
      :search="search"
    >
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
    };
  },
  methods: {
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
