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


import com.dao.ChongwuyongpinshangchengDao;
import com.entity.ChongwuyongpinshangchengEntity;
import com.service.ChongwuyongpinshangchengService;
import com.entity.vo.ChongwuyongpinshangchengVO;
import com.entity.view.ChongwuyongpinshangchengView;

@Service("chongwuyongpinshangchengService")
public class ChongwuyongpinshangchengServiceImpl extends ServiceImpl<ChongwuyongpinshangchengDao, ChongwuyongpinshangchengEntity> implements ChongwuyongpinshangchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwuyongpinshangchengEntity> page = this.selectPage(
                new Query<ChongwuyongpinshangchengEntity>(params).getPage(),
                new EntityWrapper<ChongwuyongpinshangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwuyongpinshangchengEntity> wrapper) {
		  Page<ChongwuyongpinshangchengView> page =new Query<ChongwuyongpinshangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChongwuyongpinshangchengVO> selectListVO(Wrapper<ChongwuyongpinshangchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwuyongpinshangchengVO selectVO(Wrapper<ChongwuyongpinshangchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwuyongpinshangchengView> selectListView(Wrapper<ChongwuyongpinshangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwuyongpinshangchengView selectView(Wrapper<ChongwuyongpinshangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
