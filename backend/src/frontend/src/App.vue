<template>
  <v-app>
    <router-view />
  </v-app>
</template>

<script>
// import
//import axios from "axios"
//import HelloWorld from "./components/HelloWorld.vue";

export default {
  name: "App",
  /*
  components: {
    HelloWorld,
  },
  */
};
</script>

<style>
#app {
  font-family: 'GowunDodum-Regular', Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

@font-face {
    font-family: 'GowunDodum-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/GowunDodum-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

</style>
