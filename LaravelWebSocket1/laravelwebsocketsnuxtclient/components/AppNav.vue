<template>
  <ul>
    <li><nuxt-link :to="{ name: 'index' }">Home</nuxt-link></li>
    <template v-if="!$auth.loggedIn">
      <li><nuxt-link :to="{ name: 'login' }">Login</nuxt-link></li>
    </template>
    <template v-if="$auth.loggedIn">
      <li><nuxt-link :to="{ name: 'orders-id', params: { id: 1 } }">Order</nuxt-link></li>
      <li><a href="#">{{ $auth.user.name }}</a></li>
      <li><a href="#" @click.prevent="logout">Logout</a></li>
    </template>
  </ul>
</template>

<script>
export default {
  methods: {
    logout () {
      this.$auth.logout()
    }
  }
}
</script>