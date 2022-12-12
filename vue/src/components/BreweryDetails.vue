<template>
  <div>
    <div class="text-center">
      <h1>{{ brewery.name }}</h1>
    </div>

      <h5 id="null message" v-if="brewery.imgUrl === null">
            <b-img
              id="Brewery-logo"
              :src="require('../Assets/breweries.jpg')"
            ></b-img>
          </h5>
          <h5 v-else>{{ Brewery.imgUrl }}</h5>
      
    <section class="container">
      
      <b-row>
        <b-col>
          

          <!-- <b-img
            id="Brewery-logo"
            :src="require('../Assets/breweries.jpg')"
          ></b-img> -->
        </b-col>

        
      </b-row>
    </section>

    <section class="container">
      <div class="row align-items-center">
        <div class="col-md-6 order-md-1">
          <h5>Address: {{ this.$store.state.selectedBrewery.address1 }}</h5>
          <h5
            id="null message"
            v-if="this.$store.state.selectedBrewery.address1 === null"
          >
            Brewery Address: Coming Soon
          </h5>

          <!--  where brewery address goes           -->
        </div>
        <div class="col-md-6 p-4">
          <h5>{{ brewery.phoneNumber }}</h5>
          <h5 id="null message" v-if="brewery.phoneNumber === null">
            Brewery Contact Info: Coming Soon
          </h5>
          <!--  where brewery contact info goes   -->
        </div>
        <div class="col-md-6 p-4">
          <h5>
            Website: <a :href="this.brewery.url">{{ brewery.url }}</a>
          </h5>

          <h5 id="null message" v-if="this.brewery.url === null">
            Brewery Website: Coming Soon
          </h5>

          <!--  where brewery Website info goes   -->
        </div>
        <div class="col-md-6 p-4">
          <h5>{{ brewery.hours }}</h5>
          <h5 id="null message" v-if="brewery.hours === null">
            Brewery Hours: Coming Soon
          </h5>
          <!--  where brewery hours info goes   -->
        </div>
      </div>
    </section>

    <section class="container">
      <div class="row align-items-center">
        <h5 class="text-center">{{ brewery.description }}</h5>
        <h5
          id="null message"
          v-if="brewery.description === null"
          class="text-center"
        >
          Brewery History: Coming Soon
        </h5>
      </div>
      <!-- v-if="this.$store.state.users.user_id === this.brewery.user_id || this.$store.state.users.user_id === 2" -->
      <b-button v-if="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'" v-b-modal.modal-tall class="mb-2" variant="primary"
        >Add a Beer</b-button
      >
      <b-modal id="modal-tall" title="Add Beer" ok-only ok-title="Cancel">
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
          <h5 class="text-center">{{ beer.name }}</h5>
          <b-form-group
            id="input-group-1"
            label="Beer Name:"
            label-for="input-1"
          >
            <b-form-input
              id="input-1"
              v-model="beer.name"
              type="text"
              placeholder="Enter name"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-1" label="ABV:" label-for="input-1">
            <b-form-input
              id="input-1"
              v-model="beer.abv"
              type="text"
              placeholder="ABV"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-1" label="IBU:" label-for="input-1">
            <b-form-input
              id="input-1"
              v-model="beer.ibu"
              type="text"
              placeholder="IBU"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-1"
            label="Beer Type:"
            label-for="input-1"
          >
            <b-form-input
              id="input-1"
              v-model="beer.beer_type"
              type="text"
              placeholder="Type"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-1"
            label="Image URL:"
            label-for="input-1"
          >
            <b-form-input
              id="input-1"
              v-model="beer.imgUrl"
              type="text"
              placeholder="URL"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-1"
            label="Description:"
            label-for="input-1"
          >
            <b-form-textarea
              id="input-1"
              v-model="beer.description"
              placeholder="Enter beer details"
              required
            ></b-form-textarea>
          </b-form-group>

          <b-button class="m-1" type="submit" variant="primary"
            >Submit</b-button
          >
          <b-button type="reset" variant="danger">Reset</b-button>
        </b-form>

        <!-- <div>
                                    <b-form-rating v-model="value" show-value></b-form-rating>
                                      <p class="mt-2">Value: {{ value }}</p>
                                    </div> -->
      </b-modal>
    </section>

    <section class="container">
      <div class="row justify-content-center">
        <div class="text-center p-5">
          <!-- <router-link v-bind:to="{ name: 'beerlist' }"
            ><b-button variant="primary">View Beer List</b-button></router-link -->
          <!-- > -->
          <h4>BEER LIST</h4>

          <div
            v-for="beer in brewery.beerList"
            v-bind:key="beer.id"
            @click="setBeerId(beer.id)"
          >
            <!-- <router-link v-bind:to="{ name: 'beerdetails' }"> -->
            <b-button class="mb-2 custom" variant="outline-warning"
              >{{ beer.name }}
              <hr />
              <!-- {{ beer.beer_type }} -->
              {{beer.style}}
              <hr />
              {{beer.avgRating}} Average Star Rating
              </b-button
            >
  
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
      brewery: {
        brewery_id: "",
        name: "",
        phoneNumber: "",
        address1: "",
        address2: "",
        city: "",
        state: "",
        zip: "",
        hours: "",
        imgUrl: "",
        url: "",
        history: "",
        longitude: "",
        latitude: "",
      },
      selectedBeerId: "",
      form: {
        review: "",
        name: "",
        value: null,
      },
      reviews: [],
      show: true,
      beer: {
        abv: "",
        beenRemoved: false,
        beer_type: "",
        brewer: {},
        breweryId: "",
        description: "",
        ibu: "",
        id: "",
        imgUrl: "",
        name: "",
      },
    };
  },

  created() {
    AppServices.getBreweryById(this.$route.params.id).then((response) => {
      this.brewery = response.data;
    });



      // this.beer.id = this.$route.params.id;

      //TODO: REMOVE BEFORE PROD
      alert(this.$route.params.id);

      // this.brewery = response.data;

      //TODO: REMOVE BEFORE PROD
      // alert(JSON.stringify(response.data));
  },
  methods: {
    setBeerId(id) {
      this.selectedBeerId = id;
      this.$router.push({ name: "beerdetails", params: { id: id } });
    },
    onSubmit(event) {
        let addedBeer = {

      abv: this.beer.abv,
      beer_type: this.beer.beer_type,
      description: this.beer.description,
      ibu: this.beer.ibu,
      imgUrl: this.beer.imgUrl,
      name: this.beer.name,
    // brewery_id:  this.beer.brewery_id = this.$route.params.id;
      };
      AppServices.addBeer(this.$route.params.id, this.beer);
      this.locationReload();
      // this.$emit('review-submitted', productReview)
      event.preventDefault();
      // this.addReview(newBeer);

      this.brewery.beerList.push(addedBeer);


      this.beer.abv = "";
      this.beer.beer_type = "";
      this.beer.description = "";
      this.beer.ibu = "";
      this.beer.imgUrl = "";
      this.beer.name = "";
      this.beer.brewery_id = this.$route.params.id;
      // alert(JSON.stringify(this.form))
    },

    alertMe() {
      alert("THIS IS AN ALERT");
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.beer.abv = "";
      this.beer.beer_type = "";
      this.beer.description = "";
      this.beer.ibu = "";
      this.beer.imgUrl = "";
      this.beer.name = "";

      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },

    deleteBeer(beer) {
      AppServices.deleteBeer(beer);
    },
        locationReload() {
      location.reload();
    }
    
  },
};
</script>


<style>
#Brewery-logo {
  grid-column: 1/2;
  grid-row: 1/2;
  max-width: 300px;
}

.custom {
  width: 300px !important;
}
</style>