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
      // {
      //   path: "/test",
      //   name: "Test",
      //   component: () => import("@/views/board/Test"),
      // },
      {
        path: "/admin/memberList",
        name: "AdminMemberView",
        component: () => import("../views/admin/AdminMemberView"),
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
