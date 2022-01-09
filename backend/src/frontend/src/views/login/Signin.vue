<template>
  <div>
    <h1>회원가입 화면 입니다.</h1>
    <div>
      <label for="username">이름</label>
      <input id="username" type="text" v-model="userid" />
    </div>
    <div>
      <label for="userid">아이디</label>
      <input id="username" type="text" v-model="userid" />
    </div>
    <div>
      <label for="telno">전화번호</label>
      <input id="telno" type="text" v-model="password" />
    </div>
    <div>
      <label for="password">비밀번호</label>
      <input id="password" type="text" v-model="password" />
    </div>
    <div>
      <label for="password">비밀번호 확인</label>
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