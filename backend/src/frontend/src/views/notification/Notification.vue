<template>
    <v-card
    flat
    style="z-index: 9999"
    >
    <v-icon color="white">mdi-circle</v-icon>
    <v-icon color="white">mdi-circle</v-icon>
    <b-dropdown size="lg"  variant="link" toggle-class="text-decoration-none" no-caret right>
        <template #button-content>
        <v-btn
            class="ma-2"
            icon
            @click="expand = !expand"
        >
            <v-icon large color="indigo lighten-2">mdi-bell</v-icon>
            <v-badge
            :content="message"
            :value="message"
            bordered color="red"
            offset-x="8" offset-y="0"
            ></v-badge>
        </v-btn>
        </template>

        <b-dropdown-header>알림내역</b-dropdown-header>
        <v-divider></v-divider>
        <v-simple-table 
            v-if="this.items.size != 0"
            style="width: 300px"
            >
            <template v-slot: default>
                <tbody style="width: 300px">
                    <tr
                        v-for="item in items"
                        :key="item.no">
                        <td>{{ item.contents }}</td>
                    </tr>
                </tbody>
            </template>
        </v-simple-table>
    </b-dropdown>
    </v-card>
</template>

<script>

export default {
    data() {
    return {
      items: [
            {
                no: 1, 
                title: '알림제목입니다.',
                contents: '알림내용입니다. 알림내용입니다. 알림내용입니다. 알림내용입니다. 알림내용입니다. 알림내용입니다. 알림내용입니다. 알림내용입니다.',
            },
            {
                no: 2,
                title: '알림제목입니다.',
                contents: '알림내용입니다. 알림내용입니다.',
            },
            {
                no: 3,
                title: '알림제목입니다.',
                contents: '알림내용입니다. 알림내용입니다.',
            },
            {
                no: 4,
                title: '알림제목입니다.',
                contents: '알림내용입니다. 알림내용입니다.',
            },
        ],
    };
  },
}

</script>
