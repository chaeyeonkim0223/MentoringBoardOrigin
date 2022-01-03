<template>
  
  <div class="chart">
    <h4 style="text-align: left">통계</h4><br>
    <v-card 
      tile elevation="0" 
      class="d-flex justify-space-around mb-6">
      <v-card 
        tile elevation="0" 
        class="pa-2 pie">
        <strong>회원현황</strong>
        <pie-chart :data="chartData" :options="chartOptions"></pie-chart>
      </v-card>
      <v-card 
        tile elevation="0" 
        class="pa-2 pie">
        <strong>탈퇴회원현황</strong>
        <pie-chart :data="outData" :options="outOptions"></pie-chart>
      </v-card>
      <v-card 
        tile elevation="0" 
        class="pa-2 pie">
        <strong>오늘의 글</strong>
        <pie-chart :data="postData" :options="postOptions"></pie-chart>
      </v-card>
    </v-card>

    <br><br><br>

<div>
    <strong>일별 게시글 수</strong>
    
    <v-card 
      tile elevation="0"
      class="d-flex justify-center mb-6 bar">
      <bar-chart></bar-chart>
    </v-card>
    </div>
  </div>

</template>

<script>
import PieChart from "./PieChart.js";
import BarChart from './BarChart.js'

export default {
  name: "App",
  components: {
    PieChart,
    BarChart,
  },
  created() {

  },
  data() {
    return {
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
            data: [2, 10, 1]
          }
        ]
      },

      postOptions: {
        hoverBorderWidth: 20
      },
      postData: {
        hoverBackgroundColor: "white",
        hoverBorderWidth: 10,
        labels: ["질문", "답변"],
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