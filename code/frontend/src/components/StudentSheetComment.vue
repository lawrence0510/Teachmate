<template>
   <body class="studentsheetcomment">
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
                           <li class="nav-item active">

                              <a href="post.html"><button
                                    class="button_set_head button_set2_head nav-link ">Post</button></a>

                           </li>
                           <li class="nav-item">
                              <a class="button_set_head button_set2_head nav-link" href="add.html">ADD</a>
                           </li>
                           <li class="nav-item">
                              <a class="button_set_head button_set2_head nav-link" href="personal.html">ABOUT</a>
                           </li>
                           <li class="nav-item">
                              <a class="button_set_head button_set2_head nav-link button_fixed_head"
                                 href="sheetAbout.html">SHEET</a>
                           </li>
                           <li class="nav-item">
                              <a class="button_set_head button_set2_head nav-link" href="more.html">MORE</a>
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
      <div class="whole">
         <div class="studentsheetcommentcontact_section layout_padding margin_bottom90">
            <div class="contact_section_2 layout_padding">
               <div class="sheet_div_title">
                  <div class="sheet_div_title2">BUILD EVALUATION SHEET
                  </div>
               </div>
               <div class="col-md-6">
                  <div class="sheet_div">

                     <div class="studentsheetcommentsheet_content_title">
                        TEACHMATE
                     </div>
                     <div class="studentsheetcommentsheet_content_sheet">
                        evaluation sheet
                     </div>
                     <div class="studentsheetcommentsheet_content_t">
                        Teacher：
                     </div>
                     <div class="studentsheetcommentsheet_content_tname">
                        吳堃豪
                     </div>
                     <div class="studentsheetcommentsheet_content_s">
                        Student：
                     </div>
                     <div class="studentsheetcommentsheet_content_sid">
                        李筱貞
                     </div>
                     <div class="studentsheetcommentsheet_content_sub">
                        Subject：
                     </div>
                     <div class="studentsheetcommentsheet_content_subname">
                        多益
                     </div>
                     <div class="studentsheetcommentsheet_content_time">
                        Time：
                     </div>
                     <div class="studentsheetcommentsheet_content_time_s">
                        2022/2/10
                     </div>
                     <div class="studentsheetcommentsheet_content_time_to">~</div>
                     <div class="studentsheetcommentsheet_content_time_e">
                        2023/4/10
                     </div>
                     <div class="studentsheetcommentsheet_content_comment">
                        Student Comments：
                     </div>
                     <div class="star-rating">
                        <input type="radio" name="rating" id="star1" value="5" v-model = "teacherscore">
                        <label for="star1"></label>
                        <input type="radio" name="rating" id="star2" value="4" v-model = "teacherscore">
                        <label for="star2"></label>
                        <input type="radio" name="rating" id="star3" value="3" v-model = "teacherscore">
                        <label for="star3"></label>
                        <input type="radio" name="rating" id="star4" value="2" v-model = "teacherscore">
                        <label for="star4"></label>
                        <input type="radio" name="rating" id="star5" value="1" v-model = "teacherscore">
                        <label for="star5"></label>
                     </div>

                     <textarea class="studentsheetcommentsheet_content_div "
                        placeholder="Please share your thoughts and opinions." v-model="c_content"></textarea>
                     <button id="show" class="studentsheetcommentbutton_set" @click= "Contractgradecomment">Build</button>
                     <dialog id="infoModal">
                        <p>Successfully created.<br>The sheet has been sent to the student.</p>
                        <button id="close" class="studentsheetcommentbutton_ok">
                        <router-link to="/studentprofile">OK</router-link>
                     </button>
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
   data() {
        return {
            teacherscore: '',
            c_content: '',
        };
    },
   mounted() {

      let btn = document.querySelector("#show");
      let infoModal = document.querySelector("#infoModal");
      let close = document.querySelector("#close");

      // 初始隐藏 dialog 元素
      infoModal.style.display = "none";

      btn.addEventListener("click", function () {
         infoModal.style.display = "block"; // 显示 dialog 元素
         infoModal.showModal(); // 打开模态对话框
      });

      close.addEventListener("click", function () {
         infoModal.close();
         infoModal.style.display = "none"; // 隐藏 dialog 元素
      });

   },
   methods: {
        Contractgradecomment() {
            //these properties correspond to user-entered data
            const formData = {
               teacherscore : this.teacherscore,
               c_content : this.c_content,
            }
            console.log(formData)
            //making a HTTP request to the backend
            backend.Contractgradecomment(formData)
                .then(response => {
                    // 處理成功回應
                    console.log('Contract grade and comment successfully!')
                })
                .catch(error => {
                    // 處理錯誤
                    console.log('Contract grade and comment unsuccessfully')
                });
        },
   }
};
</script>


<style>
@import url("../assets/css/studentsheetcomment.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");</style>