import { createRouter, createWebHistory } from 'vue-router';
import SigninPage from '@/components/SigninPage';
import TeacherProfile from '@/components/TeacherProfile';
import StudentProfile from '@/components/StudentProfile';
import TeacherSheetOver from '@/components/TeacherSheetOver';
import StudentSheetOver from '@/components/StudentSheetOver';
// import StudentProfilePost from '@/components/StudentProfilePost';
import StudentSheet from '@/components/StudentSheet';
import TeacherSheet from '@/components/TeacherSheet';
import StudentSheetComment from '@/components/StudentSheetComment';
import TeacherSheetBuild from '@/components/TeacherSheetBuild';
import StudentSheetMine from '@/components/StudentSheetMine';
import TeacherSheetMine from '@/components/TeacherSheetMine';
import StudentSheetOngoing from '@/components/StudentSheetOngoing';
import TeacherSheetOngoing from '@/components/TeacherSheetOngoing';

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
    path: '/studentsheetover',
    name: 'StudentSheetOver',
    component: StudentSheetOver
  },
  // {
  //   path: '/studentprofilepost',
  //   name: 'StudentProfilePost',
  //   component: StudentProfilePost
  // },
  {
    path: '/studentsheet',
    name: 'StudentSheet',
    component: StudentSheet
  },
  {
    path: '/teachersheet',
    name: 'TeacherSheet',
    component: TeacherSheet
  },
  {
    path: '/teachersheetover',
    name: '/TeacherSheetOver',
    component: TeacherSheetOver
  },
  {
    path: '/studentsheetcomment',
    name: 'StudentSheetComment',
    component: StudentSheetComment
  },
  {
    path: '/teachersheetbuild',
    name: 'TeacherSheetBuild',
    component: TeacherSheetBuild
  },
  {
    path: '/studentsheetmine',
    name: 'StudentSheetMine',
    component: StudentSheetMine
  },
  {
    path: '/teachersheetmine',
    name: 'TeacherSheetMine',
    component: TeacherSheetMine
  },
  {
    path: '/studentsheetongoing',
    name: 'StudentSheetOngoing',
    component: StudentSheetOngoing
  },
  {
    path: '/teachersheetongoing',
    name: 'TeacherSheetOngoing',
    component: TeacherSheetOngoing
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
