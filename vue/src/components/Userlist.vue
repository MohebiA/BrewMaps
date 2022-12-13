<template>
   <section class="container">
      <table id = "users-list">
        <thead>
          <tr>
            <th>Username</th>
            <th>User Id</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" v-bind:key="user.id" v-bind:user = "user">
            <td>{{user.username}}</td>
            <td>{{user.id}}</td>
            <td><button class = "delete" v-on:click="deleteUser(user.id)">DELETE</button></td>

          </tr>
          <p/>
        </tbody>
      </table>
    </section>
</template>

<script>
import AppServices from '../services/AppServices'

export default {

    data() {
        return {
            users: [],
        }
    },

    created() {
        AppServices.getUsers().then(response => {
          this.users = response.data;
          
        })
    },

    methods: {

    }



}
</script>



<style>

</style>