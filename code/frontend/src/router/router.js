import { createRouter, createWebHistory } from 'vue-router';
import SigninPage from '@/components/SigninPage'
import TeacherProfile from '@/components/TeacherProfile'

const routes = [
  {
    path: '/',
    name: 'Signin',
    component: SigninPage
  },
  {
    path: '/teacherprofile',
    name: 'TeacherProfile',
    component: TeacherProfile
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;