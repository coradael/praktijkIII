import axios from 'axios';

import { API_BASE_URL,  ACCESS_TOKEN } from './index'

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    })
    
    if(localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN))
    }

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
    .then(response => 
        response.json().then(json => {
            if(!response.ok) {
                return Promise.reject(json);
            }
            return json;
        })
    );
};


class ApiService {

    fetchUsers() {
        return axios.get(API_BASE_URL + "/speler/");
    }

    fetchUserById(userId) {
        return axios.get(API_BASE_URL + "/speler/" + userId);
    }

    deleteUser(userId) {
        return axios.delete(API_BASE_URL + '/speler/' + userId);
    }

    addUser(user) {
        return axios.post(""+ API_BASE_URL + '/speler/', user);
    }

    editUser(user) {
        return axios.put(API_BASE_URL + '/speler/' + user.id, user);
    }


}

export function login(loginRequest) {
    return request({
        url: API_BASE_URL + "/novi/signin",
        method: 'POST',
        body: JSON.stringify(loginRequest)
    });
}

export function signup(signupRequest) {
    return request({
        url: API_BASE_URL + "/novi/signup",
        method: 'POST',
        body: JSON.stringify(signupRequest)
    });
}

export function checkUsernameAvailability(username) {
    return request({
        url: API_BASE_URL + "/user/checkUsernameAvailability?username=" + username,
        method: 'GET'
    });
}

export function checkEmailAvailability(email) {
    return request({
        url: API_BASE_URL + "/user/checkEmailAvailability?email=" + email,
        method: 'GET'
    });
}


export function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: API_BASE_URL + "/user/me",
        method: 'GET'
    });
}

export function getUserProfile(username) {
    return request({
        url: API_BASE_URL + "/users/" + username,
        method: 'GET'
    });
}



export default new ApiService();