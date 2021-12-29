<template>
  <v-app id="inspire">

    <v-navigation-drawer
        v-model="drawer"
        app
    >
      <v-sheet
          color="grey lighten-4"
          class="pa-4"
      >
        <v-avatar
            class="mb-4"
            color="grey darken-1"
            size="64"
        ></v-avatar>

        <div>john@vuetifyjs.com</div>
      </v-sheet>

      <v-divider></v-divider>

      <v-list>
        <v-list-item @click="$router.push({ name: 'BoardView' })">멘토링 게시판</v-list-item>
        <v-list-item @click="$router.push({ name: 'AdminMemberView' })">회원 관리</v-list-item>
        <v-list-item @click="$router.push({ name: 'AdminBoardView' })">게시글 관리</v-list-item>
        <v-list-item @click="$router.push({ name: 'ChartView' })">통계</v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app flat color="white">
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-spacer></v-spacer>
      <Notification></Notification>
    </v-app-bar>

    <v-main>

      <v-container
          class="py-8 px-6"
          fluid
      >
        <v-row>
          <v-col
              cols="12"
          >
              <router-view></router-view>
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

  data: () => ({
    drawer: null,
    links: [
    ],
    message: 3,
    expand: false,
  }),
}
</script>