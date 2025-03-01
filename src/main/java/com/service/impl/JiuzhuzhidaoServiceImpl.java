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


import com.dao.JiuzhuzhidaoDao;
import com.entity.JiuzhuzhidaoEntity;
import com.service.JiuzhuzhidaoService;
import com.entity.vo.JiuzhuzhidaoVO;
import com.entity.view.JiuzhuzhidaoView;

@Service("jiuzhuzhidaoService")
public class JiuzhuzhidaoServiceImpl extends ServiceImpl<JiuzhuzhidaoDao, JiuzhuzhidaoEntity> implements JiuzhuzhidaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuzhuzhidaoEntity> page = this.selectPage(
                new Query<JiuzhuzhidaoEntity>(params).getPage(),
                new EntityWrapper<JiuzhuzhidaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuzhuzhidaoEntity> wrapper) {
		  Page<JiuzhuzhidaoView> page =new Query<JiuzhuzhidaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiuzhuzhidaoVO> selectListVO(Wrapper<JiuzhuzhidaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiuzhuzhidaoVO selectVO(Wrapper<JiuzhuzhidaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiuzhuzhidaoView> selectListView(Wrapper<JiuzhuzhidaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuzhuzhidaoView selectView(Wrapper<JiuzhuzhidaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
