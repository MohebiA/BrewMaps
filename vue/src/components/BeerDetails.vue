<template>
  <div>
    
    <section id="brewerylist" class="p-5 bg-dark">

        <b-button v-if="this.$store.state.user.username == 'ROLE_BREWER'" class=" border border-2 border-dark m-5" v-on:click="deleteBeer(beer.id), getDetails(beer.breweryId)">
              DELETE BEER
            </b-button>


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
              <b-img
                id="Brewery-logo"
                :src="
                  require('../Assets/giovanna-gomes-Qy2KMPRV3X4-unsplash.jpg')
                "
              ></b-img>
            </h5>
            <h5 v-else>{{ beer.imgUrl }}</h5>
          </div>

          <h4>{{ beer.name }}</h4>
          <h5 id="null message" v-if="beer.name === null">
            Beer Name: Coming Soon
          </h5>

          <h5 id="null message" v-if="beer.ABV === null">ABV: Coming Soon</h5>
          <h5 v-else>ABV: {{ beer.abv }}</h5>

          <h5 id="null message" v-if="beer.IBU === null">IBU: Coming Soon</h5>
          <h5 v-else>IBU: {{ beer.ibu }}</h5>

          <h5 id="null message" v-if="beer.beer_type === null">
            Type: Coming Soon
          </h5>
          <h5 v-else>Type: {{ beer.beer_type }}</h5>

          <h5 id="null message" v-if="beer.description === null">
            Description: Coming Soon
          </h5>
          <h5 v-else>Description: {{ beer.description }}</h5>

          <h5 id="null message" v-if="beer.imgUrl === null">
            Image: Coming Soon
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
                    {{averageRating}}</span>
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

      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },

    deleteBeer(id) {
      AppServices.deleteBeer(id);

    },

    getDetails(id) {
            this.$router.push({name: 'brewerydetails', params: {id:id}})
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
      if(sum === 0) {
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