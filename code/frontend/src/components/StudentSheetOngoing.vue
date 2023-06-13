<template>
   <body class="studentsheetongoing">
      <div class="header_section studentsheetongoing">
         <div class="container-fluid ">
            <div class="row">
               <div class="col-sm-2 col-6">

               </div>
               <div class="col-sm-8 col-6">
                  <nav class="navbar navbar-expand-lg navbar-light bg-light">

                     <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav studentsheetongoing">
                           <li class="nav-item studentsheetongoing">
                              <a class="nav-link studentsheetongoing" href="https://www.nccu.edu.tw/"><img
                                    src="../assets/images/NCCU.png" width="35" height="35"></a>

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
                  <div class="sheet_div_title2">MY EVALUATION SHEET
                  </div>
               </div>

               <div class="button-container">
                  <a href="personal.html">
                     <button class="studentsheetongoingbutton_set1 button_set1-2 button_fixed">Ongoing</button>
                  </a>
                  <router-link :to="{ name: 'StudentSheetMine', params: { username: this.username } }"
                     class="studentsheetongoingbutton_set1 button_set1-2" style="margin-left: 2px;">
                     Established
                  </router-link>
               </div>

               <hr size="8" align="center" noshade width="40%" color="000000">


               <div class="col-md-6">
                  <div class="personal_div">
                     <div class="personal_div_textl ">① 邱郁宸/研究所</div>
                     <router-link :to="{name: 'StudentSheetComment', params:{username: this.username}}">
                        <button class="studentsheetongoingbutton_check1">評分</button>
                     </router-link>

                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">② 李曉惠/供應鏈</div>
                     <a class="personal_div_textr" style="color: gray;">處理中</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">③ 林怡伶/程式設計</div>
                     <router-link :to="{name: 'StudentSheetComment', params:{username: this.username}}">
                        <button class="studentsheetongoingbutton_check">評分</button>
                     </router-link>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">④ 王小名/鋼琴</div>
                     <a class="personal_div_textr" style="color: gray;">處理中</a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑤ </div>
                     <a class="personal_div_textr"></a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑥ </div>
                     <a class="personal_div_textr"></a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑦ </div>
                     <a href="#" class="personal_div_textr"></a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑧ </div>
                     <a href="#" class="personal_div_textr"></a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑨ </div>
                     <a href="#" class="personal_div_textr"></a>
                  </div>

                  <div class="personal_div2">
                     <div class="personal_div_textl">⑩ </div>
                     <a href="#" class="personal_div_textr"></a>
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
   name: 'StudentSheetOngoing',
   props: {
      username: String
   },
}
</script>

<style>
@import url("../assets/css/studentsheetongoing.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");
</style>