<template>
<div>
<Admin/>
</div>
</template>

<script>
import Admin from "../components/Admin.vue"
import AppServices from "../services/AppServices";

export default {
  name: "admin",
  components: {
    Admin,
  },
  
  created() {
    AppServices.getUsers().then(response => {
          this.users = response.data;
          
        }),

        AppServices.getBreweries().then(response => {
          this.breweries = response.data;
        })
  }
};
</script>