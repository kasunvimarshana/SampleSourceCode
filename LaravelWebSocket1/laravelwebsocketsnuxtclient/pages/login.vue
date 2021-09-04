<template>
  <form @click.prevent="login">
    <div>
      <label for="email">Email</label>
      <input type="text" name="email" id="email" v-model="form.email">
    </div>
    <div>
      <label for="password">Password</label>
      <input type="password" name="password" id="password" v-model="form.password">
    </div>

    <button type="submit">Login</button>
  </form>
</template>

<script>
export default {
  data () {
    return {
      form: {
        email: '',
        password: '',
      }
    }
  },

  methods: {
    login () {
      this.$auth.loginWith('laravelSanctum', {
        data: this.form
      })
    }
  }
}
</script>