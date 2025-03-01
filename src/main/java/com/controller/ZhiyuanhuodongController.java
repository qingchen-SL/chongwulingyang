package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhiyuanhuodongEntity;
import com.entity.view.ZhiyuanhuodongView;

import com.service.ZhiyuanhuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 志愿活动
 * 后端接口
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@RestController
@RequestMapping("/zhiyuanhuodong")
public class ZhiyuanhuodongController {
    @Autowired
    private ZhiyuanhuodongService zhiyuanhuodongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanhuodongEntity zhiyuanhuodong,
		HttpServletRequest request){
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();



		PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanhuodongEntity zhiyuanhuodong, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();

		PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanhuodongEntity zhiyuanhuodong){
       	EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanhuodong, "zhiyuanhuodong")); 
        return R.ok().put("data", zhiyuanhuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanhuodongEntity zhiyuanhuodong){
        EntityWrapper< ZhiyuanhuodongEntity> ew = new EntityWrapper< ZhiyuanhuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanhuodong, "zhiyuanhuodong")); 
		ZhiyuanhuodongView zhiyuanhuodongView =  zhiyuanhuodongService.selectView(ew);
		return R.ok("查询志愿活动成功").put("data", zhiyuanhuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhiyuanhuodong,deSens);
        return R.ok().put("data", zhiyuanhuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhiyuanhuodong,deSens);
        return R.ok().put("data", zhiyuanhuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhiyuanhuodong);
        zhiyuanhuodongService.insert(zhiyuanhuodong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhiyuanhuodong);
        zhiyuanhuodongService.insert(zhiyuanhuodong);
        return R.ok().put("data",zhiyuanhuodong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanhuodong);
        //全部更新
        zhiyuanhuodongService.updateById(zhiyuanhuodong);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanhuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
