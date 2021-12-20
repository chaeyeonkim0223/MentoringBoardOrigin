<template>
  <v-app id="inspire">
    <v-app-bar app color="white" flat>
      <v-container class="py-0 fill-height">
        <!--<v-avatar class="mr-10" color="grey darken-1" size="32"></v-avatar>-->
        <v-img alt="logo.png"></v-img>

        <v-btn v-for="link in links" :key="link" text>
          {{ link }}
        </v-btn>
        <!-- <MainMenu /> -->
        <v-spacer></v-spacer>
        <v-btn
          small
          class="mx-2"
          fab
          dark
          color="indigo"
          @click="$router.push({ name: 'BoardWrite' })"
        >
          <v-icon dark> mdi-plus </v-icon>
        </v-btn>
        <v-btn
          small
          class="mx-2"
          fab
          color="red"
          @click="$router.push({ name: 'AdminMemberView' })"
          >
            <v-icon dark>mdi-plus</v-icon>
        </v-btn>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item v-for="n in 5" :key="n" link>
                  <v-list-item-content>
                    <v-list-item-title> List Item {{ n }} </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item link color="grey lighten-4">
                  <v-list-item-content>
                    <v-list-item-title> Refresh </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet min-height="70vh" rounded="lg">
              <!-- <BoardView /> -->
              <router-view></router-view>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
// import MainMenu from "@/components/MainMenu.vue";
// import BoardView from "./board/BoardView.vue";
export default {
  name: "Home",
  components: {
    // Header,
    // MainMenu,
    // BoardView,
  },
  data: () => ({
    links: ["멘토링 게시판"],
  }),
};
</script>
