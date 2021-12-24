<template>
  <v-app id="inspire">
    <v-system-bar app>
      <v-spacer></v-spacer>
    </v-system-bar>

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
      </v-list>
    </v-navigation-drawer>

      <!-- 알람 -->
      <v-card
        class="d-flex flex-row-reverse"
        flat
      >
        <v-icon color="white">mdi-circle</v-icon>
        <v-icon color="white">mdi-circle</v-icon>
        <v-btn
          class="ma-2"
          icon
          @click="expand = !expand"
        >
          <v-icon large color="indigo lighten-2">mdi-bell</v-icon>
          <v-badge 
            :content="message"
            :value="message"
            bordered color="red" 
            offset-x="8" offset-y="0"
            ></v-badge>
        </v-btn>
        <v-expand-x-transition>
          <v-card
            v-show="expand"
            height="100"
            width="100"
            class="mx-auto secondary"
          >
            <v-list dense>
              <v-subheader>REPORTS</v-subheader>
              
            </v-list>          
          </v-card>
        </v-expand-x-transition>
      </v-card>
      <!-- 여까지 -->

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
export default {
  data: () => ({
    drawer: null,
    links: [
    ],
    message: 3,
    expand: false,
  }),
}
</script>