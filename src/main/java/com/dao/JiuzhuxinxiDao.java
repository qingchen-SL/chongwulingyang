package com.dao;

import com.entity.JiuzhuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiuzhuxinxiVO;
import com.entity.view.JiuzhuxinxiView;


/**
 * 领养信息
 * 
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface JiuzhuxinxiDao extends BaseMapper<JiuzhuxinxiEntity> {
	
	List<JiuzhuxinxiVO> selectListVO(@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);
	
	JiuzhuxinxiVO selectVO(@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);
	
	List<JiuzhuxinxiView> selectListView(@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);

	List<JiuzhuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);

	
	JiuzhuxinxiView selectView(@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiuzhuxinxiEntity> wrapper);



}
