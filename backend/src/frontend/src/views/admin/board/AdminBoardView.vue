<template>
  <div class="p-3">
    <Table :items="items" :headers="headers" :title="'게시글 관리'" />
  </div>
</template>

<script>
import axios from "axios";
import Table from "./Tables/Table.vue";
export default {
  components: {
    Table,
  },
  methods: {
    goDetail(record) {
      this.pstartNo = record.pstartNo;
      this.$router.push({ name: "AdminBoardDetail", params: { pstartNo: this.pstartNo } });
    },
  },
  created() {
    axios.get("/api/boards").then((res) => {
      this.items = res.data;
    });
  },
  data() {
    return {
      items: [],
      headers: [
        { text: "글번호", value: "pstartNo" },
        { text: "글제목", value: "pstartTitlNm", sortable: false  },
        { text: "멘토이름", value: "mtrNm", sortable: false },
        { text: "작성자", value: "rgtrNm", sortable: false },
        { text: "등록일자", value: "regDt", sortable: false  },
        { text: "답변여부", value: "slctnYn" },
        { text: "", value: "delete", sorted: false},
      ],
      pstartNo: null,
    };
  },
};
</script>
<style scoped>
.wirte-btn {
  position: absolute;
  z-index: 5000;
  right: 5%;
  top: 7%;
}
</style>
