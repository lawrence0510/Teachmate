import axios from 'axios';

const backendApi = axios.create({
  baseURL: 'http://localhost:3306', // 根據您的後端伺服器配置設定正確的 baseURL
});

export default {
  signUp(formData) {
    return backendApi.post('/register', formData);
  },

  signIn(formData) {
    return backendApi.post('/signin', formData);
  },
};
