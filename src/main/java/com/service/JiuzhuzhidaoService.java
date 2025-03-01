package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiuzhuzhidaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiuzhuzhidaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuzhuzhidaoView;


/**
 * 领养指导
 *
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface JiuzhuzhidaoService extends IService<JiuzhuzhidaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiuzhuzhidaoVO> selectListVO(Wrapper<JiuzhuzhidaoEntity> wrapper);
   	
   	JiuzhuzhidaoVO selectVO(@Param("ew") Wrapper<JiuzhuzhidaoEntity> wrapper);
   	
   	List<JiuzhuzhidaoView> selectListView(Wrapper<JiuzhuzhidaoEntity> wrapper);
   	
   	JiuzhuzhidaoView selectView(@Param("ew") Wrapper<JiuzhuzhidaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiuzhuzhidaoEntity> wrapper);

   	

}

