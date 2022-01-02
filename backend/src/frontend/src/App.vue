<template>
  <v-app>
    <router-view />
  </v-app>
</template>

<script>
// import
import axios from "axios"

// axios 인터셉터 등록(axios 호출 시 인증토큰 세팅, http session token 세팅 작업을 함)
// 호출 전
axios.interceptors.request.use(
  function(config) {
    const jwtAuthToken = localStorage.getItem("jwt-auth-token")
    const jwtRefreshToken = localStorage.getItem("jwt-refresh-token")

    if(jwtAuthToken != null && jwtAuthToken != '') {
      config.headers.common["jwt-auth-token"] = jwtAuthToken
    }

    if(jwtRefreshToken != null && jwtRefreshToken != '') {
      config.headers.common["jwt-refresh-token"] = jwtRefreshToken
    }
    return config;
  }
)

// 호출 후
axios.interceptors.response.use(
  function(response) {
    //const jwtAuthToken = response.headers["jwt-auth-token"]
    //const jwtRefreshToken = response.headers["jwt-refresh-token"]
    if(response.data.code != 200) return response
    //json 값으로 내리도록 로직 변경
    const jwtAuthToken = response.data.resData.accessToken;
    const jwtRefreshToken = response.data.resData.refreshToken;
    

    if(jwtAuthToken != null && jwtAuthToken != '') {
      console.log("access token 응답", jwtAuthToken)
      localStorage.setItem("jwt-auth-token", jwtAuthToken)
      console.log(localStorage.getItem("jwt-auth-token"))
    }

    if(jwtRefreshToken != null && jwtRefreshToken != '') {
      console.log("refresh token 응답", jwtRefreshToken)
      localStorage.setItem("jwt-refresh-token", jwtRefreshToken)
    }

    return response;
  }
)


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
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
