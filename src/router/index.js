import Vue from 'vue'
import VueRouter from 'vue-router'
//引入login组件
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
//import { from } from 'core-js/core/array'

Vue.use(VueRouter)

const routes = [
  {
    path:"/",
    redirect:"/login"
  },
  {
    path:"/login",
    component: Login
  },
  {
    path:"/home",
    component: Home
  }
]

const router = new VueRouter({
  routes
})

//挂载路由导航守卫
router.beforeEach((to,from,next)=>{
  //to将要访问
  //from从哪儿访问
  //next接着干的事儿 next(url)访问指定url，next()无参则继续访问to路径
  if(to.path=='/login') return next();
  //获取user
  const userFlag = window.sessionStorage.getItem("user");
  if(!userFlag) return next('/login'); //空值返回登陆页面
  next();//符合要求，放行
})


export default router
