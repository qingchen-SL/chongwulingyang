package com.entity.view;

import com.entity.ZhiyuanzhejiuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 志愿者领养
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@TableName("zhiyuanzhejiuzhu")
public class ZhiyuanzhejiuzhuView  extends ZhiyuanzhejiuzhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhiyuanzhejiuzhuView(){
	}
 
 	public ZhiyuanzhejiuzhuView(ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhuEntity){
 	try {
			BeanUtils.copyProperties(this, zhiyuanzhejiuzhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
