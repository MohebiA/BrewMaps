<template>
  <div class="home">
    <nav-bar/>
    <section class="text-dark p-4 pb-3 pt-3 bg-light bg-image"
  style="
    background-image: url('https://wallpaperset.com/w/full/c/e/7/484397.jpg');
    height: 50vh;
  ">
      <div class="container-fluid">
        <div class="d-sm-flex align-items-center justify-content-between bg-image"
  style="
    background-image: url('https://scontent.fdtw2-1.fna.fbcdn.net/v/t1.6435-9/81933427_1368213326684123_2121037133471809536_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=9267fe&_nc_ohc=L70wW2wR_voAX-FPx08&_nc_ht=scontent.fdtw2-1.fna&oh=00_AfDtZDtgylbf_QvVwbE9y8DcE46D036R9esgj49uvv4I7Q&oe=63C06E7B');
    height: 50vh;
  "
>
          <div class="p-4 rounded mx-auto searchBox">
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

    <section class="p-5 bg-image"
  style="
    background-image: url('https://wallpaperset.com/w/full/c/e/7/484397.jpg');
    height: 50vw;
  " >
      <div class="container">
        <div class="row text-center g-4">
          <div class="col-md d-flex justify-content-center">
            <div class="card rounded-top cardClass" style="width: 33vw">
              <b-img class="rounded-top" :src="require('../Assets/Captureresized.jpeg')"></b-img>
              <div class="card-body">
                <h5 class="card-title">Object Oriented Brewing</h5>
                <p class="card-text">
                  Our curated Brewer of the month
                </p>
                <!-- <router-link v-bind:to="{ name: 'register' }"><b-button class="btn-lg btn-block" variant="warning">Visit</b-button></router-link> -->
                <a href="http://localhost:8080/brewery/12" class="btn btn-warning btn-lg customCard">Visit</a>
              </div>
            </div>
          </div>
          <div class="col-md d-flex justify-content-center">
            <div class="card rounded-top cardClass" style="width: 33vw">
              <b-img class="rounded-top" :src="require('../Assets/breweries.jpg')"></b-img>
              <div class="card-body">
                <h5 class="card-title">Become a "Registered" Beer Love</h5>
                <p class="card-text">
                  Discover breweries and beers and add your expert ratings and
                  reviews
                </p>
                <router-link v-bind:to="{ name: 'register' }"><b-button class="btn-lg btn-block customCard" variant="warning">Register</b-button></router-link>
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

.searchBox {
background-color: #f7ebe6d8;
}

.customCard {
  min-width: 15rem !important;
}

.cardClass {
  background-color: #f7ebe6;
}

</style>