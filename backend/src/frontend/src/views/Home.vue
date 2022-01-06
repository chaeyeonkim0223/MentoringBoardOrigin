<template>
  <v-app id="app">

    <v-navigation-drawer
        v-model="drawer"
        app
    >
      <v-sheet
          color="grey lighten-4"
          class="pa-4"
      >

        <div><b>{{ name }}</b>님, 안녕하세요.</div>
        <div>
          <v-btn text x-small elevation="0" color="light-blue darken-4">로그인</v-btn>
          <v-btn text x-small elevation="0" color="light-blue darken-4">회원가입</v-btn>
        </div>
      </v-sheet>

      <v-list>
        <v-list-item @click="$router.push({ name: 'BoardView' })">멘토링 게시판</v-list-item>
        <v-list-item @click="$router.push({ name: 'AdminMemberView' })">회원 관리</v-list-item>
        <v-list-item @click="$router.push({ name: 'AdminBoardView' })">게시글 관리</v-list-item>
        <v-list-item @click="$router.push({ name: 'ChartView' })">통계</v-list-item>
        <v-list-item @click="$router.push({ name: 'Dashboard' })">테스트</v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app flat color="white">
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-spacer></v-spacer>
      <Notification ref="notification"></Notification>
    </v-app-bar>

    <v-main class="myLayout">

      <v-container
          class="py-0 px-6"
          fluid
      >
        <v-row>
          <v-col
              cols="12"
          >
              <router-view :key="$route.fullPath"></router-view>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Notification from "./notification/Notification.vue";

export default {
  components: {
    Notification,
  },

  created() {
    // this.$refs.notification.getAlarmHistory();
    // this.$refs.notification.$on('reset', this.reset);
  },

  updated() {
    this.$refs.notification.getAlarmHistory();
    this.$refs.notification.$on('reset', this.reset);
  },

  data: () => ({
    name: '김채연',
    drawer: null,
    links: [
    ],
    message: 3,
    expand: false,
  }),
}
</script>

<style>
  .myLayout {
    padding: 0px 0px 0px 256px !important;
  }
</style>