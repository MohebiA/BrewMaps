<template>


  
<nav class="navbar navbar-expand-md bg-white navbar-light sticky-top">
        <div class="container-fluid">
        <a href="#" class="navbar-brand"><router-link v-bind:to="{ name: 'home'}"><b-button variant="bg-white"><h3>BrewMaps 🍺</h3></b-button></router-link></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navmenu">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navmenu">
            <ul class="navbar-nav ms-auto">
                <!-- <li class="nav-item">
                    <a class="nav-link"><router-link v-bind:to="{ name: 'brewerylist' }"><b-button variant="warning">Breweries</b-button></router-link></a>
                </li> -->
                <li class="nav-item">
                    <a class="nav-link"><span class="p-2 text-dark"><router-link v-bind:to="{ name: 'login' }"><b-button variant="warning">Login</b-button></router-link></span></a>
                    </li>
                <li class="nav-item">
                    <a class="nav-link"><span class="p-2 text-dark"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"><b-button variant="warning">Logout</b-button></router-link></span></a>
                    </li>    
                <li class="admin" >
                    <a class="nav-link"><span class="p-2 text-dark"><router-link v-bind:to="{ name: 'admin' }"><b-button variant="warning" v-show="this.$store.state.user.authorities.name = 'ROLE_ADMIN' ">Admin</b-button></router-link></span></a>
                    </li>     
            </ul>
        </div>
    </div>
    </nav>

</template>

<script>


export default {

    created: {
        

    },
    data() {
        return {
            
            
        }
    }
    

}


</script>

<style>




</style>