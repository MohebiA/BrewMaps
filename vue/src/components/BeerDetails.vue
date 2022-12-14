<template>
  <div>
    <section id="beerdetails" class="p-5 bg-dark">
      <!-- <b-button v-if="this.$store.state.user.authorities[0] = 'ROLE_BREWER'" class=" border border-2 border-dark m-5" v-on:click="deleteBeer(beer.id), getDetails(beer.breweryId)">
              DELETE BEER
            </b-button> -->

      <section
        v-if="this.$store.state.user.authorities[0].name == 'ROLE_BREWER'"
      >
        <div>
          <div class="mb-3">
            <b-button
              class="border border-2 border-dark m-5"
              v-on:click="deleteBeer(beer.id), getDetails(beer.breweryId)"
            >
              DELETE BEER
            </b-button>

            <b-button @click="fillForm()" v-b-toggle.my-collapse
              >Update Beer Form</b-button
            >
          </div>

          <b-collapse id="my-collapse">
            <b-card title="Collapsible card">
              <b-form @submit="locationReload" @reset="onReset" v-if="show">
                <h5 class="text-center">{{ beer.name }}</h5>
                <b-form-group
                  id="input-group-1"
                  label="Beer Name:"
                  label-for="input-1"
                >
                  <b-form-input
                    id="input-1"
                    v-model="updatedBeer.name"
                    type="text"
                    placeholder="Enter name"
                  ></b-form-input>
                </b-form-group>

                <b-form-group
                  id="input-group-1"
                  label="ABV:"
                  label-for="input-1"
                >
                  <b-form-input
                    id="input-1"
                    v-model="updatedBeer.abv"
                    type="text"
                    placeholder="ABV"
                  ></b-form-input>
                </b-form-group>

                <b-form-group
                  id="input-group-1"
                  label="IBU:"
                  label-for="input-1"
                >
                  <b-form-input
                    id="input-1"
                    v-model="updatedBeer.ibu"
                    type="text"
                    placeholder="IBU"
                  ></b-form-input>
                </b-form-group>

                <b-form-group
                  id="input-group-1"
                  label="Beer Type:"
                  label-for="input-1"
                >
                  <b-form-input
                    id="input-1"
                    v-model="updatedBeer.beer_type"
                    type="text"
                    placeholder="Type"
                  ></b-form-input>
                </b-form-group>

                <b-form-group
                  id="input-group-1"
                  label="Image URL:"
                  label-for="input-1"
                >
                  <b-form-input
                    id="input-1"
                    v-model="updatedBeer.imgUrl"
                    type="text"
                    placeholder="URL"
                  ></b-form-input>
                </b-form-group>

                <b-form-group
                  id="input-group-1"
                  label="Description:"
                  label-for="input-1"
                >
                  <b-form-textarea
                    id="input-1"
                    v-model="updatedBeer.description"
                    placeholder="Enter beer details"
                  ></b-form-textarea>
                </b-form-group>

                <!-- <b-form-group>
                <b-form-checkbox id = "checkbox-1"
                v-model="updatedBeer.isActive"
                name = "checkbox-1"
                value = "false"
                unchecked-value="true">Check to deactivate brewery, uncheck to reactivate brewery

                </b-form-checkbox>

                <div>active: <strong>{{updatedBrewery.isActive}}</strong></div>

              </b-form-group> -->

                <div class="brewerCheck"></div>

                <b-button
                  class="ml-2"
                  type="submit"
                  variant="primary"
                  @click="updateBeer(updatedBeer.id, updatedBeer)"
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

      <div class="container">
        <div
          class="
            row
            align-items-center
            justify-content-between
            text-center text-white
          "
        >
          <div>
            <h5 id="null message" v-if="beer.imgUrl === null">
              <b-card
                id="logoBeer"
                class="position-relative"
                :img-src="
                  require('../Assets/giovanna-gomes-Qy2KMPRV3X4-unsplash.jpg')
                "
              ></b-card>
            </h5>
            <h5 v-else>{{ beer.imgUrl }}</h5>
          </div>

          <h4>{{ beer.name }}</h4>
          <h5 id="null message" v-if="beer.name === ''">
            Beer Name: Coming Soon
          </h5>

          <h5 id="null message" v-if="beer.ABV === ''">ABV: Coming Soon</h5>
          <h5 v-else>ABV: {{ beer.abv }}</h5>

          <h5 id="null message" v-if="beer.IBU === ''">IBU: Coming Soon</h5>
          <h5 v-else>IBU: {{ beer.ibu }}</h5>

          <h5 id="null message" v-if="beer.beer_type === ''">
            Type: Coming Soon
          </h5>
          <h5 v-else>Type: {{ beer.beer_type }}</h5>

          <h5 id="null message" v-if="beer.description === ''">
            Description: Coming Soon
          </h5>
          <h5 v-else>Description: {{ beer.description }}</h5>

          <h5 id="null message" v-if="beer.imgUrl === ''">
            <b-img
              id="logoBeer"
              class="img-fluid mx-auto d-block m-4"
              :src="
                require('../Assets/giovanna-gomes-Qy2KMPRV3X4-unsplash.jpg')
              "
            ></b-img>
          </h5>
          <h5 v-else>{{ beer.imgUrl }}</h5>

          <!-- @click="getBeerById()" -->
          <div class="brewery-list">
            <div v-bind:key="beer.id">
              <b-button
                v-b-modal.modal-tall
                class="mb-2"
                variant="outline-warning"
                >Leave a review</b-button
              >
              <b-modal
                id="modal-tall"
                title="Beer Review"
                ok-only
                ok-title="Cancel"
              >
                <b-form @submit="onSubmit" @reset="onReset" v-if="show">
                  <h5 class="text-center">{{ beer.name }}</h5>
                  <b-form-group
                    id="input-group-1"
                    label="Your name:"
                    label-for="input-1"
                  >
                    <b-form-input
                      id="input-1"
                      v-model="form.name"
                      type="text"
                      placeholder="Enter your name"
                      required
                    ></b-form-input>
                  </b-form-group>

                  <b-form-group
                    id="input-group-2"
                    label="Leave a review:"
                    label-for="input-2"
                  >
                    <b-form-textarea
                      id="input-2"
                      v-model="form.review"
                      placeholder="Enter Review"
                      required
                    ></b-form-textarea>
                  </b-form-group>

                  <b-form-group
                    class="pb-3"
                    id="input-group-3"
                    label="Leave a rating:"
                    label-for="input-3"
                  >
                    <div>
                      <b-form-rating
                        variant="warning"
                        v-model="form.value"
                      ></b-form-rating>
                    </div>
                  </b-form-group>

                  <b-button
                    class="m-1"
                    type="submit"
                    variant="primary"
                    @click="locationReload()"
                    >Submit</b-button
                  >
                  <b-button type="reset" variant="danger">Reset</b-button>
                </b-form>

                <!-- <div>
                                    <b-form-rating v-model="value" show-value></b-form-rating>
                                      <p class="mt-2">Value: {{ value }}</p>
                                    </div> -->
              </b-modal>

              <div class="mt-4">
                <div class="well">
                  <span class="amount" v-on:click="updateFilter()">
                    {{ averageRating }}</span
                  >
                  Average Rating
                </div>

                <h2>Reviews</h2>
                <ul>
                  <li
                    class="list-unstyled border border-warning p-2 m-2 rounded"
                    v-for="review in beer.reviews"
                    v-bind:key="review.id"
                  >
                    <p>{{ review.name }}</p>
                    <p>{{ review.review }}</p>
                    <div>
                      <label for="rating-readonly">Rating:</label>
                      <b-form-rating
                        id="rating-readonly"
                        :value="review.value"
                        readonly
                        show-value
                        precision="0"
                      ></b-form-rating>
                    </div>
                  </li>
                </ul>
              </div>

              <product-review @review-submitted="addReview"></product-review>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>


<script>
import AppServices from "../services/AppServices";

export default {
  data() {
    return {
      updatedBeer: {
        abv: "",
        beenRemoved: false,
        beer_type: "",
        brewer: {},
        breweryId: "",
        description: "",
        ibu: "",
        id: this.$route.params.id,
        imgUrl: "",
        name: "",
      },
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
      form: {
        review: "",
        name: "",
        value: null,
      },
      reviews: [],
      show: true,
    };
  },
  methods: {
    onSubmit(event) {
      let productReview = {
        name: this.form.name,
        review: this.form.review,
        value: this.form.value,
      };

      AppServices.createReview(this.form, this.beer.id);

      // this.$emit('review-submitted', productReview)
      event.preventDefault();
      this.addReview(productReview);

      this.form.name = "";
      this.form.review = "";
      this.form.value = 0;
      // alert(JSON.stringify(this.form))
    },

    saveReview() {
      AppServices.createReview(this.productReview, this.beer.id);
    },

    addReview(productReview) {
      this.reviews.push(productReview);
    },

    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.name = "";
      this.form.review = "";
      this.form.value = 0;

      this.updatedBeer.abv = "";
      this.updatedBeer.beer_type = "";
      this.updatedBeer.description = "";
      this.updatedBeer.ibu = "";
      this.updatedBeer.imgUrl = "";
      this.updatedBeer.name = "";

      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },

    deleteBeer(id) {
      AppServices.deleteBeer(id);
    },

    updateBeer(id, beer) {
      AppServices.updateBeer(id, beer);
    },

    getDetails(id) {
      this.$router.push({ name: "brewerydetails", params: { id: id } });
    },

    fillForm() {
      this.updatedBeer.abv = this.beer.abv;
      this.updatedBeer.beer_type = this.beer.beer_type;
      this.updatedBeer.description = this.beer.description;
      this.updatedBeer.ibu = this.beer.ibu;
      this.updatedBeer.imgUrl = this.beer.imgUrl;
      this.updatedBeer.name = this.beer.name;
    },

    locationReload() {
      location.reload();
    },
  },
  computed: {
    averageRating() {
      const beerReviews = this.beer.reviews;
      let sum = beerReviews.reduce((currentSum, review) => {
        return currentSum + review.value;
      }, 0);
      if (sum === 0) {
        return 0;
      } else {
        return (sum / beerReviews.length).toFixed(2);
      }
    },
  },

  created() {
    //RICH TEST LINE
    this.beer.id = this.$route.params.id;

    AppServices.getBeerById(this.$route.params.id).then((response) => {
      //TODO: REMOVE BEFORE PROD
      // alert(this.$route.params.id);

      this.beer = response.data;

      //TODO: REMOVE BEFORE PROD
      // alert(JSON.stringify(response.data));
    });
  },
};
</script>


<style>
</style>