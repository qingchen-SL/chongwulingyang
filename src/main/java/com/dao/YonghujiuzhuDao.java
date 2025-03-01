package com.dao;

import com.entity.YonghujiuzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghujiuzhuVO;
import com.entity.view.YonghujiuzhuView;


/**
 * 用户领养
 * 
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface YonghujiuzhuDao extends BaseMapper<YonghujiuzhuEntity> {
	
	List<YonghujiuzhuVO> selectListVO(@Param("ew") Wrapper<YonghujiuzhuEntity> wrapper);
	
	YonghujiuzhuVO selectVO(@Param("ew") Wrapper<YonghujiuzhuEntity> wrapper);
	
	List<YonghujiuzhuView> selectListView(@Param("ew") Wrapper<YonghujiuzhuEntity> wrapper);

	List<YonghujiuzhuView> selectListView(Pagination page,@Param("ew") Wrapper<YonghujiuzhuEntity> wrapper);

	
	YonghujiuzhuView selectView(@Param("ew") Wrapper<YonghujiuzhuEntity> wrapper);
	

}
