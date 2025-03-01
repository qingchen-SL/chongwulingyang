import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import zhiyuanzheList from '../pages/zhiyuanzhe/list'
import zhiyuanzheDetail from '../pages/zhiyuanzhe/detail'
import zhiyuanzheAdd from '../pages/zhiyuanzhe/add'
import shangpinleixingList from '../pages/shangpinleixing/list'
import shangpinleixingDetail from '../pages/shangpinleixing/detail'
import shangpinleixingAdd from '../pages/shangpinleixing/add'
import jiuzhuxinxiList from '../pages/jiuzhuxinxi/list'
import jiuzhuxinxiDetail from '../pages/jiuzhuxinxi/detail'
import jiuzhuxinxiAdd from '../pages/jiuzhuxinxi/add'
import zhiyuanzhejiuzhuList from '../pages/zhiyuanzhejiuzhu/list'
import zhiyuanzhejiuzhuDetail from '../pages/zhiyuanzhejiuzhu/detail'
import zhiyuanzhejiuzhuAdd from '../pages/zhiyuanzhejiuzhu/add'
import jiuzhuzhidaoList from '../pages/jiuzhuzhidao/list'
import jiuzhuzhidaoDetail from '../pages/jiuzhuzhidao/detail'
import jiuzhuzhidaoAdd from '../pages/jiuzhuzhidao/add'
import yonghujiuzhuList from '../pages/yonghujiuzhu/list'
import yonghujiuzhuDetail from '../pages/yonghujiuzhu/detail'
import yonghujiuzhuAdd from '../pages/yonghujiuzhu/add'
import chongwuyongpinshangchengList from '../pages/chongwuyongpinshangcheng/list'
import chongwuyongpinshangchengDetail from '../pages/chongwuyongpinshangcheng/detail'
import chongwuyongpinshangchengAdd from '../pages/chongwuyongpinshangcheng/add'
import zhiyuanhuodongList from '../pages/zhiyuanhuodong/list'
import zhiyuanhuodongDetail from '../pages/zhiyuanhuodong/detail'
import zhiyuanhuodongAdd from '../pages/zhiyuanhuodong/add'
import huodongbaomingList from '../pages/huodongbaoming/list'
import huodongbaomingDetail from '../pages/huodongbaoming/detail'
import huodongbaomingAdd from '../pages/huodongbaoming/add'
import chongwuxinxiList from '../pages/chongwuxinxi/list'
import chongwuxinxiDetail from '../pages/chongwuxinxi/detail'
import chongwuxinxiAdd from '../pages/chongwuxinxi/add'
import chongwulingyangList from '../pages/chongwulingyang/list'
import chongwulingyangDetail from '../pages/chongwulingyang/detail'
import chongwulingyangAdd from '../pages/chongwulingyang/add'
import forumtypeList from '../pages/forumtype/list'
import forumtypeDetail from '../pages/forumtype/detail'
import forumtypeAdd from '../pages/forumtype/add'
import forumreportList from '../pages/forumreport/list'
import forumreportDetail from '../pages/forumreport/detail'
import forumreportAdd from '../pages/forumreport/add'
import chargerecordList from '../pages/chargerecord/list'
import chargerecordDetail from '../pages/chargerecord/detail'
import chargerecordAdd from '../pages/chargerecord/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'zhiyuanzhe',
					component: zhiyuanzheList
				},
				{
					path: 'zhiyuanzheDetail',
					component: zhiyuanzheDetail
				},
				{
					path: 'zhiyuanzheAdd',
					component: zhiyuanzheAdd
				},
				{
					path: 'shangpinleixing',
					component: shangpinleixingList
				},
				{
					path: 'shangpinleixingDetail',
					component: shangpinleixingDetail
				},
				{
					path: 'shangpinleixingAdd',
					component: shangpinleixingAdd
				},
				{
					path: 'jiuzhuxinxi',
					component: jiuzhuxinxiList
				},
				{
					path: 'jiuzhuxinxiDetail',
					component: jiuzhuxinxiDetail
				},
				{
					path: 'jiuzhuxinxiAdd',
					component: jiuzhuxinxiAdd
				},
				{
					path: 'zhiyuanzhejiuzhu',
					component: zhiyuanzhejiuzhuList
				},
				{
					path: 'zhiyuanzhejiuzhuDetail',
					component: zhiyuanzhejiuzhuDetail
				},
				{
					path: 'zhiyuanzhejiuzhuAdd',
					component: zhiyuanzhejiuzhuAdd
				},
				{
					path: 'jiuzhuzhidao',
					component: jiuzhuzhidaoList
				},
				{
					path: 'jiuzhuzhidaoDetail',
					component: jiuzhuzhidaoDetail
				},
				{
					path: 'jiuzhuzhidaoAdd',
					component: jiuzhuzhidaoAdd
				},
				{
					path: 'yonghujiuzhu',
					component: yonghujiuzhuList
				},
				{
					path: 'yonghujiuzhuDetail',
					component: yonghujiuzhuDetail
				},
				{
					path: 'yonghujiuzhuAdd',
					component: yonghujiuzhuAdd
				},
				{
					path: 'chongwuyongpinshangcheng',
					component: chongwuyongpinshangchengList
				},
				{
					path: 'chongwuyongpinshangchengDetail',
					component: chongwuyongpinshangchengDetail
				},
				{
					path: 'chongwuyongpinshangchengAdd',
					component: chongwuyongpinshangchengAdd
				},
				{
					path: 'zhiyuanhuodong',
					component: zhiyuanhuodongList
				},
				{
					path: 'zhiyuanhuodongDetail',
					component: zhiyuanhuodongDetail
				},
				{
					path: 'zhiyuanhuodongAdd',
					component: zhiyuanhuodongAdd
				},
				{
					path: 'huodongbaoming',
					component: huodongbaomingList
				},
				{
					path: 'huodongbaomingDetail',
					component: huodongbaomingDetail
				},
				{
					path: 'huodongbaomingAdd',
					component: huodongbaomingAdd
				},
				{
					path: 'chongwuxinxi',
					component: chongwuxinxiList
				},
				{
					path: 'chongwuxinxiDetail',
					component: chongwuxinxiDetail
				},
				{
					path: 'chongwuxinxiAdd',
					component: chongwuxinxiAdd
				},
				{
					path: 'chongwulingyang',
					component: chongwulingyangList
				},
				{
					path: 'chongwulingyangDetail',
					component: chongwulingyangDetail
				},
				{
					path: 'chongwulingyangAdd',
					component: chongwulingyangAdd
				},
				{
					path: 'forumtype',
					component: forumtypeList
				},
				{
					path: 'forumtypeDetail',
					component: forumtypeDetail
				},
				{
					path: 'forumtypeAdd',
					component: forumtypeAdd
				},
				{
					path: 'forumreport',
					component: forumreportList
				},
				{
					path: 'forumreportDetail',
					component: forumreportDetail
				},
				{
					path: 'forumreportAdd',
					component: forumreportAdd
				},
				{
					path: 'chargerecord',
					component: chargerecordList
				},
				{
					path: 'chargerecordDetail',
					component: chargerecordDetail
				},
				{
					path: 'chargerecordAdd',
					component: chargerecordAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
