package com.entity.vo;

import com.entity.JiuzhuzhidaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 领养指导
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public class JiuzhuzhidaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 领养流程
	 */
	
	private String jiuzhuliucheng;
		
	/**
	 * 领养指导
	 */
	
	private String jiuzhuzhidao;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faburiqi;
				
	
	/**
	 * 设置：领养流程
	 */
	 
	public void setJiuzhuliucheng(String jiuzhuliucheng) {
		this.jiuzhuliucheng = jiuzhuliucheng;
	}
	
	/**
	 * 获取：领养流程
	 */
	public String getJiuzhuliucheng() {
		return jiuzhuliucheng;
	}
				
	
	/**
	 * 设置：领养指导
	 */
	 
	public void setJiuzhuzhidao(String jiuzhuzhidao) {
		this.jiuzhuzhidao = jiuzhuzhidao;
	}
	
	/**
	 * 获取：领养指导
	 */
	public String getJiuzhuzhidao() {
		return jiuzhuzhidao;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
	}
			
}
