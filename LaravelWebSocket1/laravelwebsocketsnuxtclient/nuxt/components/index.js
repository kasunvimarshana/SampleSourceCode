export { default as AppNav } from '../../components/AppNav.vue'
export { default as Logo } from '../../components/Logo.vue'

export const LazyAppNav = import('../../components/AppNav.vue' /* webpackChunkName: "components/app-nav" */).then(c => c.default || c)
export const LazyLogo = import('../../components/Logo.vue' /* webpackChunkName: "components/logo" */).then(c => c.default || c)
