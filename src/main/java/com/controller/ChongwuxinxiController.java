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

import com.entity.ChongwuxinxiEntity;
import com.entity.view.ChongwuxinxiView;

import com.service.ChongwuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 宠物信息
 * 后端接口
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@RestController
@RequestMapping("/chongwuxinxi")
public class ChongwuxinxiController {
    @Autowired
    private ChongwuxinxiService chongwuxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongwuxinxiEntity chongwuxinxi,
		HttpServletRequest request){
        EntityWrapper<ChongwuxinxiEntity> ew = new EntityWrapper<ChongwuxinxiEntity>();



		PageUtils page = chongwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongwuxinxiEntity chongwuxinxi, 
		HttpServletRequest request){
        EntityWrapper<ChongwuxinxiEntity> ew = new EntityWrapper<ChongwuxinxiEntity>();

		PageUtils page = chongwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongwuxinxiEntity chongwuxinxi){
       	EntityWrapper<ChongwuxinxiEntity> ew = new EntityWrapper<ChongwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongwuxinxi, "chongwuxinxi")); 
        return R.ok().put("data", chongwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongwuxinxiEntity chongwuxinxi){
        EntityWrapper< ChongwuxinxiEntity> ew = new EntityWrapper< ChongwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongwuxinxi, "chongwuxinxi")); 
		ChongwuxinxiView chongwuxinxiView =  chongwuxinxiService.selectView(ew);
		return R.ok("查询宠物信息成功").put("data", chongwuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongwuxinxiEntity chongwuxinxi = chongwuxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(chongwuxinxi,deSens);
        return R.ok().put("data", chongwuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongwuxinxiEntity chongwuxinxi = chongwuxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(chongwuxinxi,deSens);
        return R.ok().put("data", chongwuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChongwuxinxiEntity chongwuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chongwuxinxi);
        chongwuxinxiService.insert(chongwuxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChongwuxinxiEntity chongwuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chongwuxinxi);
        chongwuxinxiService.insert(chongwuxinxi);
        return R.ok().put("data",chongwuxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChongwuxinxiEntity chongwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongwuxinxi);
        //全部更新
        chongwuxinxiService.updateById(chongwuxinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chongwuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
