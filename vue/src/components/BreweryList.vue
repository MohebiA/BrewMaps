<template>
    <div>
        <div class = "heading">
        </div>

<section id="brewerylist" class="p-5">
        <div class="container">
            <div class="row align-items-center justify-content-between text-center text-white">
                <h4>LIST OF BREWERIES</h4>


                <div class="brewery-list">
                    
                    <div v-for="brewery in breweries" v-bind:key="brewery.id" @click="getDetails(brewery.id), setSelectedBrewery(brewery)">
                        <b-button class="mb-2 customButton" variant="outline-warning">
                            {{brewery.name}}
                            <hr />
                            {{brewery.distance}} Miles
                            </b-button>
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
            breweries: {

            },
            selectedBreweryId: "",

            
        }
    },
    methods: {
        getDetails(id) {
            this.$router.push({name: 'brewerydetails', params: {id:id}})
        },
        setSelectedBreweryId(id) {
            this.$store.commit("SET_SELECTED_BREWERY_ID", this.selectedBreweryId)
            this.$router.push({ name: 'brewerydetails', params:{id:id} })
        },
        setSelectedBrewery(brewery) {
            this.$store.commit("SELECT_BREWERY", brewery)
        }
    },

    created() {
        AppServices.list(this.$store.state.zipcode, this.$store.state.radius).then((response) => {
            this.breweries = response.data
        })
    }
    
      
}
</script>

<style>

.customButton {
  width: 300px !important;
  background-color: rgb(35, 39, 43);
}

#brewerylist {
    /* background-color:rgb(68, 35, 19); */
background: rgb(33,37,41);
background: linear-gradient(0deg, rgba(33,37,41,1) 0%, rgba(215,215,215,1) 15%, rgba(215,215,215,1) 85%, rgba(255,193,7,1) 100%);
    min-height: 71.25vh;
    

}


</style>