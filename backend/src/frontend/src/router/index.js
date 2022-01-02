import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home.vue";
import auth from "../common/auth"

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
    redirect: {
      name: "BoardView",
    },
    children: [
      {
        path: "",
        name: "BoardView",
        component: () => import("@/views/board/BoardView"),
        //beforeEnter: checkAuth(),
      },
      {
        path: "/board/:pstartNo",
        name: "BoardDetail",
        component: () => import("@/views/board/BoardDetail"),
      },
      {
        path: "/board/write",
        name: "BoardWrite",
        component: () => import("@/views/board/BoardWrite"),
      },
      {
        path: "/board/modify/:pstartNo",
        name: "BoardModify",
        component: () => import("@/views/board/BoardModify"),
      },
      {
        path: "/admin/memberList",
        name: "AdminMemberView",
        component: () => import("../views/admin/member/AdminMemberView"),
      },
      {
        path: "/admin/memberList/:mbrNo",
        name: "AdminMemberDetail",
        component: () => import("../views/admin/member/AdminMemberDetail"),
      },
      {
        path: "/admin/board",
        name:"AdminBoardView",
        component: () => import("../views/admin/board/AdminBoardView"),
      },
      {
        path: "/admin/board/:pstartNo",
        name:"AdminBoardDetail",
        component: () => import("../views/admin/board/AdminBoardDetail"),
      },
    ],
  },

  {
    path: "/chart/barchart",
    name: "BarChart",
    component: () => import("@/views/chart/BarChart"),
    //beforeEnter: checkAuth(),
  },

  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login/Login'),
    //meta: { authRequired: true },
  },

  //Editor
  // {
  //   path: "/editor",
  //   name: "Editor",
  //   component: () => import("@/components/ToastUI/Editor"),
  // },
  // {
  //   path: "/viewer",
  //   name: "ToastView",
  //   component: () => import("@/components/ToastUI/ToastView"),
  // },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach( async(to, from, next) => {
  // redirect to login page if not logged in and trying to access a restricted page
  const publicPages = ['/login'];
  const authRequired = !publicPages.includes(to.path);
  const accessToken = localStorage.getItem('jwt-auth-token');
  const refreshToken = localStorage.getItem('jwt-refresh-token');

  if (authRequired) {
    if (!accessToken && !refreshToken) {
      return next('/login');
    } else if (!accessToken && refreshToken) {
      //access token 재발급
      console.log('refresh token')
      let result = await auth.getAccessToken();
      console.log(result)
      if(!result) return next('/login');
    } else {
      //access token 만 식별되는 상황.
    }
  }
  next();
})

export default router;
