package com.dao;

import com.entity.ZhiyuanzhejiuzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiyuanzhejiuzhuVO;
import com.entity.view.ZhiyuanzhejiuzhuView;


/**
 * 志愿者领养
 * 
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
public interface ZhiyuanzhejiuzhuDao extends BaseMapper<ZhiyuanzhejiuzhuEntity> {
	
	List<ZhiyuanzhejiuzhuVO> selectListVO(@Param("ew") Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);
	
	ZhiyuanzhejiuzhuVO selectVO(@Param("ew") Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);
	
	List<ZhiyuanzhejiuzhuView> selectListView(@Param("ew") Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);

	List<ZhiyuanzhejiuzhuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);

	
	ZhiyuanzhejiuzhuView selectView(@Param("ew") Wrapper<ZhiyuanzhejiuzhuEntity> wrapper);
	

}
