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
      name: "",
    };
  },
  computed() {

  },
  created() {
    console.log('jwt-access-token\n', localStorage.getItem('jwt-auth-token'));
    console.log('jwt-refresh-token\n', localStorage.getItem('jwt-refresh-token'));
  },
  methods: {
    async login(username, password) {
      console.log(username, password);
      console.log(this.$route);
      username = 'menteeID2';
      password = '1234';
      let params = {
        loginId: username,
        loginPwd: password,
      };

      console.log(params);
      axios
        .post(`api/v1/auth/login`, params)
        .then((res) => {
          console.log(res)
          if (res.data.code === 200) {
            alert('login success');
            console.log('res\n', res)
            console.log(res.headers["jwt-auth-token"]);
            console.log(res.headers["jwt-refresh-token"]);
            localStorage.setItem("jwt-auth-token", res.headers["jwt-auth-token"]);
            localStorage.setItem("jwt-refresh-token", res.headers["jwt-refresh-token"]);
            console.log('jwt-access-token\n', localStorage.getItem('jwt-auth-token'));
            console.log('jwt-refresh-token\n', localStorage.getItem('jwt-refresh-token'));
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