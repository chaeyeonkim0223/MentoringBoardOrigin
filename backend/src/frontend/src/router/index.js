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
        name: "BarChart",
        component: () => import("../views/chart/BarChart"),
      },
    ],
  },

  {
    path: "/chart/barchart",
    name: "BarChart",
    component: () => import("@/views/chart/BarChart"),
    //beforeEnter: checkAuth(),
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

export default router;
