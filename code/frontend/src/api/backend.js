import axios from 'axios';

const backendApi = axios.create({
  baseURL: 'http://localhost:8000',
});

export default {
  signUp(formData) {
    return backendApi.post('/register', formData);
  },

  signIn(formData) {
    return backendApi.post('/signin', formData);
  },

  buildContract(formData){
    return backendApi.post('/buildcontract', formData);
  },

  Contractgradecomment(formData){
    return backendApi.post('/contractgradecomment', formData);
  },

  buildTeacherPost(formData){
    return backendApi.post('/buildteacherpost', formData);
  },

  buildStudentPost(formData){
    return backendApi.post('/buildstudentpost', formData);
  },

};
