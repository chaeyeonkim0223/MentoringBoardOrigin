<template>
  <div class="p-3">
    <v-btn
      small
      class="mx-2 write-btn"
      fab
      dark
      color="indigo"
      @click="$router.push({ name: 'BoardWrite' })"
      style="z-index: 1"
    >
      <v-icon dark> mdi-plus </v-icon>
    </v-btn>
    <Table v-if="items.length != 0" :items="items" :headers="headers" :title="'게시물'" />
  </div>
</template>

<script>
import axios from "axios";
// import axios from "@/common/auth.js"
import Table from "./Tables/Table.vue";
export default {
  components: {
    Table,
  },
  methods: {
    // idCheck(id) {},
    goDetail(record) {
      this.pstartNo = record.pstartNo;
      this.$router.push({ name: "BoardDetail", params: { pstartNo: this.pstartNo } });
    },
    goBoardWrite() {
      this.$router.push({ name: "BoardWrite" });
    },
    // async getMentorName(mbrNo) {
    //   await axios.get(`/api/boards/mentor/${mbrNo}`).then((res) => {
    //     res.data.mbrNm;
    //     // console.log(res.data.mbrNm);
    //     this.mentorNameList.push(res.data.mbrNm);
    //     // console.log(this.mentorNameList);
    //     return res.data.mbrNm;
    //   });
    // },
    // async getMentorNameList() {
    //   for (let i = 0; i < this.items.length; i++) {
    //     await this.getMentorName(this.items[i].mbrNo);
    //   }
    // },
    // updateItems() {
    //   this.items.mentorName = this.mentorNameList;
    // },
  },
  // watch: {
  //   mentorNameList(newList) {
  //     console.log(newList);
  //     this.updateItems();
  //   },
  // },
  created() {
    // let mentorNames = [];
    axios.get("/api/boards").then((res) => {
      this.items = res.data;
      console.log(this.items)
      // this.getMentorNameList();
      // this.items.mentorName = this.mentorNameList;
      // console.log(this.items.mentorName);
      // this.updateItems();
    });

    // for (let i = 0; i < this.items.length; i++) {
    //   const promiseMentorName = this.getMentorName(this.items[i].mbrNo);
    //   console.log("@@@" + promiseMentorName);
    //   const getData = () => {
    //     promiseMentorName.then((res) => {
    //       console.log(res);
    //       mentorNames.push(res);
    //     });
    //   };
    //   getData();
    // }
  },
  data() {
    return {
      items: [],
      // text : header , value : 할당될 변수명
      headers: [
        { text: "글번호", value: "pstartNo" },
        { text: "글제목", value: "pstartTitlNm" },
        { text: "멘토이름", value: "mtrNm" },
        { text: "작성자", value: "rgtrNm" },
        { text: "등록일자", value: "regDt" },
        { text: "답변여부", value: "slctnYn" },
      ],
      pstartNo: null,
      mentorNameList: [],
    };
  },
};
</script>
<style scoped>
.write-btn {
  position: absolute;
  z-index: 5000;
  right: 5%;
  top: 7%;
}
</style>
