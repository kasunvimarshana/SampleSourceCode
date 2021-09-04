import Echo from 'laravel-echo'

window.Pusher = require('pusher-js')

Pusher.Runtime.createXHR = () => {
  let xhr = new XMLHttpRequest()

  xhr.withCredentials = true

  return xhr
}

export default (_, inject) => {
  const echo = new Echo({
    broadcaster: 'pusher',
    authEndpoint: 'http://localhost:8000/broadcasting/auth', // .env
    key: 'local', // .env
    wsHost: window.location.hostname,
    wsPort: 6001,
    forceTLS: false,
    disableStats: true
  })

  inject('echo', echo)
}