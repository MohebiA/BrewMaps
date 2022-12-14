<template >
  <div id="gradient" class="admin">
    <nav-bar/>

   <!-- Form -->
    <section class="container  mb-5 p-5 border border-dark rounded bg-light">
      <h1 class="h3 mb-3 font-weight-normal">Add Brewery</h1>
        <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="Brewery Name:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="newBrewery.name"
          type="text"
          placeholder="Enter Brewery Name"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="input-group-1"
        label="Brewer Username:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="newBrewery.brewerUsername"
          type="text"
          placeholder="Enter Brewer Username"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Brewery Phone Number:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.phoneNumber"
          placeholder="Enter Brewery Phone Number"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Address:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.address1"
          placeholder="Enter Brewery Address"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Second Address:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.address2"
          placeholder="Enter second address if applicable"
          
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="City:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.city"
          placeholder="Enter city"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="State:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.state"
          placeholder="Enter state"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Zip:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.zip"
          placeholder="Enter zipcode"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Hours:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.hours"
          placeholder="Enter hours of operation"
          
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Brewery Logo:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.imgUrl"
          placeholder="Enter the url to the brewery logo"
          
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Brewery Website:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.url"
          placeholder="Enter the url to the brewery website"
          
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Brewery History:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.history"
          placeholder="Enter a brief description for the history of the brewery"
          required
        ></b-form-input>
      </b-form-group>

      <!-- <b-form-group id="input-group-2" label="Longitude:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.longitude"
          placeholder="Enter longitude of brewery location"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Latitude:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.latitude"
          placeholder="Enter latitude of brewery location"
          required
        ></b-form-input>
      </b-form-group> -->

    

<!-- 
      <b-form-group id="input-group-3" label="Been Active:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="newBrewery.food"
          :options="foods"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
        <b-form-checkbox-group
          v-model="newBrewery.checked"
          id="checkboxes-4"
          :aria-describedby="ariaDescribedby"
        >
          <b-form-checkbox value="me">Check me out</b-form-checkbox>
          <b-form-checkbox value="that">Check that out</b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group> -->
      
      <b-button class="ml-2" type="submit" variant="primary" @click="locationReload()">Submit</b-button>
      <b-button class="m-2" type="reset" variant="danger">Reset</b-button>
    </b-form>
    
  </div>
        
        
    </section>

    <section class="container border border-dark rounded bg-light">
      <table id = "users-list">
        <thead>
          <tr>
            <th>Username</th>
            <!-- <th>User Id</th> -->
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" v-bind:key="user.id" v-bind:user = "user">
            <td><b-button class = "delete" variant="danger" v-on:click="deleteUser(user.id)">DELETE</b-button></td>
            <td>{{user.username}}</td>
            <!-- <td>{{user.id}}</td> -->

          </tr>
          <p/>
        </tbody>
      </table>

    <!-- <section>
      <Userlist/>



    </section> -->



      <table id = "brewery-list">
        <thead>
          <tr>
            <th>Brewery name</th>
            <!-- <th>Brewery Id</th> -->
          </tr>
        </thead>
        <tbody>
          <tr v-for="brewery in breweries" v-bind:key="brewery.id" v-bind:brewery = "brewery">
            <td><b-button class = "delete" variant="danger"  v-on:click="deleteBrewery(brewery.id)">DEACTIVATE</b-button></td>
            <td>{{brewery.name}}</td>
            <!-- <td>{{brewery.id}}</td> -->

          </tr>
          <p/>
        </tbody>
      </table>
    </section>




  </div>
</template>

<script>
import AppServices from '../services/AppServices'
// import Userlist from './Userlist.vue'


  export default {
  // components: { Userlist },
    data() {
      return {
        breweries: [],
        users: [],
        newBrewery: {
          name: "",
          brewerUsername: "",
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



        form: {
          email: '',
          name: '',
          food: null,
          checked: []
        },
        show: true
      }
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()
        // alert(JSON.stringify(this.form))
        AppServices.createBrewery(this.newBrewery)





          this.newBrewery.name = ""
          this.newBrewery.brewerUsername = ""
          this.newBrewery.phoneNumber = ""
          this.newBrewery.address1 = ""
          this.newBrewery.address2 = ""
          this.newBrewery.city = ""
          this.newBrewery.state = ""
          this.newBrewery.zip = ""
          this.newBrewery.hours = ""
          this.newBrewery.imgUrl = ""
          this.newBrewery.url = ""
          this.newBrewery.history = ""
          this.newBrewery.longitude = ""
          this.newBrewery.latitude = ""
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        // this.newBrewery.email = ''
        // this.form.name = ''
        // this.form.food = null
        // this.form.checked = []



          this.newBrewery.name = ""
          this.newBrewery.brewerUsername = ""
          this.newBrewery.phoneNum = ""
          this.newBrewery.address_1 = ""
          this.newBrewery.address_2 = ""
          this.newBrewery.city = ""
          this.newBrewery.state = ""
          this.newBrewery.zip = ""
          this.newBrewery.hours = ""
          this.newBrewery.breweryImgUrl = ""
          this.newBrewery.websiteUrl = ""
          this.newBrewery.description = ""
          this.newBrewery.longitude = ""
          this.newBrewery.latitude = ""
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },

      locationReload() {
       location.reload();
      },
      createBrewery() {
        AppServices.createBrewery(this.newBrewery)
      },

      deleteUser(id) {
        AppServices.deleteUser(id);
               location.reload();

      },

       deleteBrewery(id) {
        AppServices.deleteBrewery(id);
               location.reload();

      },


    },

    created() {
        AppServices.getUsers().then(response => {
          this.users = response.data;
          
        }).catch(error=>{
          
          location.reload();
          console.log(error);

        }),

        AppServices.getBreweries().then(response => {
          this.breweries = response.data;
        })
        
          
        
      

    },
    mounted() {
      AppServices.getUsers().then(response => {
          this.users = response.data;
          
        }),

     AppServices.getBreweries().then(response => {
          this.breweries = response.data;
        })
    }
  }
</script>

<style>
#gradient {
    /* background-color:rgb(68, 35, 19); */
background: rgb(33,37,41);
background: linear-gradient(0deg, rgba(33,37,41,1) 0%, rgba(215,215,215,1) 15%, rgba(215,215,215,1) 85%, rgba(255,193,7,1) 100%);
    min-height: 71.25vh;
    

}
</style>