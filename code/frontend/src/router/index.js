import { createRouter, createWebHistory } from 'vue-router'
import TeacherProfile from '../components/TeacherProfile.vue'
import TeacherSheet from '../components/TeacherSheet.vue'
import StudentProfile from '../components/StudentProfile.vue'

const routes = [
  {
    path: '/teacherprofile',
    name: 'TeacherProfile',
    component: TeacherProfile
  },
  {
    path: '/teachersheet',
    name: 'TeacherSheet',
    component: TeacherSheet
  },
  {
    path:'/studentprofile',
    name: 'StudentProfile',
    component: StudentProfile
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router