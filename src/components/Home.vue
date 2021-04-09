<template>
    <el-container>
        引入container布局
        <el-header>
            Home首页
            <el-button type="info" @click="logout">安全退出</el-button>
        </el-header>
        主体
        <el-container>
            侧边栏
            <el-aside width="200px">Aside</el-aside>
            主体内容
            <el-main>Main</el-main>
        </el-container>
    </el-container>
</template>

<script>
export default {
    methods: {
        //安全退出
        logout(){
            window.sessionStorage.clear();//清除session
            this.$router.push("/login");//回到首页
        }
    },
}
</script>

<style scoped>

</style>