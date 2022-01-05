<template>
  <v-dialog transition="dialog-top-transition" max-width="600">
    <template v-slot:activator="{ on, attrs }">
      <v-btn
        v-bind="attrs"
        v-on="on"
        class="m-1"
        depressed
        color="error"
        @click="showAlert()"
        >{{ alertContent.btnMsg }}</v-btn
      >
    </template>
    <template v-slot:default="dialog">
      <v-card>
        <v-toolbar color="primary" dark>{{ alertContent.title }}</v-toolbar>
        <v-card-text>
          <div class="text-h6 pa-12">{{ alertContent.content }}</div>
        </v-card-text>
        <v-card-actions class="justify-end">
          <v-btn text @click="dialog.value = false">{{
            alertContent.cancelMsg
          }}</v-btn>
          <v-btn text @click="deleteBoard">{{ alertContent.acceptMsg }}</v-btn>
        </v-card-actions>
      </v-card>
    </template>
  </v-dialog>
</template>

<script>
export default {
  props: {
    alertContent: Object,
  },
  data() {
    return {
      dialog: false,
    };
  },
  methods: {
    deleteBoard() {
      this.dialog = false;
      this.$emit("deleteBoard");
    },
    showAlert() {
      this.dialog = true;
    },
  },
};
</script>
