<template>
    <div id="gradient">
        <div id = "image">
            <b-card>
                <b-img :src="require('../Assets/breweries.jpg')"></b-img>

            <b-card-text>
                <h1>Our Mission</h1>
                <p>
                    Here at BrewMaps inc, our goal is to get you a cold brew by any means necessary.
                </p>

                <h2>Our History</h2>

                <p>
                    During the Great Storm of 1781, John BrewMaps lost a barrel of his beloved whiskey. He said goodbye to the crew, and went in after. In hindsight, that probably wasn't a good idea. Although his life was lost to the sea, his whiskey was not, and now we seek to carry on his legacy by helping others reach their preferred beverage with all the excitement of John BrewMaps original journey but without the peril.
                </p>

            </b-card-text>
            
            </b-card>
        </div>





    </div>
</template>

<script>
export default {
    setup() {
        
    },
}
</script>

<style>

#image {
    display: flex;
    flex-direction: row;
    padding: 12px 0;
    margin: 0 auto;
    width: 98%;
    justify-content:space-evenly;
    list-style-type: none;
}
</style>