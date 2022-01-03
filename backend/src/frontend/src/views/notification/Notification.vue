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
            <v-icon color="blue-grey darken-2">mdi-bell-outline</v-icon>
            <v-badge
            :content="message"
            :value="message"
            bordered color="red"
            offset-x="6" offset-y="0"
            ></v-badge>
        </v-btn>
        </template>

        <b-dropdown-header
            v-if="this.items.length == 0"
            style="width: 400px"
            >
            알림이 없습니다.
        </b-dropdown-header>

        
        <div class="type2" style="overflow-y: auto; height: 200px;">
        <b-dropdown-text
            v-for="item in items"
            :key="item.ntcPstgNo"
            class="dropdownText"
            style="width: 450px"
            >
            <a 
                class="noti"
                @click="goBoardDetail(item)"
                > {{ item.ntcPstgCn }} </a>
        </b-dropdown-text>
        </div>

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
        goBoardDetail(item) {
            this.$router.push({ name: "BoardDetail", params: { pstartNo: item.pstartNo } });
            this.deleteNotification(item.ntcPstgNo);
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
        benched: 0,
        mbrNo: null,
        message: null,
        items: [],
    };
  },
}

</script>

<style>
.box {
    -ms-overflow-style: none; 
} 

.box::-webkit-scrollbar {
    display:none; 
}

.b-dropdown-text {
    padding: 0px 0px 0px 0px !important;
}



/* 스크롤바 설정*/
.type2::-webkit-scrollbar{
    width: 6px;
}

/* 스크롤바 막대 설정*/
.type2::-webkit-scrollbar-thumb{
    height: 17%;
    background-color: rgb(219, 219, 219);
    border-radius: 10px;  
}

/* 스크롤바 뒷 배경 설정*/
.type2::-webkit-scrollbar-track{
    background-color: rgb(255, 255, 255);
}

.noti {
  font-size: small;
  font-family: 'GowunDodum-Regular', Avenir, Helvetica, Arial, sans-serif;
}

@font-face {
    font-family: 'GowunDodum-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/GowunDodum-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

</style>