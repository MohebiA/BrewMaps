<template>
    <div>
<div>
            <h1>HEADING</h1>

</div>



<section id="brewerylist" class="p-5 bg-light">
        <div class="container">
            <div class="row align-items-center justify-content-between text-center">
                <h4>List of Beers</h4>
                <div class="col-md">
                    <ul class="list-unstyled">
                        
                        <li><router-link v-bind:to="{ name: 'beerdetails' }">BeerDetails</router-link></li>
                        <li><a href="#">Beer 1, CA</a></li>
                        <li><a href="#">Beer 2, OH</a></li>
                        <li><a href="#">Beer 3, PA</a></li>
                    </ul>

                </div>
                <div class="col-md p-5">
                    <ul class="list-unstyled">
                        <li><a href="#">Beer 4, TX</a></li>
                        <li><a href="#">Beer 5, TX</a></li>
                        <li><a href="#">Beer 6, FL</a></li>
                        <li><a href="#">Beer 7, NJ</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>



    </div>
</template>


<script>
export default {
    setup() {
        
    },
}
</script>



<style>

</style>