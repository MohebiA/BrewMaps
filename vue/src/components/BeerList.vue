<template>
  <div>
    <section id="brewerylist" class="p-5 bg-dark">
      <div class="container">
        <div class="row align-items-center justify-content-between text-center">
          <h4 class="text-light">LIST OF BEERS</h4>
          <div class="col-md">
            <ul class="list-unstyled">
              <li>
                <router-link v-bind:to="{ name: 'beerdetails' }"
                  >BeerDetails</router-link
                >
              </li>
              <div>
  <b-button variant="outline-warning" v-b-modal.modal-multi-1>Beer Name</b-button>

  <b-modal id="modal-multi-1" size="lg" title="Beer Name" ok-only no-stacking>
    <p class="my-2">Beer Details</p>
    <b-button v-b-modal.modal-multi-2>Leave a review</b-button>
    <li>Reviews Placeholder</li>
  </b-modal>

  <b-modal id="modal-multi-2" title="Reviews" ok-only>
    <p class="my-2">Leave a review</p>

    <div>
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
    <!-- <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card> -->
  </div>
    
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
              <li><a href="#">Beer 2, OH</a></li>
              <li><a href="#">Beer 3, PA</a></li>
            </ul>
          </div>
          <div class="col-md p-5">
            <ul class="list-unstyled">
              <li><a href="#">Beer 4, TX</a></li>
              <li><a href="#">Beer 5, TX</a></li>
              <li><a href="#">Beer 6, FL</a></li>
              <li><a href="#">Beer 7, NJ</a></li>
            </ul>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
  export default {
    data() {
      return {
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
    }
  }
</script>