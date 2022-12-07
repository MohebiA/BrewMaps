<template>
    <footer class="p-3 bg-secondary text-white text-center position-relative">
        <div class="container">
            <p></p>
            <a href="#" class="position-absolute bottom-0 end-0 p-5">
                <i class="bi bi-arrow-up-circle"></i>
            </a>
        </div>

        <div>
          <b-col>
            <b-row>
              <p><router-link v-bind:to="{ name: 'aboutus' }"><b-button>About Us</b-button></router-link></p>
            </b-row>
            
            <b-row>
              <p><b-button>Contact Us</b-button></p>
            </b-row>

            <b-row>
              <p>Copyright &copy; 2022 BrewMaps.Co</p>
            </b-row>

          </b-col>

        </div>
    </footer>
</template>


<script>
export default {
    setup() {
        
    },
}
</script>





<style>

</style>