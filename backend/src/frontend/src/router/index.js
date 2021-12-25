import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home.vue";

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

const isAuth = false

router.beforeEach((to, from, next) => {
  if (
    to.matched.some(function (routeInfo) {
      return routeInfo.meta.authRequired
    })
  ) {
    // 인증이 필요한 페이지일 경우 인증 체크
    if (isAuth) {
      next() // 페이지 전환
    } else {
      alert("로그인 필요")
    }
  } else {
    next() // 페이지 전환
  }
})

export default router;
