<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="宠物名称" prop="chongwumingcheng">
				<el-input v-model="ruleForm.chongwumingcheng" 
					placeholder="宠物名称" clearable :disabled=" false  ||ro.chongwumingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="宠物品种" prop="chongwupinzhong">
				<el-input v-model="ruleForm.chongwupinzhong" 
					placeholder="宠物品种" clearable :disabled=" false  ||ro.chongwupinzhong"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="年龄" prop="nianling">
				<el-input v-model="ruleForm.nianling" 
					placeholder="年龄" clearable :disabled=" false  ||ro.nianling"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="性别" prop="xingbie">
				<el-input v-model="ruleForm.xingbie" 
					placeholder="性别" clearable :disabled=" false  ||ro.xingbie"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="体重" prop="tizhong">
				<el-input v-model="ruleForm.tizhong" 
					placeholder="体重" clearable :disabled=" false  ||ro.tizhong"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="毛色" prop="maose">
				<el-input v-model="ruleForm.maose" 
					placeholder="毛色" clearable :disabled=" false  ||ro.maose"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="疫苗记录" prop="yimiaojilu">
				<el-input v-model="ruleForm.yimiaojilu" 
					placeholder="疫苗记录" clearable :disabled=" false  ||ro.yimiaojilu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="健康状况" prop="jiankangzhuangkuang">
				<el-input v-model="ruleForm.jiankangzhuangkuang" 
					placeholder="健康状况" clearable :disabled=" false  ||ro.jiankangzhuangkuang"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="饮食习惯" prop="yinshixiguan">
				<el-input v-model="ruleForm.yinshixiguan" 
					placeholder="饮食习惯" clearable :disabled=" false  ||ro.yinshixiguan"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="特殊营养需求" prop="teshuyingyangxuqiu">
				<el-input v-model="ruleForm.teshuyingyangxuqiu" 
					placeholder="特殊营养需求" clearable :disabled=" false  ||ro.teshuyingyangxuqiu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="宠物图片" v-if="type!='cross' || (type=='cross' && !ro.chongwutupian)" prop="chongwutupian">
				<file-upload
					tip="点击上传宠物图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.chongwutupian?ruleForm.chongwutupian:''"
					@change="chongwutupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="宠物图片" prop="chongwutupian">
				<img v-if="ruleForm.chongwutupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.chongwutupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.chongwutupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="申请时间" prop="shenqingshijian">
				<el-date-picker
					:disabled=" false  ||ro.shenqingshijian"
					value-format="yyyy-MM-dd HH:mm:ss"
					v-model="ruleForm.shenqingshijian" 
					type="datetime"
					placeholder="申请时间">
				</el-date-picker>
			</el-form-item>

			<el-form-item class="add-item" label="领养申请" prop="lingyangshenqing">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="领养申请"
					v-model="ruleForm.lingyangshenqing">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont icon-kaitongfuwu"></span>
					<span class="text">提交</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont icon-shanchu1"></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					chongwumingcheng : false,
					chongwupinzhong : false,
					nianling : false,
					xingbie : false,
					tizhong : false,
					maose : false,
					yimiaojilu : false,
					jiankangzhuangkuang : false,
					yinshixiguan : false,
					teshuyingyangxuqiu : false,
					chongwutupian : false,
					lingyangshenqing : false,
					shenqingshijian : false,
					zhiyuanzhezhanghao : false,
					zhiyuanzhexingming : false,
          yonghuzhanghao : false,
          xingming : false,
					sfsh : false,
					shhf : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					chongwumingcheng: '',
					chongwupinzhong: '',
					nianling: '',
					xingbie: '',
					tizhong: '',
					maose: '',
					yimiaojilu: '',
					jiankangzhuangkuang: '',
					yinshixiguan: '',
					teshuyingyangxuqiu: '',
					chongwutupian: '',
					lingyangshenqing: '',
					shenqingshijian: '',
					zhiyuanzhezhanghao: '',
					zhiyuanzhexingming: '',
          yonghuzhanghao: '',
          xingming: '',
				},


				rules: {
					chongwumingcheng: [
					],
					chongwupinzhong: [
					],
					nianling: [
					],
					xingbie: [
					],
					tizhong: [
					],
					maose: [
					],
					yimiaojilu: [
					],
					jiankangzhuangkuang: [
					],
					yinshixiguan: [
					],
					teshuyingyangxuqiu: [
					],
					chongwutupian: [
					],
					lingyangshenqing: [
					],
					shenqingshijian: [
					],
					zhiyuanzhezhanghao: [
					],
					zhiyuanzhexingming: [
					],
          yonghuzhanghao: [
          ],
          xingming: [
          ],
					sfsh: [
					],
					shhf: [
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.shenqingshijian = this.getCurDateTime()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='chongwumingcheng'){
							this.ruleForm.chongwumingcheng = obj[o];
							this.ro.chongwumingcheng = true;
							continue;
						}
						if(o=='chongwupinzhong'){
							this.ruleForm.chongwupinzhong = obj[o];
							this.ro.chongwupinzhong = true;
							continue;
						}
						if(o=='nianling'){
							this.ruleForm.nianling = obj[o];
							this.ro.nianling = true;
							continue;
						}
						if(o=='xingbie'){
							this.ruleForm.xingbie = obj[o];
							this.ro.xingbie = true;
							continue;
						}
						if(o=='tizhong'){
							this.ruleForm.tizhong = obj[o];
							this.ro.tizhong = true;
							continue;
						}
						if(o=='maose'){
							this.ruleForm.maose = obj[o];
							this.ro.maose = true;
							continue;
						}
						if(o=='yimiaojilu'){
							this.ruleForm.yimiaojilu = obj[o];
							this.ro.yimiaojilu = true;
							continue;
						}
						if(o=='jiankangzhuangkuang'){
							this.ruleForm.jiankangzhuangkuang = obj[o];
							this.ro.jiankangzhuangkuang = true;
							continue;
						}
						if(o=='yinshixiguan'){
							this.ruleForm.yinshixiguan = obj[o];
							this.ro.yinshixiguan = true;
							continue;
						}
						if(o=='teshuyingyangxuqiu'){
							this.ruleForm.teshuyingyangxuqiu = obj[o];
							this.ro.teshuyingyangxuqiu = true;
							continue;
						}
						if(o=='chongwutupian'){
							this.ruleForm.chongwutupian = obj[o].split(",")[0];
							this.ro.chongwutupian = true;
							continue;
						}
						if(o=='lingyangshenqing'){
							this.ruleForm.lingyangshenqing = obj[o];
							this.ro.lingyangshenqing = true;
							continue;
						}
						if(o=='shenqingshijian'){
							this.ruleForm.shenqingshijian = obj[o];
							this.ro.shenqingshijian = true;
							continue;
						}


					}
				}else if(type=='edit'){
					this.info()
				}
        // 获取用户信息1
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`chongwulingyang/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`chongwulingyang/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			chongwutupianUploadChange(fileUrls) {
				this.ruleForm.chongwutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: #fff;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			margin: 20px 0 0;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				border: 2px inset #f7db6150;
				padding: 10px;
				margin: 0 0 10px;
				background: #f7db6110;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				/deep/ .el-upload--picture-card {
					background: transparent;
					border: 0;
					border-radius: 0;
					width: auto;
					height: auto;
					line-height: initial;
					vertical-align: middle;
				}
				/deep/ .upload .upload-img {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #f7db61;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
					background: #f7db6199;
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 0px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
					background: #eee;
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				.submitBtn {
					border: 0;
					cursor: pointer;
					padding: 0 15px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 2px;
					background: #f7db61;
					width: auto;
					text-align: center;
					min-width: 110px;
					height: 40px;
					.icon {
						color: #333;
					}
					.text {
						color: #333;
					}
				}
				.submitBtn:hover {
					opacity: 0.8;
					.icon {
						color: #000;
					}
					.text {
						color: #000;
					}
				}
				.closeBtn {
					border: 1px solid #ddd;
					cursor: pointer;
					padding: 0 15px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 2px;
					background: #fff;
					width: auto;
					text-align: center;
					min-width: 110px;
					height: 40px;
					.icon {
						color: #666;
					}
					.text {
						color: #666;
					}
				}
				.closeBtn:hover {
					background: #f7db61;
					border-color: #f7db61;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
