<template>
   <body class="studentprofile">
      <div class="header_section studentprofile">
         <div class="container-fluid studentprofile">
            <div class="row">
               <div class="col-sm-2 col-6">

               </div>
               <div class="col-sm-8 col-6">
                  <nav class="navbar navbar-expand-lg navbar-light bg-light ">

                     <div class="collapse navbar-collapse" id="navbarNav">
                        <li class="nav-item studentprofile">

                        </li>

                        <ul class="navbar-nav studentprofile">
                           <li class="nav-item studentprofile">
                              <a class="nav-link studentprofile" href="https://www.nccu.edu.tw/"><img
                                    src="../assets/images/NCCU.png" width="35" height="35"></a>

                           </li>
                           <li class="nav-item studentprofile">
                              <a class="button_set_head button_set2_head nav-link studentprofile"
                                 href="personal.html">POST</a>
                           </li>
                           <li class="nav-item studentprofile">
                              <a class="button_set_head button_set2_head nav-link studentprofile" href="add.html">ADD</a>
                           </li>
                           <li class="nav-item active studentprofile">
                              <a class="studentprofile" href="post.html">
                                 <button
                                    class="button_set_head button_set2_head nav-link button_fixed_head studentprofile">ABOUT</button>
                              </a>
                           </li>
                           <li class="nav-item studentprofile">
                              <router-link to="/studentsheet"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 SHEET
                              </router-link>

                           </li>
                           <li class="nav-item studentprofile">
                              <a class="button_set_head button_set2_head nav-link studentprofile" href="more.html">MORE</a>
                           </li>
                           <li class="nav-item studentprofile">
                              <a class="nav-link studentprofile" href="https://www.nccu.edu.tw/"><img
                                    src="../assets/images/NCCU.png" width="35" height="35"></a>
                           </li>

                        </ul>
                     </div>
                  </nav>
               </div>

            </div>
         </div>
      </div>
      <!-- header section end -->
      <!-- contact section start -->
      <div class="whole">
         <div class="contact_section layout_padding margin_bottom90">
            <div class="container">
               <h1 class="contact_taital">{{ username }}
<!--改start-->
                  <hr size="10" align="center" noshade width="50%" color="000000">

                  <a href="personal.html"><button
                        class="studentprofilebutton_set studentprofilebutton_set2 button_fixed">關於</button></a>
                  <a href="post.html"><button class="studentprofilebutton_set studentprofilebutton_set2">貼文</button></a>
               </h1>
            </div>

            <div class="contact_section_2 layout_padding">




               <div class="col-md-6">
                  <div class="studentprofilepersonal_div">
                     <img src="../assets/images/identity.png" alt="身分" class="personal_png">
                     <div class="studentprofilepersonal_div_textl">身分</div>
                     <div v-if="studentinfo.length > 0" class="studentprofilepersonal_div_textr">{{ studentinfo[0].UserType }}</div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/sex.png" alt="性別" class="personal_png_sex">
                     <div class="personal_div_textl_sex">性別</div>
                     <div v-if="studentinfo.length > 0" class="personal_div_textr_sex">{{ studentinfo[0].Gender }}
                     </div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/age.png" alt="年齡" class="personal_png_old">
                     <div class="personal_div_textl_old">年齡</div>
                     <div v-if="studentinfo.length > 0" class="personal_div_textr_old">{{ studentinfo[0].Age }}
                     </div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/school.png" alt="學歷" class="personal_png_school">
                     <div class="personal_div_textl_school">學歷</div>
                     <div v-if="studentinfo.length > 0" class="personal_div_textr_school stop_here_school">{{ studentinfo[0].School }}/{{ studentinfo[0].Major }}
                     </div>
                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/MBTI.png" alt="MBTI" class="personal_png_MBTI">
                     <div class="personal_div_textl_MBTI">MBTI</div>
                     <div v-if="studentinfo.length > 0" class="personal_div_textr_MBTI">{{ studentinfo[0].MBTI }}
                     </div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/contact.png" alt="聯絡方式" class="personal_png_contact">
                     <div class="personal_div_textl_contact">聯絡方式</div>
                     <div class="personal_div_textr_contact stop_here_contact">Click me for contacts
                     </div>
                     <div v-if="studentinfo.length > 0" class="pop_content_contact">Contacts: <br>📞0{{ studentinfo[0].PhoneNum }}<br>✉️{{ studentinfo[0].Gmail }}
                     </div>
                  </div>

                  <div class="personal_div_comment">
                     <img src="../assets/images/comment.png" alt="備註" class="personal_png_comment">
                     <div class="personal_div_textl_comment">備註</div>
                     <div class="personal_div_textr_comment">
                     </div>
                     <div class="personal_div_comment_line"></div>
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
            <p class="copyright_text">NCCU MIS 111-2DBMS<br>G9：TEACHMATE</p><!-- 改 -->
         </div>
      </div>
   </body>
</template>

<script>
import axios from 'axios';

export default {
  name: 'StudentProfile',
  props: {
    username: String
  },
  data(){
   return {
      studentinfo: []
   }
  },
  mounted() {
    this.getStudentInfo();
  },
  methods: {
    getStudentInfo() {
      axios.post('http://localhost:8000/getstudentinfo', {
        username: this.username
      })
        .then(response => {
          this.studentinfo = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
};

</script>

<style>@import url("../assets/css/studentprofile.css");
@import url("../assets/css/bootstrap.min.css");</style>