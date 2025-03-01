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


import com.dao.ZhiyuanzhejiuzhuDao;
import com.entity.ZhiyuanzhejiuzhuEntity;
import com.service.ZhiyuanzhejiuzhuService;
import com.entity.vo.ZhiyuanzhejiuzhuVO;
import com.entity.view.ZhiyuanzhejiuzhuView;

@Service("zhiyuanzhejiuzhuService")
public class ZhiyuanzhejiuzhuServiceImpl extends ServiceImpl<ZhiyuanzhejiuzhuDao, ZhiyuanzhejiuzhuEntity> implements ZhiyuanzhejiuzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanzhejiuzhuEntity> page = this.selectPage(
                new Query<ZhiyuanzhejiuzhuEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanzhejiuzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanzhejiuzhuEntity> wrapper) {
		  Page<ZhiyuanzhejiuzhuView> page =new Query<ZhiyuanzhejiuzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhiyuanzhejiuzhuVO> selectListVO(Wrapper<ZhiyuanzhejiuzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiyuanzhejiuzhuVO selectVO(Wrapper<ZhiyuanzhejiuzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiyuanzhejiuzhuView> selectListView(Wrapper<ZhiyuanzhejiuzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanzhejiuzhuView selectView(Wrapper<ZhiyuanzhejiuzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
