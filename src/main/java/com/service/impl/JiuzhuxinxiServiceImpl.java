package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiuzhuxinxiDao;
import com.entity.JiuzhuxinxiEntity;
import com.service.JiuzhuxinxiService;
import com.entity.vo.JiuzhuxinxiVO;
import com.entity.view.JiuzhuxinxiView;

@Service("jiuzhuxinxiService")
public class JiuzhuxinxiServiceImpl extends ServiceImpl<JiuzhuxinxiDao, JiuzhuxinxiEntity> implements JiuzhuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuzhuxinxiEntity> page = this.selectPage(
                new Query<JiuzhuxinxiEntity>(params).getPage(),
                new EntityWrapper<JiuzhuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuzhuxinxiEntity> wrapper) {
		  Page<JiuzhuxinxiView> page =new Query<JiuzhuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiuzhuxinxiVO> selectListVO(Wrapper<JiuzhuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiuzhuxinxiVO selectVO(Wrapper<JiuzhuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiuzhuxinxiView> selectListView(Wrapper<JiuzhuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuzhuxinxiView selectView(Wrapper<JiuzhuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiuzhuxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiuzhuxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiuzhuxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
