<template>
  <div>
    <h1>JWT 회원가입 화면 입니다.</h1>
    <div>
      <label for="userid">userid</label>
      <input id="userid" type="text" v-model="userid" />
    </div>
    <div>
      <label for="password">password</label>
      <input id="password" type="text" v-model="password" />
    </div>
    <button @click="login(this.userid, '1234')">Login</button>
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
      name: "",
    };
  },
  computed() {

  },
  created() {

  },
  methods: {
    async login(username, password) {
      console.log(username, password);
      console.log(this.$route);

      let params = {
        loginId: username,
        loginPwd: password,
      };

      console.log(params);
      axios
        .post(`api/v1/auth/login`, params)
        .then((res) => {
          if (res.data === 'login Success') {
            alert('login success');
            console.log(res.headers["jwt-auth-token"]);
            localStorage.setItem("jwt-auth-token", res.headers["jwt-auth-token"]);
            console.log(localStorage.getItem('jwt-auth-token'));
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
      alert('logout');
      console.log(localStorage.getItem('jwt-auth-token'));
    }
  },
};
</script>

<style scoped></style>