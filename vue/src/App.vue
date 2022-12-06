<template>
  <div id="app">
    <div id="nav">
      <nav-bar>
        <ul class="nav-links">
          <li><router-link id="home" v-bind:to="{name: 'home'}">Home</router-link></li>
        </ul>
      </nav-bar>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      
    </div>
    <router-view />
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue"

export default {
  name: "App",
  components: {
    NavBar,
  }
};
</script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Nunito&display=swap');
  body {
    font-family: 'Nunito', sans-serif;
  }
</style>
