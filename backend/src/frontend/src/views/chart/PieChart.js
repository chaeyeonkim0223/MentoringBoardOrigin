import { Pie } from "vue-chartjs";

export default {
  extends: Pie,
  props: ["data", "options"],
  mounted() {
    this.renderChart(this.data, {
      borderWidth: "10px",
      hoverBackgroundColor: "white",
      hoverBorderWidth: "10px"
    });
  }
};
