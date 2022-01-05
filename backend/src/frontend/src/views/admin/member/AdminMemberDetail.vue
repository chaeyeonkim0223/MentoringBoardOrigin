<template>

  <div>
    <div class="h4 d-flex align-start">
      회원 상세페이지<br>
    </div>
    
    <v-divider></v-divider>

    <v-card 
      tile elevation="0" 
      class="d-flex justify-space-around mb-6">
      <v-list
      subheader
      tile
      dense>

        <v-list-item>
          <v-list-item-action>
            <b>이름</b>
          </v-list-item-action>

          <v-list-item-content class="align-center">
            <v-list-item-title>{{ member.mbrNm }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-action>
            <b>아이디</b>
          </v-list-item-action>

          <v-list-item-content class="align-center">
            <v-list-item-title>{{ member.loginId }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-action>
            <b>멤버유형</b>
          </v-list-item-action>

          <v-list-item-content class="align-start">
            <v-list-item-title>{{ member.mbrTypeCd }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-action>
            <b>전화번호</b>
          </v-list-item-action>

          <v-list-item-content class="align-start">
            <v-list-item-title>{{ member.telno }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

      </v-list>


      <v-list
      subheader
      tile
      dense>

        <v-list-item>
          <v-list-item-action>
            <b>멘토아이디</b>
          </v-list-item-action>

          <v-list-item-content class="align-start">
            <v-list-item-title>{{ member.mtrId }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-action>
            <b>멘토이름</b>
          </v-list-item-action>

          <v-list-item-content class="align-start">
            <v-list-item-title>{{ member.mtrNm }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-action>
            <b>가입일시</b>
          </v-list-item-action>

          <v-list-item-content class="align-start">
            <v-list-item-title>{{ member.mbrSbscDt }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

      </v-list>
    </v-card>

    <v-divider></v-divider>

    <DetailTable
    :items="items"
    :headers="headers"
    :title="'로그인 이력'" />
  </div>

</template>

<script>
import axios from "axios";
axios.defaults.headers.post["Content-Type"] = "application/json";
import DetailTable from "./Tables/DetailTable.vue";

export default {
  components: {
    DetailTable,
  },
  methods: {
  },
  created() {
    axios.get(`/api/member/${this.$route.params.mbrNo}`).then((res) => {
      this.member = res.data[0];
    });

    axios.get(`/api/memberLogin/${this.$route.params.mbrNo}`).then((res) => {
      this.items = res.data;
      console.log(this.items);
    });
  },
  data() {
    return {
      member: {},
      items: [],
      headers: [
        { text: "번호", value: "mbrLoginSeq" , sortable: false },
        { text: "로그인 아이디", value: "loginId" , sortable: false },
        { text: "로그인 IP", value: "loginIp" , sortable: false },
        { text: "로그인 일시", value: "loginDt" },
      ],
    }
  },
}
</script>

<style scoped>

</style>