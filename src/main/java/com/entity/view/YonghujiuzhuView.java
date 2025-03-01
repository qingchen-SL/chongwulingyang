package com.entity.view;

import com.entity.YonghujiuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 用户领养
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@TableName("yonghujiuzhu")
public class YonghujiuzhuView  extends YonghujiuzhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YonghujiuzhuView(){
	}
 
 	public YonghujiuzhuView(YonghujiuzhuEntity yonghujiuzhuEntity){
 	try {
			BeanUtils.copyProperties(this, yonghujiuzhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
