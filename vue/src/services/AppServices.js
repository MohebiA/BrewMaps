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

    addBeer(id) {
        return http.post(`/brewery/${id}/addbeer`)
    },

    createBrewery(brewery) {
        return http.post(`/brewery/addbrewery`, brewery)
    },

    getUsers(){
        return http.get('/users')
    },

    getBreweries(){
        return http.get('/brewery')
    }



    




}