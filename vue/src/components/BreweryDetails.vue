<template>
  <div>
    <div class="text-center">
      <h1>{{ brewery.name }}</h1>
    </div>

    <section class="container">
      <b-row>
        <b-col>
          <h5 id="null message" v-if="brewery.imgUrl=== null"><b-img
            id="Brewery-logo"
            :src="require('../Assets/breweries.jpg')"
          ></b-img></h5>
          <h5 v-else>{{ Brewery.imgUrl }}</h5>

          <!-- <b-img
            id="Brewery-logo"
            :src="require('../Assets/breweries.jpg')"
          ></b-img> -->
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
            <h5>Address: {{this.$store.state.selectedBrewery.address1}}</h5>
            <h5 id="null message" v-if="this.$store.state.selectedBrewery.address1=== null" >Brewery Address: Coming Soon</h5>
          
          <!--  where brewery address goes           -->
        </div>
        <div class="col-md-6 p-4">
            <h5>{{brewery.phoneNumber}}</h5>
            <h5 id="null message" v-if="brewery.phoneNumber=== null">Brewery Contact Info: Coming Soon</h5>
          <!--  where brewery contact info goes   -->
        </div>
        <div class="col-md-6 p-4">
          <h5>Website: <a :href="this.brewery.url">{{ brewery.url }}</a></h5>

            <h5 id="null message" v-if="this.brewery.url=== null">Brewery Website: Coming Soon</h5>
          
          <!--  where brewery Website info goes   -->
        </div>
        <div class="col-md-6 p-4">
            <h5>{{brewery.hours}}</h5>
            <h5 id="null message" v-if="brewery.hours=== null" >Brewery Hours: Coming Soon</h5>
          <!--  where brewery hours info goes   -->
        </div>
       
      </div>
    </section>

    <section class="container">
       <div class="row align-items-center">
            <h5 class="text-center">{{brewery.description}}</h5>
            <h5 id="null message" v-if="brewery.description=== null" class = "text-center">Brewery History: Coming Soon</h5>

        </div>


    </section>

    <section class="container">
      <div class="row justify-content-center">
        <div class="text-center p-5">
          <!-- <router-link v-bind:to="{ name: 'beerlist' }"
            ><b-button variant="primary">View Beer List</b-button></router-link -->
          <!-- > -->
              <h4>BEER LIST</h4>
          
          <div v-for="beer in brewery.beerList" v-bind:key="beer.id" @click="setBeerId(beer.id)">
            <!-- <router-link v-bind:to="{ name: 'beerdetails' }"> -->
              <b-button
              class="mb-2"
              variant="outline-warning"
              >{{ beer.name }} <hr> {{beer.style}}</b-button>
              <!-- </router-link> -->
            
          </div>
        </div>
      </div>
    </section>

    <!-- <section class="container">
      <div class="text-center p-5">
        <h3>Brewery History Coming Soon</h3>
      </div>

    </section> -->
  </div>
</template>


<script>
import AppServices from "../services/AppServices";

export default {
  data() {
    return {
      brewery: {},
      selectedBeerId: "",
    };
  },

  created() {
    AppServices.getBreweryById(this.$route.params.id).then((response) => {
      this.brewery = response.data;
    });
  },
  methods: {
    setBeerId(id) {
      this.selectedBeerId = id;
      this.$router.push({ name: 'beerdetails', params:{id:id} })
    }

    
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