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

import com.entity.ChongwuyongpinshangchengEntity;
import com.entity.view.ChongwuyongpinshangchengView;

import com.service.ChongwuyongpinshangchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 宠物用品商城
 * 后端接口
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@RestController
@RequestMapping("/chongwuyongpinshangcheng")
public class ChongwuyongpinshangchengController {
    @Autowired
    private ChongwuyongpinshangchengService chongwuyongpinshangchengService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongwuyongpinshangchengEntity chongwuyongpinshangcheng,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<ChongwuyongpinshangchengEntity> ew = new EntityWrapper<ChongwuyongpinshangchengEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);



		PageUtils page = chongwuyongpinshangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuyongpinshangcheng), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongwuyongpinshangchengEntity chongwuyongpinshangcheng, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<ChongwuyongpinshangchengEntity> ew = new EntityWrapper<ChongwuyongpinshangchengEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = chongwuyongpinshangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuyongpinshangcheng), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongwuyongpinshangchengEntity chongwuyongpinshangcheng){
       	EntityWrapper<ChongwuyongpinshangchengEntity> ew = new EntityWrapper<ChongwuyongpinshangchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongwuyongpinshangcheng, "chongwuyongpinshangcheng")); 
        return R.ok().put("data", chongwuyongpinshangchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongwuyongpinshangchengEntity chongwuyongpinshangcheng){
        EntityWrapper< ChongwuyongpinshangchengEntity> ew = new EntityWrapper< ChongwuyongpinshangchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongwuyongpinshangcheng, "chongwuyongpinshangcheng")); 
		ChongwuyongpinshangchengView chongwuyongpinshangchengView =  chongwuyongpinshangchengService.selectView(ew);
		return R.ok("查询宠物用品商城成功").put("data", chongwuyongpinshangchengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongwuyongpinshangchengEntity chongwuyongpinshangcheng = chongwuyongpinshangchengService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(chongwuyongpinshangcheng,deSens);
        return R.ok().put("data", chongwuyongpinshangcheng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongwuyongpinshangchengEntity chongwuyongpinshangcheng = chongwuyongpinshangchengService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(chongwuyongpinshangcheng,deSens);
        return R.ok().put("data", chongwuyongpinshangcheng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChongwuyongpinshangchengEntity chongwuyongpinshangcheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chongwuyongpinshangcheng);
        chongwuyongpinshangchengService.insert(chongwuyongpinshangcheng);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChongwuyongpinshangchengEntity chongwuyongpinshangcheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chongwuyongpinshangcheng);
        chongwuyongpinshangchengService.insert(chongwuyongpinshangcheng);
        return R.ok().put("data",chongwuyongpinshangcheng.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChongwuyongpinshangchengEntity chongwuyongpinshangcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongwuyongpinshangcheng);
        //全部更新
        chongwuyongpinshangchengService.updateById(chongwuyongpinshangcheng);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chongwuyongpinshangchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
