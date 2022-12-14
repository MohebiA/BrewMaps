<template>
    <footer id="footer" class="p-3 bg-dark text-white text-center position-relative container-fluid">
        <div class="container-fluid">
          
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
/* 
 #footer {
    margin: 0 auto;
  } */


  .footbutton {
    min-width: 200px;
    
  }

</style>