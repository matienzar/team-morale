import '@fortawesome/fontawesome-free/css/all.css'
import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'


Vue.config.productionTip = false

new Vue({
  vuetify,
  render: h => h(App),
  icons: {
      iconfont: 'fa',
  }
}).$mount('#app')
