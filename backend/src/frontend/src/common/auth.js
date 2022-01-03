import axios from "axios";

export default {
      sendRefreshToken: async function() {
      let params = {
        type: 'refresh-token'
      }
      let result = false
      await axios
      .post(`/api/v1/auth/checkToken`, params)
      .then((res) => {
        console.log(res)
        if (res.data.code === 200) {
          console.log('get auth token success')
        } else {
          result = true
          console.log('get auth token fail')
        }
      })
      .catch(function (e) {
        console.log(e);
      });
      return result
    },
    sendAccessToken: async function() {
    let params = {
      type: 'access-token'
    }
    let result = false
    await axios
    .post(`/api/v1/auth/checkToken`, params)
    .then((res) => {
      console.log(res)
      if (res.data.code === 200) {
        console.log('get auth token success')
      } else {
        result = true
        console.log('get auth token fail')
      }
    })
    .catch(function (e) {
      console.log(e);
    })
    return result
  }
}