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
      @click:row="goDetail"
    ></v-data-table>
  </v-card>
</template>

<script>
// import axios from "axios";
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
    // async getMentorName(mbrNo) {
    //   let mentorName = await axios.get(`/api/boards/mentor/${mbrNo}`).then((res) => {
    //     // console.log("멘토이름가져옴");
    //     // console.log(res.data);
    //     return res.data.mbrNm;
    //   });
    //   return mentorName;
    // },
  },
  mounted() {
    // this.getMentorName(3);
    // let self = this;
    // const a = self.items.map((item) => {
    //   return
    //   // return self.checkMemberCode(item.rgtrMbrCd);
    // });
    // for (let i = 0; i < this.items.length; i++) {
    //   this.getMentorName(this.items[i].mbrNo).then((val) => {
    //     this.items[i].mentorName = val;
    //     console.log(this.items[i]);
    //     console.log("promise" + val);
    //   });
    //   console.log("for문");
    //   // console.log(this.items[i].mentorName);
    // }
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
