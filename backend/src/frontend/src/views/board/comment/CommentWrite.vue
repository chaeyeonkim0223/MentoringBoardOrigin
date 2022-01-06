<template>
  <div class="regist">
    <div class="head">댓글 등록</div>
    <v-textarea v-model="content" solo></v-textarea>
    <v-row class="text-right">
      <v-spacer></v-spacer>
      <v-col class="cbtn mb-3 mr-1" cols="1">
        <button @click="regist">등록</button>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import axios from "axios";
axios.defaults.headers.post["Content-Type"] = "application/json";
export default {
  props: ["pstartNo"],
  data() {
    return {
      //댓글 등록용 content
      content: "",
      
      writerNo: null,
      title: null,
    };
  },

  methods: {
    regist() {
      if (this.content.length == 0) {
        alert("댓글 내용이 비어있어요!");
        return;
      }
      console.log(this.pstartNo);
      axios
        .post("/api/comments", {
          pstartNo: Number(this.pstartNo),
          //임의작성
          rgtrId: "chaeyeon0223",
          rgtrNm: "김채연",
          rgtrMbrCd: "MB002",
          cmntCn: this.content,
          mbrNo: 2,
        })
        .then((res) => {
          //댓글또업데이트
          console.log(res.data);
          this.$emit("getCommentInit", this.pstartNo);
          console.log("emit전달");
          this.content = "";

      });
      
      // 알림 저장
      // 작성자 mbrNo 가져오기
      axios.get(`/api/boards/${Number(this.pstartNo)}`).then((res) => {
        this.writerNo = res.data.mbrNo;
        this.title = res.data.pstartTitlNm;
      });

      this.title = "[" + this.title + "]" + "글에 댓글이 달렸습니다.";
      const notificationData = {
        mbrNo: this.writerNo,
        ntcPstgTitleNm: "알림제목",
        lgnId: "id",
        ntcPstgCn: this.title,
        pstartNo: this.pstartNo,
      };
      axios.post(`/api/notification`, notificationData).catch((error) => {
        console.log(error);
      })

    },
  },
};
</script>

<style scoped>
.regist {
  text-align: left;
  border-radius: 5px;
  background-color: #e2e2e28e;
  padding: 10px 20px;
  margin-top: 10px;
}
.head {
  font-weight: bold;
  margin-bottom: 5px;
}
.cbtn {
  color: steelblue;
}
</style>
