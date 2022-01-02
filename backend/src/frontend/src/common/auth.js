import axios from "axios";
//import axios from "./axios";

export default {
    getAccessToken: function() {
        //let params = JSON.parse(localStorage.getItem('jwt-auth-token'));
        axios
        .post(`api/v1/auth/checkToken`)
        .then((res) => {
          console.log(res)
          if (res.data.code === 200) {
            //console.log('getAccessToken')
            console.log(res.headers["jwt-auth-token"]);
            localStorage.setItem("jwt-auth-token", res.headers["jwt-auth-token"]);
            localStorage.setItem("jwt-refresh-token", res.headers["jwt-refresh-token"]);
            //console.log(localStorage.getItem('jwt-auth-token'));
            return true;
          } else {
            console.log('login fail');
            return false;
          }
        })
        .catch(function (e) {
          console.log(e);
        });
    },
    authHeader: function() {
        // return authorization header with jwt token
        let user = JSON.parse(localStorage.getItem('user'));
    
        if (user && user.token) {
            return { 'Authorization': 'Bearer ' + user.token };
        } else {
            return {};
        }
    }
}