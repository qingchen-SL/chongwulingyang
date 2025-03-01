package com.dao;

import com.entity.JiuzhuzhidaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiuzhuzhidaoVO;
import com.entity.view.JiuzhuzhidaoView;


/**
 * 领养指导
 * 
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface JiuzhuzhidaoDao extends BaseMapper<JiuzhuzhidaoEntity> {
	
	List<JiuzhuzhidaoVO> selectListVO(@Param("ew") Wrapper<JiuzhuzhidaoEntity> wrapper);
	
	JiuzhuzhidaoVO selectVO(@Param("ew") Wrapper<JiuzhuzhidaoEntity> wrapper);
	
	List<JiuzhuzhidaoView> selectListView(@Param("ew") Wrapper<JiuzhuzhidaoEntity> wrapper);

	List<JiuzhuzhidaoView> selectListView(Pagination page,@Param("ew") Wrapper<JiuzhuzhidaoEntity> wrapper);

	
	JiuzhuzhidaoView selectView(@Param("ew") Wrapper<JiuzhuzhidaoEntity> wrapper);
	

}
