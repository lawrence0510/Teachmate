<template>
   <body class="teachersheetmine">
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
                  <div class="teachersheetminesheet_div_title2">MY EVALUATION SHEET
                  </div>
               </div>
               <div class="button-container">
                  <router-link :to="{ name: 'TeacherSheetOngoing', params: { username: this.username } }"
                     class="teachersheetongoingbutton_set1 button_set1-2">
                     Ongoing
                  </router-link>

                  <a href="post.html">
                     <button class="teachersheetongoingbutton_set1 button_set1-2 teachersheetminebutton_fixed"
                        style="margin-left: 2px;">Established</button>
                  </a>
               </div>
               <hr size="8" align="center" noshade width="40%" color="000000">


               <div class="col-md-6">
                  <div class="personal_div">
                     <div class="personal_div_textl ">① 多益：李小包</div>
                     <a href="#" class="personal_div_textr">已建立</a>

                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">② 資料庫管理：學生姓名</div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">③ 健身：王柏翔</div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">④ </div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑤ </div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑥ </div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑦ </div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑧ </div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑨ </div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑩ </div>
                     <a href="#" class="personal_div_textr">已建立</a>
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
export default {
   name: 'TeacherSheetMine',
   props: {
      username: String
   },
}
</script>

<style>
@import url("../assets/css/teachersheetmine.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");
</style>