<template>
  <div>
    <section id="brewerylist" class="p-5 bg-dark">
        <div class="container">
            <div class="row align-items-center justify-content-between text-center text-white">
                <h4>{{beer.name}}</h4>


                <div class="brewery-list">
                    
                    <div v-for="brewery in breweries" v-bind:key="brewery.id" @click="getDetails(brewery.id)">
                        <b-button class="mb-2" variant="outline-warning">{{brewery.name}}</b-button>
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
      beer: {},
    };
  },

  created() {
    AppServices.getBeerById(this.$route.params.id).then((response) => {
      this.beer = response.data;
    });
  },
};
</script>


<style>
</style>