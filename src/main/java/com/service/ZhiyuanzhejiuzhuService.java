package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiyuanzhejiuzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiyuanzhejiuzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiyuanzhejiuzhuView;


/**
 * 志愿者领养
 *
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface ZhiyuanzhejiuzhuService extends IService<ZhiyuanzhejiuzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanzhejiuzhuVO> selectListVO(Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);
   	
   	ZhiyuanzhejiuzhuVO selectVO(@Param("ew") Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);
   	
   	List<ZhiyuanzhejiuzhuView> selectListView(Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);
   	
   	ZhiyuanzhejiuzhuView selectView(@Param("ew") Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);

   	

}

