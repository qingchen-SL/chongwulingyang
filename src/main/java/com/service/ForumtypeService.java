package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ForumtypeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ForumtypeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ForumtypeView;


/**
 * 交流论坛类型
 *
 * @author 
 * @email 
 * @date 2030-11-24 16:15:45
 */
public interface ForumtypeService extends IService<ForumtypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ForumtypeVO> selectListVO(Wrapper<ForumtypeEntity> wrapper);
   	
   	ForumtypeVO selectVO(@Param("ew") Wrapper<ForumtypeEntity> wrapper);
   	
   	List<ForumtypeView> selectListView(Wrapper<ForumtypeEntity> wrapper);
   	
   	ForumtypeView selectView(@Param("ew") Wrapper<ForumtypeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ForumtypeEntity> wrapper);

   	

}

