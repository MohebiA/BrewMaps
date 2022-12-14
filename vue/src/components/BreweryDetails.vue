<template>
  <div>
    <div
      class="text-center p-3"
      style="
        background-image: url('https://wallpaperset.com/w/full/c/e/7/484397.jpg');
        height: 50vw;
      "
    >
      <h1 class="text-white">{{ brewery.name }}</h1>

      <h5 id="null message" v-if="brewery.imgUrl === '' || brewery.imgUrl === null">
        <div>
          <b-img
            id="Brewery-logo"
            class="img-fluid mx-auto d-block m-4"
            :src="require('../Assets/breweries.jpg')"
          ></b-img>
        </div>
      </h5>
      <h5 v-else>
        <div>
          <b-img
            id="Brewery-logo"
            class="img-fluid mx-auto d-block m-4"
            :src="this.brewery.imgUrl"
          ></b-img>
        </div>
      </h5>
    </div>

    <section id="inactive" v-if="!this.brewery.active" class="container">
      <h5 class="row justify-content-center">THIS BREWERY IS INACTIVE</h5>
    </section>

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

    <section
      class="container-fluid px-0"
      style="
        background-image: url('src\Assets\484397flipped.jpg');
        height: 25vw;
      "
    >
      <div class="row align-items-center content mt-4">
        <div class="col-md-6 order-2 order-md-1 text-center">
          <h2>ADDRESS</h2>
          <h5>{{ brewery.address1 }}</h5>
          <h5
            id="null message"
            v-if="brewery.address1 === '' || brewery.address1 === null"
          >
            Coming Soon
          </h5>
        </div>
        <div class="col-md-6 text-center order-1 order-md-2">
          <div class="row justify-content-center">
            <div class="col-10 col-lg-8 mb-5 mb-md-0">
              <h2>BREWERY CONTACT INFO</h2>
              <h5>{{ brewery.phoneNumber }}</h5>
              <h5
                id="null message"
                v-if="
                  brewery.phoneNumber === '' || brewery.phoneNumber === null
                "
              >
                Coming Soon
              </h5>
            </div>
          </div>
        </div>
      </div>
      <div class="row align-items-center content">
        <div class="col-md-6 text-center">
          <div class="row justify-content-center">
            <div class="col-10 col-lg-8 mb-5 mb-md-0 mt-5">
              <h2>WEBSITE</h2>
              <h5>
                <a :href="this.brewery.url">{{ brewery.url }}</a>
              </h5>

              <h5
                id="null message"
                v-if="this.brewery.url === '' || brewery.url === null"
              >
                Coming Soon
              </h5>
            </div>
          </div>
        </div>
        <div class="col-md-6 text-center">
          <h2>BREWERY HOURS</h2>
          <h5>{{ brewery.hours }}</h5>
          <h5
            id="null message"
            v-if="brewery.hours === '' || brewery.hours === null"
          >
            Coming Soon
          </h5>
        </div>
      </div>

      <div class="row align-items-center text-center mt-5">
        <h2>BREWERY HISTORY</h2>
        <h5 class="text-center">{{ brewery.description }}</h5>
        <h5
          id="null message"
          v-if="brewery.description === '' || brewery.description === null"
          class="text-center"
        >
          Coming Soon
        </h5>
      </div>
    </section>

    <section class="container mt-5 mb-5">
      <!-- v-if="this.$store.state.users.user_id === this.brewery.user_id || this.$store.state.users.user_id === 2" -->

      <div class="buttons heightChange">
        <b-button
          id="addBeer"
          @click="location.reload()"
          v-if="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'"
          v-b-modal.modal-tall
          class="breweryButtons"
          variant="primary"
          >Add a Beer</b-button
        >

        <b-button
          class="breweryButtons"
          @click="fillForm()"
          v-if="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'"
          v-b-toggle.my-collapse
          >Update Brewery Form</b-button
        >
      </div>

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
              type="image"
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

      <div>
        <div class="mb-3">
          <!-- <b-button @click="fillForm()"
            v-if="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'"
            v-b-toggle.my-collapse
            >Update Brewery Form</b-button> -->
        </div>

        <b-collapse id="my-collapse" class="mb-5">
          <b-card title="Update Brewery Information">
            <b-form @submit="locationReload" @reset="onReset" v-if="show">
              <b-form-group
                id="input-group-1"
                label="Brewery Name:"
                label-for="input-1"
              >
                <b-form-input
                  id="input-1"
                  value="brewery.name"
                  v-model="updatedBrewery.name"
                  type="text"
                  placeholder="Enter Brewery Name"
                ></b-form-input>
              </b-form-group>
              <!--  
      <b-form-group
        id="input-group-1"
        label="Brewer Username:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="brewery.brewerUsername"
          type="text"
          placeholder="Enter Brewer Username"
          required
        ></b-form-input>
      </b-form-group> -->

              <b-form-group
                id="input-group-2"
                label="Brewery Phone Number:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.phoneNumber"
                  v-model="updatedBrewery.phoneNumber"
                  placeholder="Enter Brewery Phone Number"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                id="input-group-2"
                label="Address:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.address1"
                  v-model="updatedBrewery.address1"
                  placeholder="Enter Brewery Address"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                id="input-group-2"
                label="Second Address:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.address2"
                  v-model="updatedBrewery.address2"
                  placeholder="Enter second address if applicable"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                id="input-group-2"
                label="City:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.city"
                  v-model="updatedBrewery.city"
                  placeholder="Enter city"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                id="input-group-2"
                label="State:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.state"
                  v-model="updatedBrewery.state"
                  placeholder="Enter state"
                ></b-form-input>
              </b-form-group>

              <b-form-group id="input-group-2" label="Zip:" label-for="input-2">
                <b-form-input
                  id="input-2"
                  value="brewery.zip"
                  v-model="updatedBrewery.zip"
                  placeholder="Enter zipcode"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                id="input-group-2"
                label="Hours:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.hours"
                  v-model="updatedBrewery.hours"
                  placeholder="Enter hours of operation"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                id="input-group-2"
                label="Brewery Logo:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.imgUrl"
                  v-model="updatedBrewery.imgUrl"
                  placeholder="Enter the url to the brewery logo"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                id="input-group-2"
                label="Brewery Website:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.url"
                  v-model="updatedBrewery.url"
                  placeholder="Enter the url to the brewery website"
                ></b-form-input>
              </b-form-group>

              <b-form-group
                id="input-group-2"
                label="Brewery History:"
                label-for="input-2"
              >
                <b-form-input
                  id="input-2"
                  value="brewery.history"
                  v-model="updatedBrewery.history"
                  placeholder="Enter a brief description for the history of the brewery"
                ></b-form-input>
              </b-form-group>

              <b-form-group>
                <b-form-checkbox
                  id="checkbox-1"
                  value="false"
                  v-model="updatedBrewery.active"
                  name="checkbox-1"
                  unchecked-value="true"
                  >Check to deactivate brewery, uncheck to reactivate brewery
                </b-form-checkbox>

                <div>
                  active: <strong>{{ updatedBrewery.active }}</strong>
                </div>
              </b-form-group>

              <div class="brewerCheck">
                <h5>
                  Check to deactivate brewery, uncheck to reactive brewery
                </h5>
                <!-- <div>
            <input type="checkbox" class="form-check-input" v-model="updatedBrewery.beenRemoved" v-on:change="(updatedBrewery.beenRemoved=='false' ? updatedBrewery.beenRemoved='true': updatedBrewery.beenRemoved='false')">
            <label for="form-check-label"></label>
          </div> -->
              </div>

              <b-button
                class="ml-2"
                type="submit"
                variant="primary"
                @click="
                  updateBrewery(updatedBrewery.brewery_id, updatedBrewery)
                "
                >Submit</b-button
              >
              <b-button class="m-2" type="reset" variant="danger"
                >Reset</b-button
              >
            </b-form>
          </b-card>
        </b-collapse>
      </div>
    </section>

    <section class="container-fluid">
      <div class="row justify-content-center bg-dark bg-gradient">
        <div class="text-center p-5">
          <!-- <router-link v-bind:to="{ name: 'beerlist' }"
            ><b-button variant="primary">View Beer List</b-button></router-link -->
          <!-- > -->
          <h4 class="text-light">BEER LIST</h4>

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
              {{ beer.style }}
              <hr />
              {{ beer.avgRating }} Average Star Rating
            </b-button>

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
      updatedBrewery: {
        brewery_id: this.$route.params.id,
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
        beenRemoved: "",
        active: "",
      },

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
    AppServices.getBreweryById(this.$route.params.id)
      .then((response) => {
        this.brewery = response.data;
      })
      .catch((error) => {
        alert(error);
        location.reload();
        console.log(error);
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
      this.locationReload();
    },

    fillForm() {
      this.updatedBrewery.name = this.brewery.name;
      this.updatedBrewery.phoneNumber = this.brewery.phoneNumber;
      this.updatedBrewery.address1 = this.brewery.address1;
      this.updatedBrewery.address2 = this.brewery.address2;
      this.updatedBrewery.city = this.brewery.city;
      this.updatedBrewery.state = this.brewery.state;
      this.updatedBrewery.zip = this.brewery.zip;
      this.updatedBrewery.hours = this.brewery.hours;
      this.updatedBrewery.imgUrl = this.brewery.imgUrl;
      this.updatedBrewery.url = this.brewery.url;
      this.updatedBrewery.history = this.brewery.description;
      this.updatedBrewery.longitude = this.brewery.longitude;
      this.updatedBrewery.latitude = this.brewery.latitude;
      this.updatedBrewery.beenRemoved = this.brewery.beenRemoved;
      this.updatedBrewery.active = this.brewery.active;
    },

    updateBrewery(id, brewery) {
      AppServices.updateBrewery(id, brewery);
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
    },
  },
};
</script>


<style>
b-img.resize {
  width: 100vw;
  height: auto;
}

#Brewery-logo {
  grid-column: 1/2;
  grid-row: 1/2;
  max-width: 100vx;
}

.custom {
  width: 300px !important;
}

#inactive {
  background-color: #ff9696;
  padding: 20px;
  margin-bottom: 10px;
}

#addBeer {
  margin-right: 30px;
}

.buttons {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.breweryButtons {
  min-width: 250px;
}

.heightChange {
  margin-top: 150px;
}
</style>