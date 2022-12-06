<template>
  <div>
  <b-nav id="navigation">
    <b-nav-item active><router-link v-bind:to="{ name: 'home' }">BrewMaps</router-link></b-nav-item>
    <b-nav-item><router-link v-bind:to="{ name: 'login' }">Login</router-link></b-nav-item>
    <b-nav-item>Login/Register</b-nav-item>
  </b-nav>
</div>
</template>

<script>
export default {

}
</script>

<style>

#navigation {
    display: flex;
    flex-direction: row;
    padding: 12px 0;
    margin: 0 auto;
    width: 98%;
    justify-content: space-between;
    list-style-type: none;
}

</style>