<template>
  <div>
   home
  </div>
</template>

<script>
export default {
  mounted () {
    this.$echo.channel('posts')
      .listen('PostCreated', (e) => {
        console.log(e)
      })
  },

  beforeDestroy () {
    this.$echo.leave('posts')
  }
}
</script>
