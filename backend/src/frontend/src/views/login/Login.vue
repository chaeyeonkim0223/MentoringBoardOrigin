    <template>
      <div>
        <h1>JWT 회원가입 화면 입니다.</h1>
          <button @click="login('testid1', 'testpwd')">rt22est</button>
          <form @submit.prevent="formSubmit" method="post">
            <div>
              <label for="email">email</label>
              <input id="email" type="text" v-model="email" />
            </div>
            <div>
              <label for="password">password</label>
              <input id="password" type="text" v-model="password" />
            </div>
            <button type="submit">Register</button>
          </form>
      </div>
    </template>

    <script>
    import axios from "axios";
    export default {
      name: "JwtResiter",
      components: {},
      data() {
        return {
          email: "",
          password: "",
          name: "",
        }
      },
      computed: {},
      created() {
        console.log('created test')
        axios.get("/api/boards").then((res) => {
          this.items = res.data;
        });
      },
      methods: {
        async login(username, password) {
          console.log(username, password)
          console.log(axios)
          console.log(this.$route)

          let params = {
            'loginId': 'aa',
            'loginPwd': 'aaa'
          }
          console.log(params)
          axios.post(`/v1/auth/login`, params).then((res) => {
            console.log(res.headers['jwt-auth-token'])
            localStorage.setItem('jwt-auth-token', res.headers['jwt-auth-token']);
            localStorage.getItem('jwt-auth-token')
          }).catch(function(e){
            console.log(e)
          });
          
        }
      },
    }
    </script>

    <style scoped></style>