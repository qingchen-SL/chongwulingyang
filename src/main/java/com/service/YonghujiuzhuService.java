package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghujiuzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghujiuzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghujiuzhuView;


/**
 * 用户领养
 *
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface YonghujiuzhuService extends IService<YonghujiuzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghujiuzhuVO> selectListVO(Wrapper<YonghujiuzhuEntity> wrapper);
   	
   	YonghujiuzhuVO selectVO(@Param("ew") Wrapper<YonghujiuzhuEntity> wrapper);
   	
   	List<YonghujiuzhuView> selectListView(Wrapper<YonghujiuzhuEntity> wrapper);
   	
   	YonghujiuzhuView selectView(@Param("ew") Wrapper<YonghujiuzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghujiuzhuEntity> wrapper);

   	

}

