<template>
  <div class="home">
    <nav-bar></nav-bar>
    <home />  
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
import Home from "../components/Home.vue"

export default {
  name: "home",
  components: {
    Home,
  }
};
</script>
