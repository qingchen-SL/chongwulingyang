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


import com.dao.YonghujiuzhuDao;
import com.entity.YonghujiuzhuEntity;
import com.service.YonghujiuzhuService;
import com.entity.vo.YonghujiuzhuVO;
import com.entity.view.YonghujiuzhuView;

@Service("yonghujiuzhuService")
public class YonghujiuzhuServiceImpl extends ServiceImpl<YonghujiuzhuDao, YonghujiuzhuEntity> implements YonghujiuzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghujiuzhuEntity> page = this.selectPage(
                new Query<YonghujiuzhuEntity>(params).getPage(),
                new EntityWrapper<YonghujiuzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghujiuzhuEntity> wrapper) {
		  Page<YonghujiuzhuView> page =new Query<YonghujiuzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YonghujiuzhuVO> selectListVO(Wrapper<YonghujiuzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghujiuzhuVO selectVO(Wrapper<YonghujiuzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghujiuzhuView> selectListView(Wrapper<YonghujiuzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghujiuzhuView selectView(Wrapper<YonghujiuzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
