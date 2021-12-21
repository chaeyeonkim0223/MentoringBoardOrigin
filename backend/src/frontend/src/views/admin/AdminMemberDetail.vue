<template>

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
    axios.get("/api/member").then((res) => {
      this.item = res.data;
    })
  },
  data() {
    return {
      item: {},
      input: String,
    }
  },
}
</script>

<style scoped>

</style>