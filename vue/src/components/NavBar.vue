<template>
  <div>
  <b-nav id="navigation">
    <b-container>
      <b-row>
        <b-col>
             <b-navbar-brand id = "beerIcon"><router-link v-bind:to="{ name: 'home'}"> 🍺 </router-link> </b-navbar-brand>

        </b-col>

        <b-col>
              <b-nav-item active><router-link v-bind:to="{ name: 'brewerylist' }">Breweries</router-link></b-nav-item>

        </b-col>

        <b-col>
              <b-nav-item><router-link v-bind:to="{ name: 'login' }">Login</router-link></b-nav-item>

        </b-col>

        <b-col>
               <b-nav-item><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> </b-nav-item>

        </b-col>

      </b-row>
   
   
    </b-container>

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
    justify-content:space-evenly;
    list-style-type: none;
    
}




#beerIcon {
font-size: 50px;
text-decoration: none;

}

</style>