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
                  <div class="sheet_div_title2">MY EVALUATION SHEET
               </div>
               </div>

            <a href="personal.html"><button class="button_set1 button_set1-2 button_fixed">Ongoing</button></a>
               <a href="post.html"><button class="button_set1 button_set1-2 " style="margin-left: 2px;">Established</button></a>
               <hr size="8" align="center" noshade width="40%" color="000000">


            <div class="col-md-6">
               <div class="personal_div">
                   <div class="personal_div_textl " >① 研究所：邱郁宸</div>
                   <a class="personal_div_textr" style="color: gray;">已傳送</a>
                  
               </div>

               <div class="personal_div2">
                   <div class="personal_div_textl">② 供應鏈：李曉慧</div>
                   <button onclick="window.location.href = 'https://www.example.com';" class="button_check">確認評論</button> <!--跳轉到老師確認契約的頁面-->

               </div>

               <div class="personal_div2">
                   <div class="personal_div_textl">③ 程式設計：010</div>
                   <button id="show" class="button_set" >完成繳費</button>
                  <dialog id="infoModal" class="button_window" ><p>若您已完成繳費，請輸入匯款帳號後五碼以利後續確認：</p>
                  <input type="text" name="username" >
                   <a href="#"><button id="close" class="button_ok">OK</button></a></dialog><!--按下OK後要跳回TeacherSheetOngoing(保持原頁面)但完成繳費按鈕會改為顯示核對中-->
               </div>

               <div class="personal_div2">
                   <div class="personal_div_textl">④ 鋼琴：學生姓名</div>
                   <a class="personal_div_textr" style="color: gray;">核對中</a>
               </div>

               <div class="personal_div2">
                   <div class="personal_div_textl">⑤ </div>
                   <a  class="personal_div_textr"></a>
               </div>

               <div class="personal_div2">
                   <div class="personal_div_textl">⑥ </div>
                   <a  class="personal_div_textr"></a>
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
</template>

<script>
export default {
  mounted() {

   let btn = document.querySelector("#show");
  let infoModal = document.querySelector("#infoModal");
  let close = document.querySelector("#close");

  // 初始隐藏 dialog 元素
  infoModal.style.display = "none";

  btn.addEventListener("click", function() {
    infoModal.style.display = "block"; // 显示 dialog 元素
    infoModal.showModal(); // 打开模态对话框
  });

  close.addEventListener("click", function() {
    infoModal.close();
    infoModal.style.display = "none"; // 隐藏 dialog 元素
  });

  }
};
</script>

<style>
@import url("../assets/css/teachersheetongoing.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");
</style>