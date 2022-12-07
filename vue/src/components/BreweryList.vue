<template>
    <div>
        <div class = "heading">
        </div>

<section id="brewerylist" class="p-5 bg-dark">
        <div class="container">
            <div class="row align-items-center justify-content-between text-center text-white">
                <h4>LIST OF BREWERIES</h4>
                <div class="col-md">
                    <ul class="list-unstyled">
                        
                        <li><router-link v-bind:to="{ name: 'brewerydetails' }"><b-button variant="outline-warning">Brewery Details</b-button></router-link></li>
                        <li><a href="#">Brewery 1, CA</a></li>
                        <li><a href="#">Brewery 2, OH</a></li>
                        <li><a href="#">Brewery 3, PA</a></li>
                    </ul>

                </div>
                <div class="col-md p-5">
                    <ul class="list-unstyled">
                        <li><a href="#">Brewery 4, TX</a></li>
                        <li><a href="#">Brewery 5, TX</a></li>
                        <li><a href="#">Brewery 6, FL</a></li>
                        <li><a href="#">Brewery 7, NJ</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>














    </div>
</template>


<script>
export default {
    
      
}
</script>

<style>

</style>