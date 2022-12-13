import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    list(zip, radius) {
        return http.get(`/brewery/find?zip=${zip}&search_radius=${radius}`);
    },

    getBreweryById(id) {
        return http.get(`/brewery/${id}`)
    },

    getBeerById(id) {
        return http.get(`/beer/${id}`)
    },

    createReview(productReview, id) {
        return http.post(`/beer/${id}/reviews`, productReview)
    },


    listBeersByBreweryId(id) {
        return http.get(`/brewery/${id}`)
    },

    addBeer(id, newBeer) {
        return http.post(`/brewery/${id}/addbeer`, newBeer)
    },

    createBrewery(brewery) {
        return http.post(`/brewery/addbrewery`, brewery)
    },

    getUsers(){
        return http.get('/users')
    },

    getBreweries(){
        return http.get('/breweries')
    },

    deleteBeer(id) {
        return http.put(`/beer/${id}`)
    },

    updateBrewery(id, brewery) {
        return http.put(`/brewery/${id}/updatebrewery`, brewery)
    },

    deleteUser(id) {
        return http.delete(`/users/${id}`)
    },

    deleteBrewery(id) {
        return http.put(`/brewery/${id}`)
    },

    updateBeer(id, beer) {
        return http.put(`/beer/${id}/updatebeer`, beer)

    }



    




}