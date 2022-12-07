<template>
  <div id="app">
    <div id="nav">
      <nav-bar>
        <ul class="nav-links">
          <!-- <li><router-link href="/home" id="home" v-bind:to="{name: 'home'}">Home</router-link></li> -->
          <li><router-link @click="this.$router.push({name:'home'})" v-bind:to="{name: 'home'}">Home</router-link></li>

        </ul>
      </nav-bar>
      <home/>      
    </div>

    <router-view />
              <Footer/>      

  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue"
import Footer from "./components/Footer.vue"
export default {
  name: "App",
  components: {
    NavBar,
    Footer,
  }
};
</script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Nunito&display=swap');
  body {
    font-family: 'Nunito', sans-serif;
  }
</style>
