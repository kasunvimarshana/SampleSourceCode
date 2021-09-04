<template>
  <div>
    order #{{ orderId }}
  </div>
</template>

<script>
export default {
  data () {
    return {
      orderId: this.$route.params.id
    }
  },

  mounted () {
    this.$echo.private(`orders.${this.orderId}`) 
      .listen('OrderShipped', (e) => {
        console.log(e)
      })
  },

  beforeDestroy () {
    this.$echo.leave(`orders.${this.orderId}`)
  }
}
</script>