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

import com.entity.JiuzhuzhidaoEntity;
import com.entity.view.JiuzhuzhidaoView;

import com.service.JiuzhuzhidaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 领养指导
 * 后端接口
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@RestController
@RequestMapping("/jiuzhuzhidao")
public class JiuzhuzhidaoController {
    @Autowired
    private JiuzhuzhidaoService jiuzhuzhidaoService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiuzhuzhidaoEntity jiuzhuzhidao,
		HttpServletRequest request){
        EntityWrapper<JiuzhuzhidaoEntity> ew = new EntityWrapper<JiuzhuzhidaoEntity>();



		PageUtils page = jiuzhuzhidaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuzhuzhidao), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiuzhuzhidaoEntity jiuzhuzhidao, 
		HttpServletRequest request){
        EntityWrapper<JiuzhuzhidaoEntity> ew = new EntityWrapper<JiuzhuzhidaoEntity>();

		PageUtils page = jiuzhuzhidaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuzhuzhidao), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiuzhuzhidaoEntity jiuzhuzhidao){
       	EntityWrapper<JiuzhuzhidaoEntity> ew = new EntityWrapper<JiuzhuzhidaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiuzhuzhidao, "jiuzhuzhidao")); 
        return R.ok().put("data", jiuzhuzhidaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiuzhuzhidaoEntity jiuzhuzhidao){
        EntityWrapper< JiuzhuzhidaoEntity> ew = new EntityWrapper< JiuzhuzhidaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiuzhuzhidao, "jiuzhuzhidao")); 
		JiuzhuzhidaoView jiuzhuzhidaoView =  jiuzhuzhidaoService.selectView(ew);
		return R.ok("查询领养指导成功").put("data", jiuzhuzhidaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiuzhuzhidaoEntity jiuzhuzhidao = jiuzhuzhidaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiuzhuzhidao,deSens);
        return R.ok().put("data", jiuzhuzhidao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiuzhuzhidaoEntity jiuzhuzhidao = jiuzhuzhidaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiuzhuzhidao,deSens);
        return R.ok().put("data", jiuzhuzhidao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiuzhuzhidaoEntity jiuzhuzhidao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiuzhuzhidao);
        jiuzhuzhidaoService.insert(jiuzhuzhidao);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiuzhuzhidaoEntity jiuzhuzhidao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiuzhuzhidao);
        jiuzhuzhidaoService.insert(jiuzhuzhidao);
        return R.ok().put("data",jiuzhuzhidao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiuzhuzhidaoEntity jiuzhuzhidao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiuzhuzhidao);
        //全部更新
        jiuzhuzhidaoService.updateById(jiuzhuzhidao);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiuzhuzhidaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
