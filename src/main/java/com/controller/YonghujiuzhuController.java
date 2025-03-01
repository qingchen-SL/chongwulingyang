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

import com.entity.YonghujiuzhuEntity;
import com.entity.view.YonghujiuzhuView;

import com.service.YonghujiuzhuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 用户领养
 * 后端接口
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@RestController
@RequestMapping("/yonghujiuzhu")
public class YonghujiuzhuController {
    @Autowired
    private YonghujiuzhuService yonghujiuzhuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YonghujiuzhuEntity yonghujiuzhu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yonghujiuzhu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YonghujiuzhuEntity> ew = new EntityWrapper<YonghujiuzhuEntity>();



		PageUtils page = yonghujiuzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghujiuzhu), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YonghujiuzhuEntity yonghujiuzhu, 
		HttpServletRequest request){
        EntityWrapper<YonghujiuzhuEntity> ew = new EntityWrapper<YonghujiuzhuEntity>();

		PageUtils page = yonghujiuzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghujiuzhu), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YonghujiuzhuEntity yonghujiuzhu){
       	EntityWrapper<YonghujiuzhuEntity> ew = new EntityWrapper<YonghujiuzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yonghujiuzhu, "yonghujiuzhu")); 
        return R.ok().put("data", yonghujiuzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YonghujiuzhuEntity yonghujiuzhu){
        EntityWrapper< YonghujiuzhuEntity> ew = new EntityWrapper< YonghujiuzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yonghujiuzhu, "yonghujiuzhu")); 
		YonghujiuzhuView yonghujiuzhuView =  yonghujiuzhuService.selectView(ew);
		return R.ok("查询用户领养成功").put("data", yonghujiuzhuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YonghujiuzhuEntity yonghujiuzhu = yonghujiuzhuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(yonghujiuzhu,deSens);
        return R.ok().put("data", yonghujiuzhu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YonghujiuzhuEntity yonghujiuzhu = yonghujiuzhuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(yonghujiuzhu,deSens);
        return R.ok().put("data", yonghujiuzhu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YonghujiuzhuEntity yonghujiuzhu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yonghujiuzhu);
        yonghujiuzhuService.insert(yonghujiuzhu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YonghujiuzhuEntity yonghujiuzhu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yonghujiuzhu);
        yonghujiuzhuService.insert(yonghujiuzhu);
        return R.ok().put("data",yonghujiuzhu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YonghujiuzhuEntity yonghujiuzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yonghujiuzhu);
        //全部更新
        yonghujiuzhuService.updateById(yonghujiuzhu);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yonghujiuzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
