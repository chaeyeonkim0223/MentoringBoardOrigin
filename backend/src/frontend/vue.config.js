module.exports = {
  //정적파일이 저장되는곳
  outputDir: "../main/resources/static",

  indexPath: "../static/index.html",

  devServer: {
    proxy: "http://localhost:8081",
    disableHostCheck: true,
    overlay: false,
  },

  chainWebpack: (config) => {
    const svgRule = config.module.rule("svg");
    svgRule.uses.clear();
    svgRule.use("vue-svg-loader").loader("vue-svg-loader");
  },

  transpileDependencies: ["vuetify"],
};
