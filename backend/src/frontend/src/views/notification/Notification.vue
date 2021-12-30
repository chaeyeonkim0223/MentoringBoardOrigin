<template>
    <v-card
    flat
    style="z-index: 9999"
    >
    <v-icon color="white">mdi-circle</v-icon>
    <v-icon color="white">mdi-circle</v-icon>
    <b-dropdown size="lg"  
        variant="link" 
        toggle-class="text-decoration-none" 
        no-caret right
        >
        <template #button-content>
        <v-btn
            class="ma-2"
            icon
            @click="getAlarmHistory"
        >
            <v-icon large color="blue-grey darken-2">mdi-bell</v-icon>
            <v-badge
            :content="message"
            :value="message"
            bordered color="red"
            offset-x="8" offset-y="0"
            ></v-badge>
        </v-btn>
        </template>

        <b-dropdown-text 
            v-if="this.items.length == 0"
            style="width: 400px"
            >
        </b-dropdown-text>


        <b-dropdown-text
            v-for="item in items"
            :key="item.ntcPstgNo"
            style="width: 400px"
            >
            <a 
                class="text-sm-body-2"
                @click="goBoardDetail(item.pstartNo)"
                > {{ item.ntcPstgCn }} </a>
            <v-btn 
                icon color="error"
                @click="deleteNotification(item.ntcPstgNo)"
                ><v-icon>mdi-delete</v-icon>
            </v-btn>
        </b-dropdown-text>

    </b-dropdown>
    </v-card>
</template>

<script>
import axios from 'axios';

export default {

    created() {
        this.mbrNo = 3;
        axios.get(`/api/notification/${this.mbrNo}`).then((res) => {
            this.items = res.data;
            this.message = this.items.length;
        });
    },

    methods: {
        goBoardDetail(pstartNo) {
            this.$router.push({ name: "BoardDetail", params: { pstartNo: pstartNo } });
        },
        getAlarmHistory() {
            this.mbrNo = 3;
            axios.get(`/api/notification/${this.mbrNo}`).then((res) => {
                this.items = res.data;
                this.message = this.items.length;
            });
        },
        deleteNotification(ntcPstgNo) {
            axios.delete(`/api/notification/${ntcPstgNo}`).then(() => {
                this.getAlarmHistory();
            })
        },
    },
    data() {
    return {
        mbrNo: null,
        message: null,
        items: [],
    };
  },
}

</script>
