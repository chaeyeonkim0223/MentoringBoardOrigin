<template>
  
  <div class="chart">
    <div style="text-align: left">
    <h4>통계</h4><br>
    </div>

    <v-card 
      tile elevation="0" 
      class="d-flex justify-space-around mb-6">
      <v-card 
        tile elevation="0" 
        class="pa-2 pie">
        <strong>오늘의 회원현황</strong><br>
        <small v-if="this.memberMessage.length != 0">{{ this.memberMessage }}</small>
        <pie-chart v-if="mbrLoaded" :data="chartData" :options="chartOptions"></pie-chart>
        <small v-if="this.totalMember != 0">회원수: {{ totalMember }}</small>
      </v-card>
      <v-card 
        tile elevation="0" 
        class="pa-2 pie">
        <strong>탈퇴회원현황</strong><br>
        <small v-if="this.outMessage.length != 0">{{ this.outMessage }}</small>
        <pie-chart v-if="outMbrLoaded" :data="outData" :options="outOptions"></pie-chart>
        <small v-if="this.totalOutMember != 0">탈퇴회원수: {{ totalOutMember }}</small>
      </v-card>
      <v-card 
        tile elevation="0" 
        class="pa-2 pie">
        <strong>오늘의 답변현황</strong><br>
        <small v-if="this.postMessage.length != 0">{{ this.postMessage }}</small>
        <pie-chart v-if="postLoaded" :data="postData" :options="postOptions"></pie-chart>
      </v-card>
    </v-card>

    <br><br><br>

<div>
    <strong>일별 게시글 수</strong>
    
    <v-card 
      tile elevation="0"
      class="d-flex justify-center mb-6 bar">
      <bar-chart v-if="weekPostLoaded" :data="barData" :options="barOptions"></bar-chart>
      <small v-if="this.isEmptyBoardCount">{{ boardCountMessage }}</small>
    </v-card>
    </div>
  </div>

</template>

<script>
import PieChart from "./PieChart.js";
import BarChart from './BarChart.js';
import axios from 'axios';

export default {
  name: "App",
  components: {
    PieChart,
    BarChart,
  },

  methods: {
    isEmptyValue(val) {
      return val == "" || val == null || val == undefined || (val != null && typeof val == "object" && !Object.keys(val).length);
    },
    getMembersStatus() {
      this.mbrLoaded = false;
      axios.get(`api/chartData/members`).then((item) => {
        this.today = item.data.totYmd;
        this.memberMessage = "";
        this.totalMember = item.data.totMbrNum;

        this.chartData.datasets[0].data = [item.data.totMtrNum, item.data.totMteNum, item.data.totWhdwlMbrNum];
        this.mbrLoaded = true;
        if (this.isEmptyValue(item.data)) {
          this.memberMessage = "회원이 없습니다";
          this.chartData.labels = [];
          this.totalMember = 0;
        }
        if (item.data.totMtrNum === 0 && item.data.totMteNum === 0 && item.data.totWhdwlMbrNum === 0) {
          this.memberMessage = "회원이 없습니다";
          this.chartData.labels = [];
          this.totalMember = 0;
        }
      }); 
    },
    getOutMembersStatus() {
      this.outMbrLoaded = false;
      axios.get(`api/chartData/outMembers`).then((item) => {
        this.outMessage = "";
        this.totalOutMember = item.data.totMtrWhdwlNum + item.data.totMteWhdwlNum;

        this.outData.datasets[0].data = [item.data.totMtrWhdwlNum, item.data.totMteWhdwlNum];
        this.outMbrLoaded = true;

        if (this.isEmptyValue(item.data)) {
          this.outMessage = "탈퇴한 회원이 없습니다";
          this.outData.labels = [];
          this.totalOutMember = 0;
        }
        if (item.data.totMtrWhdwlNum === 0 && item.data.totMteWhdwlNum === 0) {
          this.outMessage = "탈퇴한 회원이 없습니다.";
          this.outData.labels = [];
          this.totalOutMember = 0;
        }
      });
    },
    getBoardStatus() {
      this.postLoaded = false;
      axios.get(`api/chartData/boardStatus`).then((item) => {
        this.postMessage = "";
        this.postData.datasets[0].data = [item.data.totAnsCmptnPstartNum, item.data.totAnsYetCmptnPstartNum];
        this.postLoaded = true;
        if (this.isEmptyValue(item.data)) {
          this.postMessage = "오늘 작성된 글이 없습니다.";
          this.postData.labels = [];
        }
        if (item.data.totAnsCmptnPstartNum === 0 && item.data.totAnsYetCmptnPstartNum === 0) {
          this.postMessage = "오늘 작성된 글이 없습니다."
          this.postData.labels = [];
        }
      });
    },
    getBoardCount() {
      this.weekPostLoaded = false;
      axios.get(`api/chartData/boardCount`).then((res) => {
        const boardCount = res.data;
        const cnt = boardCount.length < 7 ? boardCount.length : 7;
        
        if (this.isEmptyValue(boardCount)) {
          this.barData.labels = [];
          this.barData.datasets[0].data = [];
          this.isEmptyBoardCount = true;
          this.boardCountMessage = "게시글이 존재하지 않습니다."
          return;
        }

        this.barData.labels = [];
        this.barData.datasets[0].data = [];
        for (let i = 0; i < 7 - cnt; i++) {
          this.barData.labels.push('.');
          this.barData.datasets[0].data.push(0);
        }
        for (let i = 0; i < cnt; i++) {
          this.barData.labels.push(boardCount[i].totYmd);
          this.barData.datasets[0].data.push(boardCount[i].totPstartNum);
        }
        this.isEmptyBoardCount = false;
        this.weekPostLoaded = true;
      });
    },
  },

  created() {
    this.getMembersStatus();
    this.getOutMembersStatus();
    this.getBoardStatus();
    this.getBoardCount();
  },
  data() {
    return {
      today: "",
      totalMember: 0,
      totalOutMember: 0,
      memberMessage: "",
      outMessage: "",
      postMessage: "",
      boardCountMessage: "",
      mbrLoaded: false,
      outMbrLoaded: false,
      postLoaded: false,
      weekPostLoaded: false,
      isEmptyBoardCount: false,
      cnt: null,
      chartOptions: {
        hoverBorderWidth: 20
      },
      chartData: {
        hoverBackgroundColor: "white",
        hoverBorderWidth: 10,
        labels: ["멘토", "멘티", "탈퇴"],
        datasets: [
          {
            label: "Data One",
            backgroundColor: ["#FAE3D9", "#8AC6D1", "#FFB6B9"],
            data: [1, 1, 1],
          }
        ]
      },

      postOptions: {
        hoverBorderWidth: 20
      },
      postData: {
        hoverBackgroundColor: "white",
        hoverBorderWidth: 10,
        labels: ["답변", "미답변"],
        datasets: [
          {
            label: "Data One",
            backgroundColor: ["#FAE3D9", "#8AC6D1"],
            data: [2, 10]
          }
        ]
      },
      
      outOptions: {
        hoverBorderWidth: 20
      },
      outData: {
        hoverBackgroundColor: "white",
        hoverBorderWidth: 10,
        labels: ["멘토", "멘티"],
        datasets: [
          {
            label: "Data One",
            backgroundColor: ["#FAE3D9", "#8AC6D1"],
            data: [3, 19]
          }
        ]
      },
      
      barData: {
        labels: ["12.28", "12.29", "12.30", "12.31", "1.1", "1.2", "1.3",
        ],
        datasets: [{
          label: '게시글 수',
          borderWidth: 0,
          backgroundColor: [
            '#B0C6D9', '#DED5CE', '#5C9899',
            '#0D6973', '#C4534D', '#DB857D', '#6D9BA6'
          ],
          pointBorderColor: '#2554FF',
          data: [12, 19, 3, 5, 2, 3, 20, 3, 5, 6, 2, 1]
        }]
      },
      barOptions: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            },
            gridLines: {
              display: true
            }
          }],
          xAxes: [{
            gridLines: {
              display: false
            }
          }]
        },
        legend: {
          display: false,
        },
        responsive: true,
        maintainAspectRatio: false
      }
    };
  }

  
};
</script>

<style>

.pie {
  width: 270px;
  height: 270px;
}

</style>