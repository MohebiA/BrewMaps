<template>
   <div class="home " >
    <nav-bar></nav-bar>
   <section class="text-dark p-5 pb-0 pt-2 bg-light">
        <div class="container-fluid">
            <div class="d-sm-flex align-items-center justify-content-between">
            <div>
                <h2>Find a fabulous brewery and explore their beer selection</h2>
                <p>Built by beer lovers, for beer lovers.</p>


<!-- change dropdown to be text input for ZIP and radius (in miles) -->
                <div class="dropdown">
                  <div class="btn-group">
                      <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Choose a Location</button>
                      <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="cities/scottsdale/scottsdaleMap.html">Scottsdale, AZ</a></li>
                        <li><a class="dropdown-item" href="#">Anaheim, CA</a></li>
                        <li><a class="dropdown-item" href="#">Columbus, OH</a></li>
                        <li><a class="dropdown-item" href="#">Pittsburgh, PA</a></li>
                      
                    </ul>
                    </div>
                    
                  </div>
                  <p class="text-secondary pt-4">More cities coming soon... <br> Reach out if you want your city to be next!</p>
            </div>
            <b-img class="img-fluid w-50" src="image" alt=""></b-img>
        </div>
        </div>
    </section>


    <section class="p-5">
        <div class="container">
            <div class="row text-center g-4">
                <div class="col-md d-flex justify-content-center">
                    <div class="card" style="width: 18rem;">
                        <img src="assets/drivingrangeballs.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h5 class="card-title">Submit Your Brewery</h5>
                          <p class="card-text">Keep your brewery and beer list information up-to-date</p>
                          <a href="#" class="btn btn-warning">Add Brewery</a>
                        </div>
                      </div>
                </div>
                <div class="col-md d-flex justify-content-center">
                    <div class="card" style="width: 18rem;">
                        <img src="assets/drivingrangeballs.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                          <h5 class="card-title">Become a "Registered" Beer Love</h5>
                          <p class="card-text">Discover breweries and beers and add your expert ratings and reviews</p>
                          <a href="#" class="btn btn-warning">Register</a>
                        </div>
                      </div>
                </div>
                    
                </div>
            </div>
      
    </section>

<!-- PUT IMAGE CAROSEL HERE -->
    <section>

    </section>

<!-- <footer class="p-3 bg-secondary text-white text-center position-relative">
        <div class="container">
            <p></p>
            <a href="#" class="position-absolute bottom-0 end-0 p-5">
                <i class="bi bi-arrow-up-circle"></i>
            </a>
        </div>

        <div>
          <b-col>
            <b-row>
              <p>About Us</p>
            </b-row>
            
            <b-row>
              <p>Contact Us</p>
            </b-row>

            <b-row>
              <p>Copyright &copy; 2022 BrewMaps.Co</p>
            </b-row>

          </b-col>

        </div>
    </footer> -->


  </div>
</template>

<script>
//import image from "src/Assets/Beer-icon.png"

export default {
  data() {
    return {
     // image
    }
  }

}
</script>

<style>

</style>