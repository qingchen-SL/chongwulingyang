package com.entity.vo;

import com.entity.JiuzhuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 领养信息
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public class JiuzhuxinxiVO  implements Serializable {
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
	 * 求助人
	 */
	
	private String qiuzhuren;
		
	/**
	 * 求助时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date qiuzhushijian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：求助人
	 */
	 
	public void setQiuzhuren(String qiuzhuren) {
		this.qiuzhuren = qiuzhuren;
	}
	
	/**
	 * 获取：求助人
	 */
	public String getQiuzhuren() {
		return qiuzhuren;
	}
				
	
	/**
	 * 设置：求助时间
	 */
	 
	public void setQiuzhushijian(Date qiuzhushijian) {
		this.qiuzhushijian = qiuzhushijian;
	}
	
	/**
	 * 获取：求助时间
	 */
	public Date getQiuzhushijian() {
		return qiuzhushijian;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
