<template>
   <body class="studentsheetmine">
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
                           <li class="nav-item studentprofile">
                              <router-link :to="{ name: 'StudentPostPage', params: { username: this.username } }"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 POST
                              </router-link>
                           </li>
                           <li class="nav-item teacherprofile">
                              <router-link :to="{ name: 'StudentAddPost', params: { username: this.username } }"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 ADD
                              </router-link>
                           </li>
                           <li class="nav-item active studentprofile">
                              <router-link :to="{ name: 'StudentProfile', params: { username: this.username } }"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 ABOUT
                              </router-link>
                           </li>
                           <li class="nav-item teacherprofile">
                              <router-link :to="{ name: 'StudentSheet', params: { username: this.username } }"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 SHEET
                              </router-link>
                           </li>
                           <li class="nav-item studentprofile">
                              <a class="button_set_head button_set2_head nav-link"
                                 href="https://www.youtube.com/watch?v=VV0PxIV5V-Y" target="_blank">MORE</a>
                           </li>
                           <li class="nav-item teacherprofile">
                              <a class="nav-link teacherprofile" href="https://www.nccu.edu.tw/"><img
                                    src="../assets/images/NCCU.png" width="35" height="35"></a>
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
                  <div class="studentsheetminesheet_div_title2">MY EVALUATION SHEET
                  </div>
               </div>

               <div class="button-container">
                  <router-link :to="{ name: 'StudentSheetOngoing', params: { username: this.username } }"
                     class="studentsheetongoingbutton_set1 button_set1-2" style="margin-left: 2px;">
                     Ongoing
                  </router-link>

                  <a href="post.html">
                     <button class="studentsheetongoingbutton_set1 button_set1-2 button_fixed"
                        style="margin-left: 2px;">Established</button>
                  </a>
               </div>

               <hr size="8" align="center" noshade width="40%" color="000000">

               <div class="col-md-6">
                  <div class="personal_div">
                     <div class="personal_div_textl ">① 吳堃豪/多益</div>
                     <router-link :to="{ name: 'StudentSheetOver', params: { username: this.username } }"
                     class="personal_div_textr">
                     已建立
                  </router-link>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">② 超小孩/資料庫管理</div>
                     <a href="#" class="personal_div_textr">已建立</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">③ 侯程麟/健身</div>
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
export default{
   name: 'StudentSheetMine',
  props: {
    username: String
  },
}
</script>

<style scoped>
@import url("../assets/css/studentsheetmine.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");</style>