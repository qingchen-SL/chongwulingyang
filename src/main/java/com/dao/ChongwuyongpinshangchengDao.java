package com.dao;

import com.entity.ChongwuyongpinshangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwuyongpinshangchengVO;
import com.entity.view.ChongwuyongpinshangchengView;


/**
 * 宠物用品商城
 * 
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface ChongwuyongpinshangchengDao extends BaseMapper<ChongwuyongpinshangchengEntity> {
	
	List<ChongwuyongpinshangchengVO> selectListVO(@Param("ew") Wrapper<ChongwuyongpinshangchengEntity> wrapper);
	
	ChongwuyongpinshangchengVO selectVO(@Param("ew") Wrapper<ChongwuyongpinshangchengEntity> wrapper);
	
	List<ChongwuyongpinshangchengView> selectListView(@Param("ew") Wrapper<ChongwuyongpinshangchengEntity> wrapper);

	List<ChongwuyongpinshangchengView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwuyongpinshangchengEntity> wrapper);

	
	ChongwuyongpinshangchengView selectView(@Param("ew") Wrapper<ChongwuyongpinshangchengEntity> wrapper);
	

}
