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
  submitProfession(formData){
    return backendApi.post('/submitprofession', formData);
  },

  submitWorkingExperience(formData){
    return backendApi.post('/submitworkingexperience', formData);
  },
  sendStudentRequestToBackend(formData){
    return backendApi.post('/studentrequest', formData);
  },

  sendTeacherRequestToBackend(formData){
    return backendApi.post('/teacherrequest', formData);
  }
};
