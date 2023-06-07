import { createRouter, createWebHistory } from 'vue-router';
import SigninPage from '@/components/SigninPage'
import TeacherProfile from '@/components/TeacherProfile'
import StudentProfile from '@/components/StudentProfile'
import TeacherSheetOver from '@/components/TeacherSheetOver'

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
  },
  {
    path: '/studentprofile',
    name: 'StudentProfile',
    component: StudentProfile
  },
  {
    path: '/teachersheetOver',
    name: 'TeacherSheetOver',
    component: TeacherSheetOver
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;