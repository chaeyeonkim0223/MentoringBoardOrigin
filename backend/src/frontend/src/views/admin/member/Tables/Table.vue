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

      <template v-slot:item.loginId="{ item }">
        <a class="text-decoration-none text-decoration-underline" @click="goMemberDetail(item)">{{item.loginId}}</a>  
      </template>

      <template v-slot:item.delete="{ item }">
        <v-btn text color="error" @click="modalShow = !modalShow">삭제</v-btn>
        <b-modal v-model="modalShow" title="경고"
          @ok="deleteItem(item.mbrNo)">정말 탈퇴시키겠습니까?</b-modal>
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
      modalShow: false,
    };
  },
  methods: {

    goMemberDetail(item) {
      this.mbrNo = item.mbrNo;
      this.$router.push({ name: "AdminMemberDetail", params: { mbrNo: this.mbrNo } });
    },
    
    deleteItem (mbrNo) {
      axios.delete(`/api/admin/memberList/${mbrNo}`).then(() => {
        window.alert("탈퇴완료");
        location.reload();
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
