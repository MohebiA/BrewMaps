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

    createReview(review) {
        return http.post(`/reviews`, review)
    },

    listBeersByBreweryId(id) {
        return http.get(`/brewery/${id}`)
    }


}