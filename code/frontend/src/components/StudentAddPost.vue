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
                           <a class="nav-link" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png" width="35" height="35"></a>

                        </li>
                        <li class="nav-item active">

                           <a href="post.html"><button
                                 class="button_set_head button_set2_head nav-link  ">Post</button></a>

                        </li>
                        <li class="nav-item">
                           <a class="button_set_head button_set2_head nav-link button_fixed_head" href="add.html">ADD</a>
                        </li>
                        <li class="nav-item">
                           <a class="button_set_head button_set2_head nav-link" href="personal.html">ABOUT</a>
                        </li>
                        <li class="nav-item">
                           <a class="button_set_head button_set2_head nav-link" href="sheetAbout.html">SHEET</a>
                        </li>
                        <li class="nav-item">
                           <a class="button_set_head button_set2_head nav-link" href="https://www.youtube.com/watch?v=VV0PxIV5V-Y">MORE</a>
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
                  <div class="sheet_div_title2">  
               </div>
               </div>

               <div class="pp_post_column">
    <div class="pp_post" >
        <div class="pp_post_item" >
          <div class="pp_label">Subject:</div>
          <input type="text" placeholder="subject" class="pp_data" style="width: 100px;">
        </div>

        <div class="pp_post_item">
          <div class="pp_label">Name:</div>
          <div class="pp_data">Ian</div>
        </div>

        <div class="pp_post_item">
          <div class="pp_label">Email:</div>
          <div class="pp_data">xxx@gmail.com</div>
        </div>

        <div class="pp_post_item">
          <div class="pp_label">Phone:</div>
          <div class="pp_data">0909123456</div>
        </div>

        <div class="pp_post_item">
          <div class="pp_label">Gender:</div>
          <div class="pp_data">female</div>
        </div>

        <div class="pp_post_item">
          <div class="pp_label">Age:</div>
          <div class="pp_data">22</div>
        </div>

        <div class="pp_post_item">
          <div class="pp_label">MBTI:</div>
          <div class="pp_data">ENFP</div>
        </div>

        <div class="pp_post_item">
          <div class="pp_label">Region:</div>
          <input type="text" placeholder="region" class="pp_data" style="width: 100px;">
        </div>

        <div class="pp_post_item">
          <div class="pp_label">School:</div>
          <div class="pp_data">NCCU</div>
        </div>

        <div class="pp_post_item">
          <div class="pp_label">Major:</div>
          <input type="text" placeholder="major" class="pp_data" style="width: 100px;">
        </div>

        <div class="pp_post_item">
          <div class="pp_label">Note:</div>
          <input type="text" placeholder="note" class="pp_data" style="width: 100px;">
        </div>
    </div>
    </div>

    <button class="sap_addbutton">add</button>

              


       

      </div>
   </div>
</div>
   
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

</script>




<style>
@import url("../assets/css/studentaddpost.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");

</style>