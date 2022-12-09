<template>
  <div>
    <section id="brewerylist" class="p-5 bg-dark">
        <div class="container">
            <div class="row align-items-center justify-content-between text-center text-white">
                <h4>{{beer.name}}</h4>
                <h5>ABV: {{beer.abv}}</h5>
                <h5>IBU: {{beer.ibu}}</h5>
                <h5>Type: {{beer.beer_type}}</h5>
                <h5>description: {{beer.description}}</h5>
                <h5>{{beer.imgUrl}}</h5>


                <div class="brewery-list">
                    
                    <div v-bind:key="beer.id" @click="getBeerById()">
                        <b-button v-b-modal.modal-tall class="mb-2" variant="outline-warning">Leave a review</b-button>
                          <b-modal id="modal-tall" title="Beer Details">
                               <b-form @submit="onSubmit" @reset="onReset" v-if="show">
                                  <b-form-group
                                    id="input-group-1"
                                    label="Your name:"
                                    label-for="input-1"
                                    description="Please enter your name."
                                  >
                                    <b-form-input
                                      id="input-1"
                                      v-model="form.name"
                                      type="text"
                                      placeholder="Enter your name"
                                      required
                                    ></b-form-input>
                                  </b-form-group>

                                  <b-form-group id="input-group-2" label="Leave a review:" label-for="input-2">
                                    <b-form-input
                                      id="input-2"
                                      v-model="form.review"
                                      placeholder="Enter review"
                                      required
                                    ></b-form-input>
                                  </b-form-group>

                                  <b-form-group id="input-group-3" label="Leave a rating:" label-for="input-3">
                                    <div>
                                        <b-form-rating variant="warning" v-model="form.value"></b-form-rating>
                                        <p class="mt-2">Value: {{ value }}</p>

                                    </div>

                                    
                                  
                                  </b-form-group>


                                  
                                

                                  <b-button type="submit" variant="primary">Submit</b-button>
                                  <b-button type="reset" variant="danger">Reset</b-button>
                                </b-form>




                          







                                
                                 <p class="my-4">
                                     {{beer.name}}
                                </p>
                                  <!-- <div>
                                    <b-form-rating v-model="value" show-value></b-form-rating>
                                      <p class="mt-2">Value: {{ value }}</p>
                                    </div> -->
                             </b-modal> 

                        
                    </div>
                    







                                  <!-- <div>
                <b-button v-b-modal.modal-tall variant="outline-warning"
                  >Beer Modal</b-button
                >

                <b-modal id="modal-tall" title="Beer Details">
                  <p class="my-4" v-for="i in 20" :key="i">
                    Cras mattis consectetur purus sit amet fermentum. Cras justo
                    odio, dapibus ac facilisis in, egestas eget quam. Morbi leo
                    risus, porta ac consectetur ac, vestibulum at eros.
                  </p> -->

              <!-- Need to finish actions for each button to close and review -->
              <!-- <template #modal-footer>
                    <button
                      v-b-modal.modal-close_visit
                      class="btn btn-danger btn-sm m-1"
                    >
                      Close
                    </button>
                    <button
                      v-b-modal.modal-close_visit
                      class="btn btn-warning btn-sm m-1"
                    >
                      Review Beer
                    </button>
                  </template>
                </b-modal>
              </div> -->










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
      beer: {},
       form: {
      review: '',
      name: '',
      value: null,
    },
    show: true
    }

  },
  methods: {
      onSubmit(event) {
        event.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.name = ''
        this.form.food = null
        this.form.checked = []
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
  },
    created() {
    AppServices.getBeerById(this.$route.params.id).then((response) => {
      this.beer = response.data;
    });
  }
}

</script>


<style>
</style>