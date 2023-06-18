<template>
   <body class="teachersheetbuild">
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

                        </ul>
                     </div>
                  </nav>
               </div>
            </div> <!-- <div class="row"> -->
         </div>
      </div>
      <!-- header section end -->
      <!-- contact section start -->
      <div class="whole">
         <div class="contact_section layout_padding margin_bottom90">


            <div class="contact_section_2 layout_padding">
               <div class="sheet_div_title">
                  <div class="teachersheetbuildsheet_div_title2">BUILD EVALUATION SHEET
                  </div>
               </div>



               <div class="col-md-6">
                  <div class="teachersheetbuildsheet_div">

                     <div class="teachersheetbuildsheet_content_title">
                        TEACHMATE
                     </div>
                     <div class="teachersheetbuildsheet_content_sheet">
                        evaluation sheet
                     </div>
                     <div class="teachersheetbuildsheet_content_t">
                        Teacher：
                     </div>
                     <div class="teachersheetbuildsheet_content_tname">
                        {{ this.username }}
                     </div>
                     <div class="teachersheetbuildsheet_content_s">
                        Student：
                     </div>
                     <input type="text" placeholder="請輸入學生ID" class="teachersheetbuildsheet_content_sid"
                        v-model="studentID">
                     <div class="teachersheetbuildsheet_content_sub">
                        Subject：
                     </div>

                     <input type="text" placeholder="請輸入教學科目" class="teachersheetbuildsheet_content_subname"
                        v-model="subject">
                     <div class="teachersheetbuildsheet_content_time">
                        Time：
                     </div>
                     <input name="date" type="date" id="date" class="teachersheetbuildsheet_content_time_s" v-memo="time1">
                     <div class="teachersheetbuildsheet_content_time_to">~</div>
                     <input name="date" type="date" id="date" class="teachersheetbuildsheet_content_time_e"
                        v-model="time2">
                     <button id="show" class="teachersheetbuildbutton_set" @click="buildContract">Build</button>
                     <dialog id="infoModal">
                        <p>Successfully created.<br>The sheet has been sent to the student.</p>
                        <router-link :to="{name: 'TeacherProfile', params:{username: this.username}}" class="teachersheetbuildbutton_ok" id="close">OK</router-link>
                     </dialog>


                  </div>
               </div>
            </div>
         </div>
      </div>


      <div class="contact_section_2 layout_padding">
         <div class="container-fluid">
            <div class="row">

            </div>
         </div>
      </div>
      <!-- contact section end -->

      <!-- copyright section start -->
      <div class="copyright_section">
         <div class="container">
            <p class="copyright_text">NCCU MIS 111-2 DBMS<br>G9：TEACHMATE</p><!-- 改 -->
         </div>
      </div>
   </body>
</template>

<script>
/* eslint-disable */
import backend from '@/api/backend.js';
export default {
   name: 'TeacherSheetBuild',
   props: {
      username: String
   },
   data() {
      return {
         time1: '',
         time2: '',
         studentID: '',
         subject: '',
      };
   },
   mounted() {
      let btn = document.querySelector("#show");
      let infoModal = document.querySelector("#infoModal");
      let close = document.querySelector("#close");

      // 初始隐藏 dialog 元素
      infoModal.style.display = "none";

      btn.addEventListener("click", function () {
         infoModal.style.display = "block"; 
         infoModal.showModal(); 
      });

      close.addEventListener("click", function () {
         infoModal.close();
         infoModal.style.display = "none"; // 隐藏 dialog 元素
      });

   },
   methods: {
      buildContract() {
         //these properties correspond to user-entered data
         const formData = {
            time1: this.time1,
            time2: this.time2,
            studentID: this.studentID,
            subject: this.subject,
         }
         console.log(formData)
         //making a HTTP request to the backend
         backend.buildContract(formData)
            .then(response => {
               // 處理成功回應
               console.log('Build contract successfully!')
            })
            .catch(error => {
               // 處理錯誤
               console.log('Build contract error occured.')
            });
      },
   }
};
</script>


<style>
@import url("../assets/css/teachersheetbuild.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");</style>