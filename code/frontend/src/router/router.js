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
    path: '/studentsheetover/:username',
    name: 'StudentSheetOver',
    component: StudentSheetOver,
    props: true
  },
  {
    path: '/studentprofilepost/:username',
    name: 'StudentProfilePost',
    component: StudentProfilePost,
    props: true
  },
  {
    path: '/teacherprofilepost/:username',
    name: 'TeacherProfilePost',
    component: TeacherProfilePost,
    props: true
  },
  {
    path: '/studentaddpost/:username',
    name: 'StudentAddPost',
    component: StudentAddPost,
    props: true
  },
  {
    path: '/studentsheet/:username',
    name: 'StudentSheet',
    component: StudentSheet,
    props: true
  },
  {
    path: '/teachersheet/:username',
    name: 'TeacherSheet',
    component: TeacherSheet,
    props: true
  },
  {
    path: '/teachersheetover/:username',
    name: 'TeacherSheetOver',
    component: TeacherSheetOver,
    props: true
  },
  {
    path: '/studentsheetcomment/:username',
    name: 'StudentSheetComment',
    component: StudentSheetComment,
    props: true
  },
  {
    path: '/teachersheetbuild/:username',
    name: 'TeacherSheetBuild',
    component: TeacherSheetBuild,
    props: true
  },
  {
    path: '/studentsheetmine/:username',
    name: 'StudentSheetMine',
    component: StudentSheetMine,
    props: true
  },
  {
    path: '/teachersheetmine/:username',
    name: 'TeacherSheetMine',
    component: TeacherSheetMine,
    props: true
  },
  {
    path: '/studentsheetongoing/:username',
    name: 'StudentSheetOngoing',
    component: StudentSheetOngoing,
    props: true
  },
  {
    path: '/teachersheetongoing/:username',
    name: 'TeacherSheetOngoing',
    component: TeacherSheetOngoing,
    props: true
  },
  {
    path: '/studentpostpage/:username',
    name: 'StudentPostPage',
    component: StudentPostPage,
    props: true
  },
  {
    path: '/teacherpostpage/:username',
    name: 'TeacherPostPage',
    component: TeacherPostPage,
    props: true
  },
  {
    path: '/teacheraddpost/:username',
    name: 'TeacherAddPost',
    component: TeacherAddPost,
    props:true
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export default router;
