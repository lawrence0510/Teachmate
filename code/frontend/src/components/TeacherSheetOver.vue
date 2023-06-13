<template>
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
               <div class="sheet_div_title2">BUILD EVALUATION SHEET
               </div>
            </div>



            <div class="col-md-6">
               <div class="sheet_div">

                  <div class="sheet_content_title">
                     TEACHMATE
                  </div>
                  <div class="sheet_content_sheet">
                     evaluation sheet
                  </div>
                  <div class="sheet_content_t">
                     Teacher：
                  </div>
                  <div class="sheet_content_tname">
                     {{ username }}
                  </div>
                  <div class="sheet_content_s">
                     Student：
                  </div>
                  <div class="sheet_content_sid">
                     student_name
                  </div>
                  <div class="sheet_content_sub">
                     Subject：
                  </div>
                  <div class="sheet_content_subname">
                     多益
                  </div>
                  <div class="sheet_content_time">
                     Time：
                  </div>
                  <div class="sheet_content_time_s">
                     2022/2/10
                  </div>
                  <div class="sheet_content_time_to">~</div>
                  <div class="sheet_content_time_e">
                     2023/4/10
                  </div>
                  <div class="sheet_content_comment">
                     Student Comments：
                  </div>

                  <div class="star-container"></div>

                  <div class="sheet_content_div ">Others...</div>
                  <button id="show" class="teachersheetoverbutton_set">Next</button>
                  <dialog id="infoModal">
                     <p>
                        Please transfer the establishment fee to the following account:</p>
                     <p>中華郵政(700)<br>1234567 1234567</p>
                     <p>After completing the payment, please report by clicking "Payment Completed".</p>
                     <button id="close" class="close">
                        <router-link :to="{ name: 'TeacherProfile', params: { username: this.username } }">
                                 <button @click = submit()>付款完成！</button>
                        </router-link>
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
</template>

<script>

export default {
   name: 'TeacherSheetOver',
   props: {
      username: String
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
   methods:{
      submit(){
         alert('已記錄匯款！')
      }
   }
};
</script>


<style>
@import url("../assets/css/teachersheetover.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");
</style>