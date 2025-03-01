package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongwuyongpinshangchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongwuyongpinshangchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwuyongpinshangchengView;


/**
 * 宠物用品商城
 *
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface ChongwuyongpinshangchengService extends IService<ChongwuyongpinshangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongwuyongpinshangchengVO> selectListVO(Wrapper<ChongwuyongpinshangchengEntity> wrapper);
   	
   	ChongwuyongpinshangchengVO selectVO(@Param("ew") Wrapper<ChongwuyongpinshangchengEntity> wrapper);
   	
   	List<ChongwuyongpinshangchengView> selectListView(Wrapper<ChongwuyongpinshangchengEntity> wrapper);
   	
   	ChongwuyongpinshangchengView selectView(@Param("ew") Wrapper<ChongwuyongpinshangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongwuyongpinshangchengEntity> wrapper);

   	

}

