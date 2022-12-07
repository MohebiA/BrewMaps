<template>
    <div>
        <div class = "text-center"><h1>Brewery Name</h1></div>

        <section class="container">
        <div class="row align-items-center">
            <div class="col-md-6 order-md-1">
            <p>Lorem upsumon</p>      <!--  where brewery address goes           -->
            </div>
            <div class="col-md-6 p-4">
            <p>lorem whatever</p>        <!--  where brewery contact info goes   -->
            </div>
            <div class="col-md-6 p-4">
            <p>lorax whatever</p>        <!--  where brewery Website info goes   -->
            </div>
            <div class="col-md-6 p-4">
            <p>lorim whatever</p>        <!--  where brewery hours info goes   -->
            </div>




        </div>
    </section>

    <section>
        <div>
            <p><router-link v-bind:to="{ name: 'beerlist' }">View Beer List</router-link></p>
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