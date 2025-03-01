const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootio7q3t15/",
            name: "springbootio7q3t15",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootio7q3t15/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "宠物领养系统"
        } 
    }
}
export default base
