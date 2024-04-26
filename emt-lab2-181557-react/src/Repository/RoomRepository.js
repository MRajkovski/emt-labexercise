import axios from '../custom-axios/axios';

const RoomService = {
    fetchRooms: () => {
        return axios.get("/rooms");
    },

    deleteRoom: (id) => {
        return axios.delete(`/rooms/delete/${id}`);
    },

    editRoom: (id, name, category,numberOfRooms, hostId) => {
        return axios.put(`/rooms/edit/${id}`,{
            "name": name,
            "category": category,
            "numberOfRooms":numberOfRooms,
            "hostId": hostId
        });
    },

    bookRoom: (id) => {
        return axios.post(`/rooms/book/${id}`);
    },
    addRoom: (name, category,numberOfRooms, hostId) => {
        return axios.post(`/rooms/add`,{
            "name": name,
            "category": category,
            "numberOfRooms":numberOfRooms,
            "hostId": hostId
        });
    },
    getHost: (id) => {
        return axios.get(`/hosts/${id}`);
    },
    getCountry: (id) => {
        return axios.get(`/countries/${id}`);
    },
    getCategories: () => {
        return axios.get("/rooms/categories");
    }

};

export default RoomService;
