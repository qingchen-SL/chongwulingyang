package com.entity.vo;

import com.entity.ZhiyuanzhejiuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 志愿者领养
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public class ZhiyuanzhejiuzhuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 宠物性别
	 */
	
	private String chongwuxingbie;
		
	/**
	 * 宠物年龄
	 */
	
	private String chongwunianling;
		
	/**
	 * 宠物品种
	 */
	
	private String chongwupinzhong;
		
	/**
	 * 宠物图片
	 */
	
	private String chongwutupian;
		
	/**
	 * 求助内容
	 */
	
	private String qiuzhuneirong;
		
	/**
	 * 领养地点
	 */
	
	private String jiuzhudidian;
		
	/**
	 * 发布时间
	 */
	
	private String fabushijian;
		
	/**
	 * 领养记录
	 */
	
	private String jiuzhujilu;
		
	/**
	 * 领养时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jiuzhushijian;
		
	/**
	 * 志愿者账号
	 */
	
	private String zhiyuanzhezhanghao;
		
	/**
	 * 志愿者姓名
	 */
	
	private String zhiyuanzhexingming;
				
	
	/**
	 * 设置：宠物性别
	 */
	 
	public void setChongwuxingbie(String chongwuxingbie) {
		this.chongwuxingbie = chongwuxingbie;
	}
	
	/**
	 * 获取：宠物性别
	 */
	public String getChongwuxingbie() {
		return chongwuxingbie;
	}
				
	
	/**
	 * 设置：宠物年龄
	 */
	 
	public void setChongwunianling(String chongwunianling) {
		this.chongwunianling = chongwunianling;
	}
	
	/**
	 * 获取：宠物年龄
	 */
	public String getChongwunianling() {
		return chongwunianling;
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
	 * 设置：求助内容
	 */
	 
	public void setQiuzhuneirong(String qiuzhuneirong) {
		this.qiuzhuneirong = qiuzhuneirong;
	}
	
	/**
	 * 获取：求助内容
	 */
	public String getQiuzhuneirong() {
		return qiuzhuneirong;
	}
				
	
	/**
	 * 设置：领养地点
	 */
	 
	public void setJiuzhudidian(String jiuzhudidian) {
		this.jiuzhudidian = jiuzhudidian;
	}
	
	/**
	 * 获取：领养地点
	 */
	public String getJiuzhudidian() {
		return jiuzhudidian;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(String fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public String getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：领养记录
	 */
	 
	public void setJiuzhujilu(String jiuzhujilu) {
		this.jiuzhujilu = jiuzhujilu;
	}
	
	/**
	 * 获取：领养记录
	 */
	public String getJiuzhujilu() {
		return jiuzhujilu;
	}
				
	
	/**
	 * 设置：领养时间
	 */
	 
	public void setJiuzhushijian(Date jiuzhushijian) {
		this.jiuzhushijian = jiuzhushijian;
	}
	
	/**
	 * 获取：领养时间
	 */
	public Date getJiuzhushijian() {
		return jiuzhushijian;
	}
				
	
	/**
	 * 设置：志愿者账号
	 */
	 
	public void setZhiyuanzhezhanghao(String zhiyuanzhezhanghao) {
		this.zhiyuanzhezhanghao = zhiyuanzhezhanghao;
	}
	
	/**
	 * 获取：志愿者账号
	 */
	public String getZhiyuanzhezhanghao() {
		return zhiyuanzhezhanghao;
	}
				
	
	/**
	 * 设置：志愿者姓名
	 */
	 
	public void setZhiyuanzhexingming(String zhiyuanzhexingming) {
		this.zhiyuanzhexingming = zhiyuanzhexingming;
	}
	
	/**
	 * 获取：志愿者姓名
	 */
	public String getZhiyuanzhexingming() {
		return zhiyuanzhexingming;
	}
			
}
