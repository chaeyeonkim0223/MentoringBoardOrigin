(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-273df44a"],{1681:function(t,e,n){},"1f3f":function(t,e,n){"use strict";n("3158")},3158:function(t,e,n){},"6f51":function(t,e,n){},a844:function(t,e,n){"use strict";var o=n("5530"),i=(n("a9e3"),n("1681"),n("8654")),a=n("58df"),s=Object(a["a"])(i["a"]);e["a"]=s.extend({name:"v-textarea",props:{autoGrow:Boolean,noResize:Boolean,rowHeight:{type:[Number,String],default:24,validator:function(t){return!isNaN(parseFloat(t))}},rows:{type:[Number,String],default:5,validator:function(t){return!isNaN(parseInt(t,10))}}},computed:{classes:function(){return Object(o["a"])({"v-textarea":!0,"v-textarea--auto-grow":this.autoGrow,"v-textarea--no-resize":this.noResizeHandle},i["a"].options.computed.classes.call(this))},noResizeHandle:function(){return this.noResize||this.autoGrow}},watch:{autoGrow:function(t){var e=this;this.$nextTick((function(){var n;t?e.calculateInputHeight():null==(n=e.$refs.input)||n.style.removeProperty("height")}))},lazyValue:function(){this.autoGrow&&this.$nextTick(this.calculateInputHeight)},rowHeight:function(){this.autoGrow&&this.$nextTick(this.calculateInputHeight)}},mounted:function(){var t=this;setTimeout((function(){t.autoGrow&&t.calculateInputHeight()}),0)},methods:{calculateInputHeight:function(){var t=this.$refs.input;if(t){t.style.height="0";var e=t.scrollHeight,n=parseInt(this.rows,10)*parseFloat(this.rowHeight);t.style.height=Math.max(n,e)+"px"}},genInput:function(){var t=i["a"].options.methods.genInput.call(this);return t.tag="textarea",delete t.data.attrs.type,t.data.attrs.rows=this.rows,t},onInput:function(t){i["a"].options.methods.onInput.call(this,t),this.autoGrow&&this.calculateInputHeight()},onKeyDown:function(t){this.isFocused&&13===t.keyCode&&t.stopPropagation(),this.$emit("keydown",t)}}})},aa3f:function(t,e,n){"use strict";n.r(e);var o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"p-3"},[n("div",{staticClass:"text"},[n("h3",[t._v(" "+t._s(t.item.pstartTitlNm)+" ")]),n("v-divider"),n("p",{staticClass:"text"},[t._v(" "+t._s(t.item.rgtrNm)+" | "+t._s(t.checkMemberCode(t.item.rgtrMbrCd))+" | 작성일 "+t._s(t.item.regDt)+" | 답변여부 : "+t._s(t.item.slctnYn)+" | 댓글 수 : "+t._s(t.item.cmntCnt)+" ")]),n("v-divider"),n("vue-editor",{staticClass:"text editor",domProps:{innerHTML:t._s(t.item.pstartCn)}}),n("v-divider")],1),n("div",{staticClass:"btn-group"},[n("v-btn",{staticClass:"m-1",attrs:{depressed:"",color:"primary"},on:{click:function(e){return t.$router.push({name:"AdminBoardView"})}}},[t._v(" 목록 ")]),t.checkMyPost(t.item.pstartNo)?n("v-btn",{staticClass:"m-1",attrs:{depressed:"",color:"error"},on:{click:function(e){return t.deleteBoard(t.item.pstartNo)}}},[t._v(" 삭제 ")]):t._e()],1),t._l(t.comments,(function(e,o){return n("div",{key:o},[n("v-divider"),n("CommentView",{attrs:{comment:e},on:{getCommentInit:t.getCommentInit}})],1)}))],2)},i=[],a=(n("a9e3"),n("bc3a")),s=n.n(a),c=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[t.isModifyShow?t._e():n("div",{staticClass:"comment"},[n("div",{staticClass:"head"},[t._v(" "+t._s(t.comment.rgtrNm)+" | "+t._s(t.checkMemberCode(t.comment.rgtrMbrCd))+" | "+t._s(t.comment.regDt)+" ")]),n("div",{staticClass:"content",domProps:{innerHTML:t._s(t.enterToBr(t.comment.cmntCn))}}),t.checkMyComment()?n("div",{staticClass:"btn-group"},[n("p",{staticClass:"p-1",on:{click:t.remove}},[t._v("삭제")])]):t._e()]),t.isModifyShow?n("div",{staticClass:"comment"},[n("div",{staticClass:"head"},[t._v(" "+t._s(t.comment.rgtrNm)+" | "+t._s(t.checkMemberCode(t.comment.rgtrMbrCd))+" | "+t._s(t.comment.regDt)+" ")]),n("v-textarea",{attrs:{solo:""},model:{value:t.comment.cmntCn,callback:function(e){t.$set(t.comment,"cmntCn",e)},expression:"comment.cmntCn"}}),t.checkMyComment()?n("div",{staticClass:"btn-group"},[n("p",{staticClass:"p-1",on:{click:t.modify}},[t._v("확인")]),n("p",{staticClass:"p-1",on:{click:t.cancle}},[t._v("취소")])]):t._e()],1):t._e()])},r=[];n("ac1f"),n("5319");s.a.defaults.headers.post["Content-Type"]="application/json";var m={props:["comment"],data:function(){return{isModifyShow:!1}},methods:{checkMemberCode:function(t){return"MB001"==t?"관리자":"MB002"==t?"멘토":"MB003"==t?"멘티":void 0},checkMyComment:function(){return!0},modify:function(){var t=this;this.isModifyShow=!0,s.a.put("/api/comments",this.comment).then((function(e){console.log(e.data),t.isModifyShow=!1}))},remove:function(){var t=this;confirm("정말로 삭제할까요?")&&(console.log(this.comment.cmntSn),s.a.delete("/api/comments/".concat(Number(this.comment.cmntSn))).then((function(){t.$emit("getCommentInit",t.comment.pstartNo)})))},cancle:function(){this.isModifyShow=!1,this.c_cmt.content=this.comment.content},enterToBr:function(t){if(t)return t.replace(/(?:\r\n|\r|\n)/g,"<br />")}}},u=m,l=(n("1f3f"),n("2877")),d=n("6544"),h=n.n(d),p=n("a844"),f=Object(l["a"])(u,c,r,!1,null,"ca42f816",null),v=f.exports;h()(f,{VTextarea:p["a"]});var g={components:{CommentView:v},data:function(){return{item:{},input:String,comments:[]}},created:function(){var t=this;s.a.get("/api/boards/".concat(this.$route.params.pstartNo)).then((function(e){t.item=e.data,t.input=e.data.pstartCn,console.log(t.item)})),s.a.get("/api/comments/".concat(this.$route.params.pstartNo)).then((function(e){t.comments=e.data,console.log(t.comments)}))},methods:{getCommentInit:function(t){var e=this;s.a.get("/api/comments/".concat(t)).then((function(t){e.comments=t.data,console.log(e.comments)}))},checkMemberCode:function(t){return"MB001"==t?"관리자":"MB002"==t?"멘토":"MB003"==t?"멘티":void 0},checkMyPost:function(){return!0},goModify:function(t){this.$router.push({name:"BoardModify",params:{pstartNo:t}})},deleteBoard:function(t){var e=this;s.a.delete("/api/boards/".concat(Number(t))).then((function(t){e.item=t.data,console.log(e.item),window.alert("삭제완료"),e.$router.push({name:"BoardView"})}))}}},C=g,w=(n("fe37"),n("8336")),_=n("ce7e"),b=Object(l["a"])(C,o,i,!1,null,"23ab6bf9",null);e["default"]=b.exports;h()(b,{VBtn:w["a"],VDivider:_["a"]})},fe37:function(t,e,n){"use strict";n("6f51")}}]);
//# sourceMappingURL=chunk-273df44a.bff63e5a.js.map