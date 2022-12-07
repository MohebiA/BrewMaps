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
                <b-button v-b-modal.modal-tall variant="outline-warning"
                  >Beer Modal</b-button
                >

                <b-modal id="modal-tall" title="Beer Details">
                  <p class="my-4" v-for="i in 20" :key="i">
                    Cras mattis consectetur purus sit amet fermentum. Cras justo
                    odio, dapibus ac facilisis in, egestas eget quam. Morbi leo
                    risus, porta ac consectetur ac, vestibulum at eros.
                  </p>

                  <!-- Need to finish actions for each button to close and review -->
                  <template #modal-footer>
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
              </div>
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
export default {};
</script>



<style>
</style>