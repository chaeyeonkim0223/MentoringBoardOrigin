(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0d7258"],{7625:function(t,a,e){"use strict";e.r(a);var n=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"p-3"},[e("v-text-field",{attrs:{label:"글 제목",placeholder:"글 제목을 입력하세요",trim:""},model:{value:t.item.pstartTitlNm,callback:function(a){t.$set(t.item,"pstartTitlNm",a)},expression:"item.pstartTitlNm"}}),e("vue-editor",{model:{value:t.item.pstartCn,callback:function(a){t.$set(t.item,"pstartCn",a)},expression:"item.pstartCn"}}),e("v-btn",{staticClass:"mt-4",attrs:{depressed:"",color:"primary"},on:{click:function(a){return t.ModifyBoard(t.item)}}},[t._v(" 수정완료 ")])],1)},o=[],i=e("bc3a"),s=e.n(i),r=e("5873");s.a.defaults.headers.post["Content-Type"]="application/json";var c={components:{VueEditor:r["a"]},data:function(){return{item:{}}},created:function(){var t=this;s.a.get("/api/boards/".concat(this.$route.params.pstartNo)).then((function(a){t.item=a.data,console.log(t.item)}))},methods:{ModifyBoard:function(t){var a=this;s.a.put("/api/boards",t).then((function(t){console.log(t.data),a.$router.push({name:"BoardDetail",params:{pstartNo:t.data.pstartNo}})})).catch((function(t){console.log(t)}))}}},l=c,p=e("2877"),d=e("6544"),u=e.n(d),m=e("8336"),f=e("8654"),h=Object(p["a"])(l,n,o,!1,null,null,null);a["default"]=h.exports;u()(h,{VBtn:m["a"],VTextField:f["a"]})}}]);
//# sourceMappingURL=chunk-2d0d7258.fa2d420a.js.map