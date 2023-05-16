<template>
    <!--header section start -->
    <!-- <div class="header_section">HIHIHI
    </div> -->
    <!-- header section end -->
    <div class="container" id="container" ref="container">
        <div class="form-container sign-up-container">
            <form action="#">
                <h1>Create Account</h1>
                <br>
                <div class="enroll">
                    <select v-model="userType">
                        <option value="0">I'm a Teacher</option>
                        <option value="1">I'm a Student</option>
                    </select>
                    <input type="text" placeholder="Name" v-model="name" />
                    <input type="email" placeholder="Email" v-model="email" />
                    <input type="password" placeholder="Password" v-model="password" />
                    <input type="number" placeholder="Phone Number" v-model="phoneNumber" />
                    <select v-model="gender">
                        <option value="" disabled selected>Gender</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Others">Others</option>
                    </select>
                    <input type="age" placeholder="Age" v-model="age" />
                    <input type="mbti" placeholder="MBTI (ex: ENFJ)" onkeyup="this.value = this.value.toUpperCase();"
                        v-model="mbti" />
                    <input type="region" placeholder="Region" v-model="region" />
                    <input type="school" placeholder="School" onkeyup="this.value = this.value.toUpperCase();"
                        v-model="school" />
                    <input type="major" placeholder="Major" onkeyup="this.value = this.value.toUpperCase();"
                        v-model="major" />
                </div>
                <br>
                <button @click="signUp">Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form action="#">
                <h1>Log in</h1>
                <br>
                <input type="email" placeholder="Email" v-model="loginEmail" />
                <input type="password" placeholder="Password" v-model="loginPassword" />
                <br>
                <button @click="signIn">Log In</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" ref="signInButton" id="signIn">Log In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Howdy!</h1>
                    <p>Enter your personal details and embark on your tutoring/learning journey with us.</p>
                    <button class="ghost" ref="signUpButton" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
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
            userType: '',
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
            container.classList.add('right-panel-active');
        });

        signInButton.addEventListener('click', () => {
            container.classList.remove('right-panel-active');
        });
    },
    methods: {
        signUp() {
            const formData = {
                userType: this.userType,
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
            };

            backend.signUp(formData)
                .then(response => {
                    // 處理成功回應
                    console.log('Signed up successfully!')
                })
                .catch(error => {
                    // 處理錯誤
                    console.log('Sign up Error Occured...')
                });
        },

        signIn() {
            const formData = {
                email: this.loginEmail,
                password: this.loginPassword,
            };

            backend.signIn(formData)
                .then(response => {
                    console.log('Logged in successfully!')
                    // 處理成功回應
                })
                .catch(error => {
                    console.log('Unsuccessful log in!')
                    // 處理錯誤
                });
        }
    }
};
</script>
