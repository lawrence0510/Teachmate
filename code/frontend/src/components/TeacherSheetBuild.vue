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
                           <a class="nav-link" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png" width="35" height="35"></a>

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
                           <a class="button_set_head button_set2_head nav-link button_fixed_head" href="sheetAbout.html">SHEET</a>
                        </li>
                        <li class="nav-item">
                           <a class="button_set_head button_set2_head nav-link" href="more.html">MORE</a>
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png" width="35" height="35"></a>
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
                     老師：
                  </div>
                  <div class="sheet_content_tname">
                     吳堃豪
                  </div>
                  <div class="sheet_content_s">
                     學生：
                  </div>
                  <input type="text" placeholder="請輸入學生ID" class="sheet_content_sid">
                  <div class="sheet_content_sub">
                     科目：
                  </div>
                  <input type="text" placeholder="請輸入教學科目" class="sheet_content_subname">
                  <div class="sheet_content_time">
                     時程：
                  </div>
                  <input name = "date" type="date" id="date" class="sheet_content_time_s"><div class="sheet_content_time_to">~</div><input name = "date" type="date" id="date" class="sheet_content_time_e">
                  <a href="#"><button class="button_set" >建立</button></a>
                 

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

</script>

<style>
@import url("../assets/css/teachersheetbuild.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");
</style>