package com.entity.vo;

import com.entity.ChongwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 宠物信息
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public class ChongwuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 宠物详情
	 */
	
	private String chongwuxiangqing;
		
	/**
	 * 领养状态
	 */
	
	private String lingyangzhuangtai;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
				
	
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
	 * 设置：宠物详情
	 */
	 
	public void setChongwuxiangqing(String chongwuxiangqing) {
		this.chongwuxiangqing = chongwuxiangqing;
	}
	
	/**
	 * 获取：宠物详情
	 */
	public String getChongwuxiangqing() {
		return chongwuxiangqing;
	}
				
	
	/**
	 * 设置：领养状态
	 */
	 
	public void setLingyangzhuangtai(String lingyangzhuangtai) {
		this.lingyangzhuangtai = lingyangzhuangtai;
	}
	
	/**
	 * 获取：领养状态
	 */
	public String getLingyangzhuangtai() {
		return lingyangzhuangtai;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
			
}
