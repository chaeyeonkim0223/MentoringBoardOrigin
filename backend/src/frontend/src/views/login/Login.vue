<template>
  <div>
    <h1>로그인 화면 입니다.</h1>
    <div>
      <label for="userid">userid</label>
      <input id="userid" type="text" v-model="userid" />
    </div>
    <div>
      <label for="password">password</label>
      <input id="password" type="text" v-model="password" />
    </div>
    <button @click="login(userid, password)">Login</button>
    <br/>
    <button @click="logout()">Logout</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "JwtLogin",
  components: {},
  data() {
    return {
      userid: "",
      password: "",
      name: ""
    };
  },
  computed() {
  },
  created() {
  },
  methods: {
    async login(username, password) {
      let params = {
        loginId: username,
        loginPwd: password,
      };

      axios
        .post(`api/v1/auth/login`, params)
        .then((res) => {
          if (res.data.code === 200) {
            localStorage.setItem("jwt-auth-token", res.headers["jwt-auth-token"]);
            localStorage.setItem("jwt-refresh-token", res.headers["jwt-refresh-token"]);
            let userInfoList = res.data.resData.user;
            for(let key in userInfoList) {
              if(userInfoList[key] !== null) {
                this.$cookies.set(key, userInfoList[key]);
              }
            }
            alert('login success');
            this.$router.push('/');
          } else {
            alert('login fail');
          }
        })
        .catch(function (e) {
          console.log(e);
        });
    },
    logout() {
      localStorage.removeItem("jwt-auth-token");
      localStorage.removeItem("jwt-refresh-token");
      alert('logout');
    }
  },
};
</script>

<style scoped></style>