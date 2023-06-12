<template>
    <body class="signinpage">
        <div class="signinpagecontainer" id="container" ref="container">
            <div class="signinpageform-container signinpagesign-up-container">
                <form class="signinpage" action="#">
                    <h1 class="signinpage">Create Account</h1>
                    <br>
                    <div class="signinpageenroll">
                        <select class="signinpage" v-model="userType">
                            <option value="" disabled selected>Account Type</option>
                            <option value="teacher" selected>I'm a Teacher</option>
                            <option value="student">I'm a Student</option>
                        </select>
                        <input class="signinpage" type="text" placeholder="Name" v-model="name" />
                        <input class="signinpage" type="email" placeholder="Email" v-model="email" />
                        <input class="signinpage" type="password" placeholder="Password" v-model="password" />
                        <input class="signinpage" type="number" placeholder="Phone Number" v-model="phoneNumber" />
                        <select class="signinpage" v-model="gender">
                            <option value="" disabled selected>Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Others">Others</option>
                        </select>
                        <input class="signinpage" type="age" placeholder="Age" v-model="age" />
                        <input class="signinpage" type="mbti" placeholder="MBTI (ex: ENFJ)"
                            onkeyup="this.value = this.value.toUpperCase();" v-model="mbti" />
                        <input class="signinpage" type="region" placeholder="Region" v-model="region" />
                        <input class="signinpage" type="school" placeholder="School"
                            onkeyup="this.value = this.value.toUpperCase();" v-model="school" />
                        <input class="signinpage" type="major" placeholder="Major"
                            onkeyup="this.value = this.value.toUpperCase();" v-model="major" />
                    </div>
                    <br>
                    <button class="signinpage" @click="signUp">Sign Up</button>
                </form>
            </div>
            <div class="signinpageform-container signinpagesign-in-container">
                <form class="signinpage" action="#">
                    <h1 class="signinpage">Log in</h1>
                    <br>
                    <input class="signinpage" type="email" placeholder="Email" v-model="loginEmail" />
                    <input class="signinpage" type="password" placeholder="Password" v-model="loginPassword" />
                    <br>
                    <button class="signinpage" @click="signIn">Log In</button>
                </form>
            </div>
            <div class="signinpageoverlay-container">
                <div class="signinpageoverlay">
                    <div class="signinpageoverlay-panel signinpageoverlay-left">
                        <h1 class="signinpage">Welcome Back!</h1>
                        <p class="signinpage">To keep connected with us please login with your personal info</p>
                        <button class="signinpage ghost" ref="signInButton" id="signIn">Log In</button>
                    </div>
                    <div class="signinpageoverlay-panel signinpageoverlay-right">
                        <h1 class="signinpage">Howdy!</h1>
                        <p class="signinpage">Enter your personal details and embark on your tutoring/learning journey with
                            us.</p>
                        <button class="ghost signinpage" ref="signUpButton" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</template>

<style>
@import url("../assets/css/signinpage.css");
</style>

<script>
/* eslint-disable */
import backend from '@/api/backend.js';

export default {
    data() {
        return {
            userType: 'Teacher',
            name: '',
            email: '',
            password: '',
            phoneNumber: '',
            gender: '',
            age: '',
            mbti: '',
            region: '',
            school: '',
            major: '',
            loginEmail: '',
            loginPassword: '',
        };
    },
    mounted() {
        const signUpButton = this.$refs.signUpButton;
        const signInButton = this.$refs.signInButton;
        const container = this.$refs.container;

        signUpButton.addEventListener('click', () => {
            container.classList.add('signinpageright-panel-active');
        });

        signInButton.addEventListener('click', () => {
            container.classList.remove('signinpageright-panel-active');
        });
    },
    methods: {
        signUp() {
            const formData = {
                userType: this.userType === 'Teacher' ? 'Teacher' : 'Student',
                name: this.name,
                email: this.email,
                password: this.password,
                phoneNumber: this.phoneNumber,
                gender: this.gender,
                age: this.age,
                mbti: this.mbti,
                region: this.region,
                school: this.school,
                major: this.major,
            }
            console.log(formData)

            backend.signUp(formData)
                .then(response => {
                    // 處理成功回應
                    console.log('Signed up successfully!')
                })
                .catch(error => {
                    // 處理錯誤
                    console.log('Sign up Error Occured...')
                    console.error(error)
                });
        },

        signIn() {
            const formData = {
                email: this.loginEmail,
                password: this.loginPassword,
            };
            const headers = {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8000'
            };

            backend.signIn(formData, headers)
                .then(response => {
                    console.log(response.data.name)
                    this.username = response.data.name
                    console.log('Logged in successfully!')
                    if(response.data.userType == 'Student'){
                        this.$router.push({
                            name: 'StudentProfile',
                            params: {username: this.username}
                        });
                    }
                    else if(response.data.userType == 'Teacher'){
                        this.$router.push({
                            name: 'TeacherProfile',
                            params: {username: this.username}
                        });
                    }
                })
                .catch(error => {
                    console.log(error)
                    alert('登入失敗！請檢查您的帳號和密碼。');
                });

        }
    }
};
</script>