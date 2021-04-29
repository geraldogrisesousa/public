import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/pages/home/Home.vue';
import GrupoEtapa from '@/pages/grupo-etapa/GrupoEtapa.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home,
    },
    {
      path: '/grupo-etapa',
      name: 'grupo-etapa',
      component: GrupoEtapa,
    },
  ],
});
