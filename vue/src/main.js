import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css'
import locale from 'element-ui/lib/locale/lang/en'
import request from "./utils/request";

Vue.config.productionTip = false
Vue.use(ElementUI, {locale});
Vue.prototype.request = request
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
