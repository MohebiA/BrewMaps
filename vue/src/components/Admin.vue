<template>
  <div class="admin">
    <nav-bar/>

   <!-- Form -->
    <section class="container mt-3 mb-4 border rounded">
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
          type="email"
          placeholder="Enter Brewery Name"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Brewery Phone Number:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.phoneNum"
          placeholder="Enter Brewery Phone Number"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Address:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.address_1"
          placeholder="Enter Brewery Address"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Second Address:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.address_2"
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
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Brewery Logo:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.breweryImgUrl"
          placeholder="Enter the url to the brewery logo"
          
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Brewery Website:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.websiteUrl"
          placeholder="Enter the url to the brewery website"
          
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Brewery History:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="newBrewery.description"
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

      <b-button v-on:click="createBrewery()" type="submit" variant="primary">Submit</b-button>
      <b-button v-on:click="onReset()" type="reset" variant="danger">Reset</b-button>
    </b-form>
    
  </div>
        
        
    </section>

    <section>
      <table id = "users-list">
        <thead>
          <tr>
            <th>User Id</th>
            <th>Username</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" v-bind:key="user.id" v-bind:user = "user">
            <td>{{user.username}}</td>
            <td>{{user.id}}</td>
            <td><button>DELETE</button></td>

          </tr>
          <p/>
        </tbody>
      </table>
    </section>




  </div>
</template>

<script>
import AppServices from '../services/AppServices'


  export default {
    data() {
      return {
        breweries: [],
        users: [],
        newBrewery: {
          name: "",
          brewerUsername: "",
          phoneNum: "",
          address_1: "",
          address_2: "",
          city: "",
          state: "",
          zip: "",
          hours: "",
          breweryImgUrl: "",
          websiteUrl: "",
          description: "",
          longitude: "",
          latitude: "",

        },



        form: {
          email: '',
          name: '',
          food: null,
          checked: []
        },
        foods: [{ text: 'Select One', value: null }, 'Carrots', 'Beans', 'Tomatoes', 'Corn'],
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

      createBrewery() {
        AppServices.createBrewery(this.newBrewery)
      },


    },

    created() {
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

</style>