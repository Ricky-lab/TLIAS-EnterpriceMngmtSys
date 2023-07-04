import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/emp',
    component: () => import(/* webpackChunkName: "about" */ '../views/tlias/EmpView.vue')
  },
  {
    path: '/emp',
    name: 'emp',
    component: () => import(/* webpackChunkName: "about" */ '../views/tlias/EmpView.vue')
  },
  {
    path: '/dept',
    name: 'dept',
    component: () => import(/* webpackChunkName: "about" */ '../views/tlias/DeptView.vue')
  },

]

const router = new VueRouter({
  routes
})

export default router
