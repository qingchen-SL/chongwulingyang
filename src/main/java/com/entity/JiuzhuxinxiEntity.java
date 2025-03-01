package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 领养信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@TableName("jiuzhuxinxi")
public class JiuzhuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiuzhuxinxiEntity() {
		
	}
	
	public JiuzhuxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 领养标题
	 */
					
	private String jiuzhubiaoti;
	
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
	 * 志愿者账号
	 */

	private String zhiyuanzhezhanghao;

	/**
	 * 志愿者姓名
	 */
	private String zhiyuanzhexingming;

	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：领养标题
	 */
	public void setJiuzhubiaoti(String jiuzhubiaoti) {
		this.jiuzhubiaoti = jiuzhubiaoti;
	}
	/**
	 * 获取：领养标题
	 */
	public String getJiuzhubiaoti() {
		return jiuzhubiaoti;
	}
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
