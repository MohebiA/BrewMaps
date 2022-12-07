import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    list(zip, radius) {
        return http.get(`/location/nearby?zip=${zip}&search_radius=${radius}`);
    },
}