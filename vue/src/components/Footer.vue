<template>
    <footer id="footer" class="p-3 bg-dark text-white text-center position-relative">
        <div class="container">
            <p></p>
            <a href="#" class="position-absolute bottom-0 end-0 p-5">
                <i class="bi bi-arrow-up-circle"></i>
            </a>
        </div>

        <div>
          <b-col>
            <b-row>
              <p><router-link v-bind:to="{ name: 'aboutus' }"><b-button class = "footbutton" variant="warning">ABOUT US</b-button ></router-link></p>
            </b-row>
            
            <b-row>
              <p><b-button class ="footbutton" variant="warning">CONTACT US</b-button></p>
            </b-row>

            <b-row>
              <p>COPYRIGHT &copy; 2022 BREWMAPS.CO</p>
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

 /* #footer {
    position:fixed;
    bottom:0;
  } */


  .footbutton {
    min-width: 200px;
  }

</style>