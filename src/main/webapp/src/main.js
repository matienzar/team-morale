import '@fortawesome/fontawesome-free/css/all.css'
import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import VueApexCharts from 'vue-apexcharts'
import Router from 'vue-router'

import Metrics from './components/Metrics'
import Health from './components/Health'

Vue.use(VueApexCharts);
Vue.use(Router);
Vue.component('apexchart', VueApexCharts);
Vue.config.productionTip = false

const routes = [
  { path: '/', component: Health },
  { path: '/metrics', component: Metrics }
]

const router = new Router({
  routes
})

new Vue({
  vuetify,
  router,
  render: h => h(App),
  icons: {
      iconfont: 'fa',
  }
}).$mount('#app')
