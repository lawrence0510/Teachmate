import { createRouter, createWebHashHistory } from 'vue-router';
import SigninPage from '@/components/SigninPage';
import TeacherProfile from '@/components/TeacherProfile';
import StudentProfile from '@/components/StudentProfile';
import TeacherSheetOver from '@/components/TeacherSheetOver';
import StudentSheetOver from '@/components/StudentSheetOver';
import StudentProfilePost from '@/components/StudentProfilePost';
import TeacherProfilePost from '@/components/TeacherProfilePost';
import StudentSheet from '@/components/StudentSheet';
import TeacherSheet from '@/components/TeacherSheet';
import StudentSheetComment from '@/components/StudentSheetComment';
import TeacherSheetBuild from '@/components/TeacherSheetBuild';
import StudentSheetMine from '@/components/StudentSheetMine';
import TeacherSheetMine from '@/components/TeacherSheetMine';
import StudentSheetOngoing from '@/components/StudentSheetOngoing';
import TeacherSheetOngoing from '@/components/TeacherSheetOngoing';
import StudentAddPost from '@/components/StudentAddPost';
import StudentPostPage from '@/components/StudentPostPage';
import TeacherPostPage from '@/components/TeacherPostPage';
import TeacherAddPost from '@/components/TeacherAddPost';

const routes = [
  {
    path: '/',
    name: 'Signin',
    component: SigninPage
  },
  {
    path: '/teacherprofile/:username',
    name: 'TeacherProfile',
    component: TeacherProfile,
    props: true
  },
  {
    path: '/studentprofile/:username',
    name: 'StudentProfile',
    component: StudentProfile,
    props: true
  },
  {
    path: '/studentsheetover',
    name: 'StudentSheetOver',
    component: StudentSheetOver
  },
  {
    path: '/studentprofilepost',
    name: 'StudentProfilePost',
    component: StudentProfilePost
  },
  {
    path: '/teacherprofilepost',
    name: 'TeacherProfilePost',
    component: TeacherProfilePost
  },
  {
    path: '/studentaddpost',
    name: 'studentaddpost',
    component: StudentAddPost
  },
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
  },
  {
    path: '/studentpostpage',
    name: 'StudentPostPage',
    component: StudentPostPage
  },
  {
    path: '/teacherpostpage',
    name: 'TeacherPostPage',
    component: TeacherPostPage
  },
  {
    path: '/teacheraddpost',
    name: 'TeacherAddPost',
    component: TeacherAddPost
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export default router;
