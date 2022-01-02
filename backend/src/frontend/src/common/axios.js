import axios from 'axios';
//import VueCookies from 'vue-cookies';
//import { refreshToken } from '../service/login'

//axios.defaults.baseURL = 'http://localhost:8081';

// Add a request interceptor
axios.interceptors.request.use(async function (config) {
    //https://kdinner.tistory.com/60
    // Do something before request is sent
    config.headers['jwt-auth-token'] = localStorage.getItem('jwt-auth-token');
    config.headers['jwt-refresh-token'] = localStorage.getItem('jwt-refresh-token');
    console.log(config);
    return config;
  }, function (error) {
    // Do something with request error
    return Promise.reject(error);
  });

// Add a response interceptor
axios.interceptors.response.use(function (response) {
    // Any status code that lie within the range of 2xx cause this function to trigger
    // Do something with response data
    return response;
  }, async function (error) {
    // Any status codes that falls outside the range of 2xx cause this function to trigger
    // Do something with response error
    console.log('에러일 경우', error.config);
    const errorAPI = error.config;
    if(error.response.data.status===401 && errorAPI.retry===undefined){
      errorAPI.retry = true;
      console.log('토큰이 이상한 오류일 경우');
      //await refreshToken();
      return await axios(errorAPI);
    }
    return Promise.reject(error);
  });


export default axios;