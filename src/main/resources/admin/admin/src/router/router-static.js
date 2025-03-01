import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import chongwuxinxi from '@/views/modules/chongwuxinxi/list'
	import news from '@/views/modules/news/list'
	import zhiyuanzhejiuzhu from '@/views/modules/zhiyuanzhejiuzhu/list'
	import yonghujiuzhu from '@/views/modules/yonghujiuzhu/list'
	import forum from '@/views/modules/forum/list'
	import forumtype from '@/views/modules/forumtype/list'
	import chongwulingyang from '@/views/modules/chongwulingyang/list'
	import yonghu from '@/views/modules/yonghu/list'
	import huodongbaoming from '@/views/modules/huodongbaoming/list'
	import forumreport from '@/views/modules/forumreport/list'
	import chargerecord from '@/views/modules/chargerecord/list'
	import messages from '@/views/modules/messages/list'
	import orders from '@/views/modules/orders/list'
	import chongwuyongpinshangcheng from '@/views/modules/chongwuyongpinshangcheng/list'
	import shangpinleixing from '@/views/modules/shangpinleixing/list'
	import config from '@/views/modules/config/list'
	import jiuzhuxinxi from '@/views/modules/jiuzhuxinxi/list'
	import jiuzhuzhidao from '@/views/modules/jiuzhuzhidao/list'
	import zhiyuanhuodong from '@/views/modules/zhiyuanhuodong/list'
	import zhiyuanzhe from '@/views/modules/zhiyuanzhe/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/chongwuxinxi',
		name: '宠物信息',
		component: chongwuxinxi
	}
	,{
		path: '/news',
		name: '公告信息',
		component: news
	}
	,{
		path: '/zhiyuanzhejiuzhu',
		name: '志愿者领养',
		component: zhiyuanzhejiuzhu
	}
	,{
		path: '/yonghujiuzhu',
		name: '用户领养',
		component: yonghujiuzhu
	}
	,{
		path: '/forum',
		name: '交流论坛',
		component: forum
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/chongwulingyang',
		name: '宠物领养',
		component: chongwulingyang
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/huodongbaoming',
		name: '活动报名',
		component: huodongbaoming
	}
	,{
		path: '/forumreport',
		name: '举报记录',
		component: forumreport
	}
	,{
		path: '/chargerecord',
		name: '充值记录',
		component: chargerecord
	}
	,{
		path: '/messages',
		name: '留言反馈',
		component: messages
	}
	,{
		path: '/orders/:status',
		name: '订单管理',
		component: orders
	}
	,{
		path: '/chongwuyongpinshangcheng',
		name: '宠物用品商城',
		component: chongwuyongpinshangcheng
	}
	,{
		path: '/shangpinleixing',
		name: '商品类型',
		component: shangpinleixing
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/jiuzhuxinxi',
		name: '救助信息',
		component: jiuzhuxinxi
	}
	,{
		path: '/jiuzhuzhidao',
		name: '领养指导',
		component: jiuzhuzhidao
	}
	,{
		path: '/zhiyuanhuodong',
		name: '志愿活动',
		component: zhiyuanhuodong
	}
	,{
		path: '/zhiyuanzhe',
		name: '志愿者',
		component: zhiyuanzhe
	}
	,{
		path: '/newstype',
		name: '公告信息分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
