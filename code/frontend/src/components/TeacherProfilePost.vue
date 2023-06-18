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
                    <a class="nav-link" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png" width="35"
                        height="35"></a>

                  </li>
                  <li class="nav-item active">

                    <a href="post.html"><button class="button_set_head button_set2_head nav-link ">Post</button></a>

                  </li>
                  <li class="nav-item">
                    <a class="button_set_head button_set2_head nav-link" href="add.html">ADD</a>
                  </li>
                  <li class="nav-item">
                    <a class="button_set_head button_set2_head nav-link button_fixed_head" href="personal.html">ABOUT</a>
                  </li>
                  <li class="nav-item">
                    <a class="button_set_head button_set2_head nav-link" href="sheetAbout.html">SHEET</a>
                  </li>
                  <li class="nav-item">
                    <a class="button_set_head button_set2_head nav-link"
                      href="https://www.youtube.com/watch?v=VV0PxIV5V-Y" target="_blank">MORE</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="https://www.nccu.edu.tw/"><img src="../assets/images/NCCU.png" width="35"
                        height="35"></a>
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
        <div class="container">
          <h1 class="spp_contact_taital">{{ username }}<!--改start-->
            <hr size="10" align="center" noshade width="50%" color="000000">

            <router-link :to="{ name: 'TeacherProfile', params: { username: this.username } }" class="teacherprofilepost">
              <button class="spp_button_set spp_button_set2 ">關於</button>
            </router-link>
            <a href="post.html"><button class="spp_button_set spp_button_set2 spp_button_fixed">貼文</button></a>
          </h1>
        </div>


        <div class="contact_section_2 layout_padding">
          <div class="sheet_div_title">
            <div class="sheet_div_title2">
            </div>
          </div>

          <div id="filter">
            <!-- Subject Filter -->
            <label for="subject" class="subject_css">Subject：</label>
            <select id="subject" class="subject_content">
              <option value="">All</option>
              <option value="Math">Math</option>
              <option value="Science">Science</option>
              <option value="English">English</option>
              <!-- Add more options as needed -->
            </select>

            <!-- Gender Filter -->
            <label for="gender" class="gender_css">Gender：</label>
            <select id="gender" class="gender_content">
              <option value="">All</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Others">Others</option>
            </select>

            <!-- MBTI Filter -->
            <label for="mbti" class="mbti_css">MBTI：</label>
            <select id="mbti" class="mbti_content">
              <option value="">All</option>
              <option value="INTJ">INTJ</option>
              <option value="INTP">INTP</option>
              <option value="ENTJ">ENTJ</option>
              <option value="ENTP">ENTP</option>
              <option value="INFJ">INFJ</option>
              <option value="INFP">INFP</option>
              <option value="ENFJ">ENFJ</option>
              <option value="ENFP">ENFP</option>
              <option value="ISTJ">ISTJ</option>
              <option value="ISFJ">ISFJ</option>
              <option value="ESTJ">ESTJ</option>
              <option value="ESFJ">ESFJ</option>
              <option value="ISTP">ISTP</option>
              <option value="ISFP">ISFP</option>
              <option value="ESTP">ESTP</option>
              <option value="ESFP">ESFP</option>
            </select>

            <!-- Region Filter -->
            <label for="region" class="region_css">Region：</label>
            <select id="region" class="region_content">
              <option value="">All</option>
              <!-- Taipei City -->
              <option value="Songshan">Songshan</option>
              <option value="Xinyi">Xinyi</option>
              <option value="Daan">Daan</option>
              <option value="Zhongshan">Zhongshan</option>
              <option value="Zhongzheng">Zhongzheng</option>
              <option value="Datong">Datong</option>
              <option value="Wanhua">Wanhua</option>
              <option value="Nangang">Nangang</option>
              <option value="Neihu">Neihu</option>
              <option value="Shilin">Shilin</option>
              <option value="Beitou">Beitou</option>
            </select>

            <button @click="filterPosts()" class="filter_button">Filter</button>
          </div>





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
import axios from 'axios';
import backend from '@/api/backend.js';

export default {
  name: 'StudentPostPage',
  props: {
    username: String
  },
  data() {
    return {
      postsData: []
    };
  },

  mounted() {
    this.getPost();
  },

  methods: {
    getPost() {
      axios.post('http://localhost:8000/getpost', {})
        .then(response => {
          this.postsData = response.data.map(post => ({
            region: post.PostRegion,
            subject: post.PostSubject,
            major: post.PostMajor,
            age: post.PostAge,
            school: post.PostSchool,
            name: post.PostName,
            email: post.PostEmail,
            phone: post.PostPhoneNum,
            gender: post.PostGender,
            MBTI: post.PostMBTI
          }));
          this.displayPosts(this.postsData);
          this.attachRequestButtonListeners();
        })
        .catch(error => {
          console.error(error);
        });
    },

    generatePostHTML(post) {
      var postHTML = `
    <div class="pp_post_column">
      <div class="studentpostpagepp_post">
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Subject:</div>
          <div class="pp_data">${post.subject}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Name:</div>
          <div class="pp_data">${post.name}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Email:</div>
          <div class="pp_data">${post.email}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Phone:</div>
          <div class="pp_data">${post.phone}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Gender:</div>
          <div class="pp_data">${post.gender}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Region:</div>
          <div class="pp_data">${post.region}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Major:</div>
          <div class="pp_data">${post.major}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Age:</div>
          <div class="pp_data">${post.age}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">Age:</div>
          <div class="pp_data">${post.MBTI}</div>
        </div>
        <div class="studentpostpagepp_post_item">
          <div class="pp_label">School:</div>
          <div class="pp_data">${post.school}</div>
        </div>
        <!-- Add more properties as needed -->
        <button class="request-button" data-teacher-name="${post.name}">REQUEST</button>
      </div>
    </div>
  `;
      return postHTML;
    },


    // Function to display the posts based on filter selection
    filterPosts() {
      var subjectFilter = document.getElementById("subject").value;
      var genderFilter = document.getElementById("gender").value;
      var mbtiFilter = document.getElementById("mbti").value;
      var regionFilter = document.getElementById("region").value;
      var filteredPosts = [];

      if (subjectFilter || genderFilter || mbtiFilter || regionFilter) {
        filteredPosts = this.postsData.filter(function (post) {
          return (
            (subjectFilter === "" || post.subject === subjectFilter) &&
            (genderFilter === "" || post.gender === genderFilter) &&
            (mbtiFilter === "" || post.mbti === mbtiFilter) &&
            (regionFilter === "" || post.region === regionFilter)
          );
        });
      } else {
        filteredPosts = this.postsData;
      }

      this.displayPosts(filteredPosts);
    },

    // Function to display the filtered posts
    // Function to display the filtered posts
    displayPosts(posts) {
      var postsContainer = document.getElementById("posts");
      postsContainer.innerHTML = "";

      var self = this;

      posts.forEach(function (post) {
        if (post.name === self.username) {
          var postHTML = self.generatePostHTML(post);
          postsContainer.innerHTML += postHTML;
        }
      });
      this.attachRequestButtonListeners();
    },


    handleRequestButtonClick(event) {
      var teacherName = event.target.getAttribute("data-teacher-name");
      this.sendRequest(teacherName);
      //modify
      this.sendStudentRequestToBackend(teacherName);
    },

    sendRequest(teacherName) {
      alert(`Your request has been sent to teacher ${teacherName} through gmail !`);
    },

    //Function to send request
    attachRequestButtonListeners() {
      var requestButtons = document.getElementsByClassName("request-button");
      Array.from(requestButtons).forEach(button => {
        button.addEventListener("click", this.handleRequestButtonClick);
      });
    },

    sendStudentRequestToBackend(teacherName) {
      const formData = {
        teachername: teacherName,
        props: this.$props
      };
      backend.sendStudentRequestToBackend(formData)
        .then(() => {
          // Handle the successful request if needed
          console.log("Request sent successfully.");
        })
        .catch(error => {
          // Handle the error if the request fails
          console.error(error);
        });
    }

  },
}
</script>




<style>
@import url("../assets/css/teacherprofilepost.css");
@import url("../assets/css/bootstrap.min.css");
@import url("../assets/css/responsive.css");
@import url("../assets/css/jquery.mCustomScrollbar.min.css");
@import url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
@import url("https://fonts.googleapis.com/css?family=Lato:400,700|Poppins:400,700&display=swap");
@import url("https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css");
</style>