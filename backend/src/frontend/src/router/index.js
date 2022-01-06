import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home.vue";
import auth from "../common/auth"

import Layout from "../views/Layout";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Layout",
    component: Layout,
    redirect: {
      name: "Layout",
    },
    children: [
      // 게시판
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
      // 관리자
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
      // 통계
      {
        path: "/statistics",
        name: "ChartView",
        component: () => import("../views/chart/ChartView"),
      },
      // 테스트 대시보드
      {
        path: "/dashboard",
        name: "Dashboard",
        component: () => import("../views/Dashboard"),
      }
    ],
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
  const publicPages = ['/login', '/board', '/'];
  const authRequired = !publicPages.includes(to.path)
  let accessToken = localStorage.getItem('jwt-auth-token')
  let refreshToken = localStorage.getItem('jwt-refresh-token')

  if (authRequired) {
    if (!accessToken && !refreshToken) {
      return next('/login')
    } else if (!accessToken && refreshToken && await auth.sendRefreshToken()) {
      return next('/login')
    } else if(accessToken) {
      //access token 만 식별되는 상황.
      if(await auth.sendAccessToken() || await auth.sendRefreshToken()) {
        return next('/login')
      } else {
        next();
      }
    }
  }
  next();
})

export default router;
