package com.entity.vo;

import com.entity.YonghujiuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 用户领养
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public class YonghujiuzhuVO  implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 宠物名称
	 */

	private String chongwumingcheng;

	/**
	 * 宠物品种
	 */

	private String chongwupinzhong;

	/**
	 * 年龄
	 */

	private String nianling;

	/**
	 * 性别
	 */

	private String xingbie;

	/**
	 * 体重
	 */

	private String tizhong;

	/**
	 * 毛色
	 */

	private String maose;

	/**
	 * 疫苗记录
	 */

	private String yimiaojilu;

	/**
	 * 健康状况
	 */

	private String jiankangzhuangkuang;

	/**
	 * 饮食习惯
	 */

	private String yinshixiguan;

	/**
	 * 特殊营养需求
	 */

	private String teshuyingyangxuqiu;

	/**
	 * 宠物图片
	 */

	private String chongwutupian;

	/**
	 * 领养申请
	 */

	private String lingyangshenqing;

	/**
	 * 领养时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date shenqingshijian;

	/**
	 * 设置：宠物名称
	 */
	public void setChongwumingcheng(String chongwumingcheng) {
		this.chongwumingcheng = chongwumingcheng;
	}
	/**
	 * 获取：宠物名称
	 */
	public String getChongwumingcheng() {
		return chongwumingcheng;
	}
	/**
	 * 设置：宠物品种
	 */
	public void setChongwupinzhong(String chongwupinzhong) {
		this.chongwupinzhong = chongwupinzhong;
	}
	/**
	 * 获取：宠物品种
	 */
	public String getChongwupinzhong() {
		return chongwupinzhong;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：体重
	 */
	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}
	/**
	 * 获取：体重
	 */
	public String getTizhong() {
		return tizhong;
	}
	/**
	 * 设置：毛色
	 */
	public void setMaose(String maose) {
		this.maose = maose;
	}
	/**
	 * 获取：毛色
	 */
	public String getMaose() {
		return maose;
	}
	/**
	 * 设置：疫苗记录
	 */
	public void setYimiaojilu(String yimiaojilu) {
		this.yimiaojilu = yimiaojilu;
	}
	/**
	 * 获取：疫苗记录
	 */
	public String getYimiaojilu() {
		return yimiaojilu;
	}
	/**
	 * 设置：健康状况
	 */
	public void setJiankangzhuangkuang(String jiankangzhuangkuang) {
		this.jiankangzhuangkuang = jiankangzhuangkuang;
	}
	/**
	 * 获取：健康状况
	 */
	public String getJiankangzhuangkuang() {
		return jiankangzhuangkuang;
	}
	/**
	 * 设置：饮食习惯
	 */
	public void setYinshixiguan(String yinshixiguan) {
		this.yinshixiguan = yinshixiguan;
	}
	/**
	 * 获取：饮食习惯
	 */
	public String getYinshixiguan() {
		return yinshixiguan;
	}
	/**
	 * 设置：特殊营养需求
	 */
	public void setTeshuyingyangxuqiu(String teshuyingyangxuqiu) {
		this.teshuyingyangxuqiu = teshuyingyangxuqiu;
	}
	/**
	 * 获取：特殊营养需求
	 */
	public String getTeshuyingyangxuqiu() {
		return teshuyingyangxuqiu;
	}
	/**
	 * 设置：宠物图片
	 */
	public void setChongwutupian(String chongwutupian) {
		this.chongwutupian = chongwutupian;
	}
	/**
	 * 获取：宠物图片
	 */
	public String getChongwutupian() {
		return chongwutupian;
	}
	/**
	 * 设置：领养申请
	 */
	public void setLingyangshenqing(String lingyangshenqing) {
		this.lingyangshenqing = lingyangshenqing;
	}
	/**
	 * 获取：领养申请
	 */
	public String getLingyangshenqing() {
		return lingyangshenqing;
	}
	/**
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}

	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;


	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
			
}
