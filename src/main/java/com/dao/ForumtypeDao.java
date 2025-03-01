package com.dao;

import com.entity.ForumtypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ForumtypeVO;
import com.entity.view.ForumtypeView;


/**
 * 交流论坛类型
 * 
 * @author 
 * @email 
 * @date 2030-11-24 16:15:45
 */
public interface ForumtypeDao extends BaseMapper<ForumtypeEntity> {
	
	List<ForumtypeVO> selectListVO(@Param("ew") Wrapper<ForumtypeEntity> wrapper);
	
	ForumtypeVO selectVO(@Param("ew") Wrapper<ForumtypeEntity> wrapper);
	
	List<ForumtypeView> selectListView(@Param("ew") Wrapper<ForumtypeEntity> wrapper);

	List<ForumtypeView> selectListView(Pagination page,@Param("ew") Wrapper<ForumtypeEntity> wrapper);

	
	ForumtypeView selectView(@Param("ew") Wrapper<ForumtypeEntity> wrapper);
	

}
