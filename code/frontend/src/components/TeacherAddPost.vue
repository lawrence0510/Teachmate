<template>
   <div class="content-container">
      <!-- 把footer以外的內容包起來 -->

      <div class="header_section">
         <div class="container-fluid ">
            <div class="row">
               <div class="col-sm-2 col-6">

               </div>
               <div class="col-sm-8 col-6">
                  <nav class="navbar navbar-expand-lg navbar-light bg-light">

                     <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                           <li class="nav-item">
                              <a class="nav-link" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png"
                                    width="35" height="35"></a>

                           </li>
                           <li class="nav-item teacherprofile">
                              <router-link :to="{ name: 'TeacherPostPage', params: { username: this.username } }"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 POST
                              </router-link>
                           </li>
                           <li class="nav-item teacherprofile">
                              <router-link :to="{ name: 'TeacherAddPost', params: { username: this.username } }"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 ADD
                              </router-link>
                           </li>
                           <li class="nav-item active teacherprofile">
                              <router-link :to="{ name: 'TeacherProfile', params: { username: this.username } }"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 ABOUT
                              </router-link>
                           </li>
                           <li class="nav-item teacherprofile">
                              <router-link :to="{ name: 'TeacherSheet', params: { username: this.username } }"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 SHEET
                              </router-link>
                           </li>
                           <li class="nav-item teacherprofile">
                              <a class="button_set_head button_set2_head nav-link"
                                 href="https://www.youtube.com/watch?v=VV0PxIV5V-Y" target="_blank">MORE</a>
                           </li>
                           <li class="nav-item">
                              <a class="nav-link" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png"
                                    width="35" height="35"></a>
                           </li>

                        </ul>
                     </div>
                  </nav>
               </div>
            </div> <!-- <div class="row"> -->
         </div>
      </div>
      <!-- header section end -->
      <!-- contact section start -->
      <div class="sheet_div_title">
         <div class="sheet_div_title2">
         </div>
      </div>

      <div class="pp_post_column">
         <div class="pp_post">
            <div class="pp_post_item">
               <div class="pp_label">Subject:</div>
               <input type="text" placeholder="subject" class="pp_data" style="width: 100px;" v-model="subject">
            </div>

            <div class="pp_post_item">
               <div class="pp_label">Name:</div>
               {{ username }}
            </div>

            <div class="pp_post_item">
               <div class="pp_label">Email:</div>
               <div v-if="teacherinfo.length > 0" class="pp_data">{{teacherinfo[0].Gmail }}</div>
            </div>

            <div class="pp_post_item">
               <div class="pp_label">Phone:</div>
               <div v-if="teacherinfo.length > 0" class="pp_data">0{{teacherinfo[0].PhoneNum }}</div>
            </div>

            <div class="pp_post_item">
               <div class="pp_label">Gender:</div>
               <div v-if="teacherinfo.length > 0" class="pp_data">{{teacherinfo[0].Gender }}</div>
            </div>

            <div class="pp_post_item">
               <div class="pp_label">Age:</div>
               <div v-if="teacherinfo.length > 0" class="pp_data">{{teacherinfo[0].Age }}</div>
            </div>

            <div class="pp_post_item">
               <div class="pp_label">MBTI:</div>
               <div v-if="teacherinfo.length > 0" class="pp_data">{{teacherinfo[0].MBTI }}</div>
            </div>
            <div class="pp_post_item">
               <div class="pp_label">Region:</div>
               <div v-if="teacherinfo.length > 0" class="pp_data">{{teacherinfo[0].Region }}</div>
            </div>

            <div class="pp_post_item">
               <div class="pp_label">School:</div>
               <div v-if="teacherinfo.length > 0" class="pp_data">{{teacherinfo[0].School }}</div>
            </div>

            <div class="pp_post_item">
               <div class="pp_label">Major:</div>
               <div v-if="teacherinfo.length > 0" class="pp_data">{{teacherinfo[0].Major }}</div>
            </div>

            <div class="pp_post_item">
               <div class="pp_label">Note:</div>
               <input type="text" placeholder="note" class="pp_data" style="width: 100px;" v-model="note">
            </div>
         </div>
      </div>

      <router-link :to="{ name: 'TeacherProfile', params: { username: this.username } }">
      <button class="sap_addbutton" @click="buildTeacherPost">add</button></router-link>







      <!-- 新增的code -->
      <div id="posts" class="text_l">
         <!-- Posts will be dynamically added here -->
      </div>

      <div class="contact_section_2 layout_padding">
         <div class="container-fluid">
            <div class="row">

            </div>
         </div>
      </div>

      <!-- footer section start -->
      <div class="copyright_section">
         <div class="container">
            <p class="copyright_text">NCCU MIS 111-2 DBMS<br>G9：TEACHMATE</p><!-- 改 -->
         </div>
      </div>
      <!-- footer section end -->

   </div>
</template>

<script>
/* eslint-disable */
import backend from '@/api/backend.js';
import axios from 'axios';
//跟後端溝通

export default {
   name: 'TeacherAddPost',
   props: {
      username: String
   },
   data() {
      return {
         teacherinfo: [],
         subject: '',
         major: '',
         region: '',
         note: '',
      };
   },
   mounted() {
      this.getTeacherInfo();
   },
   methods: {
      getTeacherInfo() {
         axios.post('http://localhost:8000/getteacherinfo', {
            username: this.username
         })
            .then(response => {
               this.teacherinfo = response.data;
            })
            .catch(error => {
               console.error(error);
            });
      },
      buildTeacherPost() {
         //these properties correspond to user-entered data
         const formData = {
            subject: this.subject,
            major: this.teacherinfo[0].Major,
            region: this.teacherinfo[0].Region,
            note: this.note,
            userID: this.teacherinfo[0].UserID
         }
         //making a HTTP request to the backend
         backend.buildTeacherPost(formData)
            .then(response => {
               // 處理成功回應
               alert('成功發送文章！')
               console.log('Build Teacher Post successfully!')
            })
            .catch(error => {
               // 處理錯誤
               console.log('Build Teacher Post error occured.')
            });
      },
   }
};

</script>




<style>
@import url("../assets/css/teacheraddpost.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");
</style>