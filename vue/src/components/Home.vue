<template>
  <div class="home">
    <nav-bar/>
    <section class="text-dark p-4 pb-3 pt-3 bg-light">
      <div class="container-fluid">
        <div class="d-sm-flex align-items-center justify-content-between">
          <div>
            <h2>Find a fabulous brewery and explore their beer selection</h2>
            <p>Built by beer lovers, for beer lovers.</p>
            <br>

            <div>
              <h5>Search for Breweries Near You</h5>
    <b-dropdown id="dropdown-form" text="Enter Zip Code" ref="dropdown" class="mt-2" variant="warning">
      <b-dropdown-form>
        <b-form-group label="Zip Code" label-for="dropdown-form-email" @submit.stop.prevent>
          <b-form-input v-model="zipcode"
            
            id="dropdown-form-email"
            size="md"
            placeholder="15205"
          ></b-form-input>
        </b-form-group>

        <b-form-group label="Radius In Miles" label-for="dropdown-form-password">
          <b-form-input v-model="radius"
            id="dropdown-form-password"
            type="number"
            min = "0"
            max = "75"
            size="md"
            placeholder="20"
          ></b-form-input>
        </b-form-group>

        <b-button variant="primary" size="md" class="m-2" @click="onClick">Visit List</b-button>
      </b-dropdown-form>
    </b-dropdown>
  </div>
            <p class="text-secondary pt-4">
              More breweries coming soon... <br />
              Register below for more details!
            </p>
          </div>
          <b-img class="img-fluid w-50" src="image" alt=""></b-img>
        </div>
      </div>
    </section>

    <section class="p-5">
      <div class="container">
        <div class="row text-center g-4">
          <div class="col-md d-flex justify-content-center">
            <div class="card" style="width: 18rem">
              <b-img :src="require('../Assets/breweries.jpg')"></b-img>
              <div class="card-body">
                <h5 class="card-title">Submit Your Brewery</h5>
                <p class="card-text">
                  Keep your brewery and beer list information up-to-date
                </p>
                <a href="#" class="btn btn-warning">Add Brewery</a>
              </div>
            </div>
          </div>
          <div class="col-md d-flex justify-content-center">
            <div class="card" style="width: 18rem">
              <b-img :src="require('../Assets/breweries.jpg')"></b-img>
              <div class="card-body">
                <h5 class="card-title">Become a "Registered" Beer Love</h5>
                <p class="card-text">
                  Discover breweries and beers and add your expert ratings and
                  reviews
                </p>
                <router-link v-bind:to="{ name: 'register' }"><b-button variant="warning">Register</b-button></router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- PUT IMAGE CAROSEL HERE -->
    <section></section>
  </div>
</template>

<script>
//import image from "src/Assets/Beer-icon.png"

export default {
  data() {
    return {
      zipcode: "",
      radius: "",
      // image
    };
  },
  methods: {
    onClick() {
      this.$refs.dropdown.hide(true);
      this.$store.commit('SET_FILTER', this.radius);
      this.$store.commit('SET_ZIPCODE', this.zipcode);
      this.$router.push({name: 'brewerylist'})
    }
  }
};
</script>

<style>
</style>