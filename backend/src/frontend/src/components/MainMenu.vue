<template>
  <div>
    <div id="nav">
      <router-link to="/chart/barchart">BarChart</router-link> |
      <router-link to="/board">게시판</router-link> |
      <router-link to="/editor">에디터</router-link> |
    </div>
  </div>
</template>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
