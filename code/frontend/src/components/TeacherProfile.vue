<template>
   <body class="teacherprofile">
      <div class="teacherprofileheader_section">
         <div class="container-fluid">
            <div class="row">
               <div class="col-sm-2 col-6">

               </div>
               <div class="col-sm-8 col-6">
                  <nav class="navbar navbar-expand-lg navbar-light teacherprofilebg-light teacherprofile">

                     <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav teacherprofile">
                           <li class="nav-item teacherprofile">
                              <a class="nav-link teacherprofile" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png"
                                    width="35" height="35"></a>

                           </li>
                           <li class="nav-item teacherprofile">
                              <a class="button_set_head button_set2_head nav-link teacherprofile" href="personal.html">POST</a>
                           </li>
                           <li class="nav-item teacherprofile">
                              <a class="button_set_head button_set2_head nav-link teacherprofile" href="add.html">ADD</a>
                           </li>
                           <li class="nav-item active teacherprofile">
                              <a class="teacherprofile" href="post.html">
                                 <button class="button_set_head button_set2_head nav-link button_fixed_head teacherprofile">ABOUT</button>
                              </a>
                           </li>
                           <li class="nav-item teacherprofile">
                              <router-link to="/teachersheet"
                                 class="button_set_head button_set2_head nav-link studentprofile">
                                 SHEET
                              </router-link>
                           </li>
                           <li class="nav-item teacherprofile">
                              <a class="button_set_head button_set2_head nav-link teacherprofile" href="more.html">MORE</a>
                           </li>
                           <li class="nav-item teacherprofile">
                              <a class="nav-link teacherprofile" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png"
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
         <div class="contact_section layout_padding margin_bottom90">
            <div class="container teacherprofile">
               <h1 class="contact_taital">{{ username }}<!--改start-->
                  <hr size="10" align="center" noshade width="50%" color="000000">

                  <a href="personal.html" class="teacherprofile"><button class="teacherprofilebutton_set button_set2 button_fixed teacherprofile">關於</button></a>
                  <a href="post.html" class="teacherprofile"><button class="teacherprofilebutton_set button_set2 teacherprofile">貼文</button></a>
               </h1>
            </div>

            <div class="contact_section_2 layout_padding">




               <div class="col-md-6">
                  <div class="teacherprofilepersonal_div">
                     <img src="../assets/images/identity.png" alt="身分" class="personal_png">
                     <div class="teacherprofilepersonal_div_textl">身分</div>
                     <div v-if="teacherinfo.length > 0" class="teacherprofilepersonal_div_textr">{{ teacherinfo[0].UserType }}
                     </div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/sex.png" alt="性別" class="personal_png_sex">
                     <div class="teacherprofilepersonal_div_textl_sex">性別</div>
                     <div v-if="teacherinfo.length > 0" class="teacherprofilepersonal_div_textr_sex">{{ teacherinfo[0].Gender }}
                     </div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/age.png" alt="年齡" class="personal_png_old">
                     <div class="personal_div_textl_old">年齡</div>
                     <div v-if="teacherinfo.length > 0"  class="teacherprofilepersonal_div_textr_old">{{ teacherinfo[0].Age }}
                     </div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/school.png" alt="學歷" class="personal_png_school">
                     <div class="personal_div_textl_school">學歷</div>
                     <div v-if="teacherinfo.length > 0" class="teacherprofilepersonal_div_textr_school stop_here_school">{{ teacherinfo[0].School }}/{{ teacherinfo[0].Major }}
                     </div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/MBTI.png" alt="MBTI" class="personal_png_MBTI">
                     <div class="teacherprofilepersonal_div_textl_MBTI">MBTI</div>
                     <div v-if="teacherinfo.length > 0" class="teacherprofilepersonal_div_textr_MBTI">{{ teacherinfo[0].MBTI }}
                     </div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/cert.png" alt="cert" class="personal_png_cert">
                     <div class="personal_div_textl_cert">專長</div>
                     <div v-if="teacherinfo.length > 0" class="teacherprofilepersonal_div_textr_cer">{{ teacherinfo[0].Profession }}</div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/exper.png" alt="教學經驗" class="personal_png_exper">
                     <div class="teacherprofilepersonal_div_textl_exper">教學經驗</div>
                     <div v-if="teacherinfo.length > 0" class="teacherprofilepersonal_div_textr_exper">{{teacherinfo[0].WorkExperience}}</div>

                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/contact.png" alt="聯絡方式" class="personal_png_contact">
                     <div class="teacherprofilepersonal_div_textl_contact">聯絡方式</div>
                     <div class="teacherprofilepersonal_div_textr_contact stop_here_contact">Click me for contacts
                     </div>
                     <div v-if="teacherinfo.length > 0" class="pop_content_contact">Contacts: <br>📞0{{ teacherinfo[0].PhoneNum }}<br>✉️{{ teacherinfo[0].Gmail }}
                     </div>
                  </div>

                  <div class="personal_div_n2">
                     <img src="../assets/images/score.png" alt="exper" class="personal_png_score">
                     <div class="teacherprofilepersonal_div_textl_score">平均評分</div>

                     <div class="teacherprofilepersonal_div_textr_score stop_here_score">4.5/5(10)
                     </div>
                  </div>

                  <div class="personal_div_comment">
                     <img src="../assets/images/comment.png" alt="備註" class="teacherprofilepersonal_png_comment">
                     <div class="teacherprofilepersonal_div_textl_comment">備註</div>
                     <div class="teacherprofilepersonal_div_comment_line"></div>
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
import axios from 'axios'

export default{
   name: 'TeacherProfile',
   props: {
      username: String
   },
   data(){
      return{
         teacherinfo: []
      }
   },
   mounted(){
      this.getTeacherInfo();
   },
   methods:{
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
    }  
   }
}
</script>

<style>
@import url("../assets/css/teacherprofile.css");
@import url("../assets/css/bootstrap.min.css");</style>