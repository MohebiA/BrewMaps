<template>
  <div>
    <div class="text-center"><h1>{{brewery.name}}</h1></div>

    <section class="container">

<b-row>
    <b-col>    
      <b-img id = "Brewery-logo" :src="require('../Assets/breweries.jpg')"></b-img>
    </b-col>  

    <b-col>
      <b-container>
        <b-col>
          <b-row>1</b-row>
          <b-row>2</b-row>
          <b-row>3</b-row>
          <b-row>4</b-row>
        </b-col>
      </b-container>
    </b-col>
</b-row>
    </section>

    <section class="container">
      <div class="row align-items-center">
        <div class="col-md-6 order-md-1">
          <p>Brewery Address</p>
          <!--  where brewery address goes           -->
        </div>
        <div class="col-md-6 p-4">
          <p>Contact Info</p>
          <!--  where brewery contact info goes   -->
        </div>
        <div class="col-md-6 p-4">
          <a :href="this.brewery.url">{{brewery.url}}</a>
          <!--  where brewery Website info goes   -->
        </div>
        <div class="col-md-6 p-4">
          <p>Hours open / closed</p>
          <!--  where brewery hours info goes   -->
        </div>
      </div>
    </section>

    
    <section class="container">
      <div class="row align-items-center">
        <div class="col-md-6 p-5">
          <router-link v-bind:to="{ name: 'beerlist' }"
            ><b-button variant="primary">View Beer List</b-button></router-link
          >
                <div v-for="beer in brewery.beerList" v-bind:key="beer.id">
                    <b-button class="mb-2" variant="outline-warning">{{beer.name}}</b-button>
                </div>



                
        </div>
      </div>
    </section>

<b-container class="brewery-history">
  <b-row align-v="center">
    <h3>Brewery History</h3>

  </b-row>

</b-container>

  </div>
</template>


<script>

import AppServices from "../services/AppServices"

export default {
  data() {
    return {
      brewery: {},

    }
  },

  created() {
    AppServices.getBreweryById(this.$route.params.id).then((response) => {
      this.brewery = response.data;
    });

  }


};
</script>


<style>

#Brewery-logo {
  grid-column: 1/2;
  grid-row: 1/2;
  max-width: 300px;

}

</style>