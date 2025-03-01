package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiuzhuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiuzhuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuzhuxinxiView;


/**
 * 领养信息
 *
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface JiuzhuxinxiService extends IService<JiuzhuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiuzhuxinxiVO> selectListVO(Wrapper<JiuzhuxinxiEntity> wrapper);
   	
   	JiuzhuxinxiVO selectVO(@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);
   	
   	List<JiuzhuxinxiView> selectListView(Wrapper<JiuzhuxinxiEntity> wrapper);
   	
   	JiuzhuxinxiView selectView(@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiuzhuxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiuzhuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiuzhuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiuzhuxinxiEntity> wrapper);



}

