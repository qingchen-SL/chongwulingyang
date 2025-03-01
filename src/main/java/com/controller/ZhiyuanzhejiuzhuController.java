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

import com.entity.ZhiyuanzhejiuzhuEntity;
import com.entity.view.ZhiyuanzhejiuzhuView;

import com.service.ZhiyuanzhejiuzhuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 志愿者领养
 * 后端接口
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@RestController
@RequestMapping("/zhiyuanzhejiuzhu")
public class ZhiyuanzhejiuzhuController {
    @Autowired
    private ZhiyuanzhejiuzhuService zhiyuanzhejiuzhuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzhe")) {
			zhiyuanzhejiuzhu.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhiyuanzhejiuzhuEntity> ew = new EntityWrapper<ZhiyuanzhejiuzhuEntity>();



		PageUtils page = zhiyuanzhejiuzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhejiuzhu), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanzhejiuzhuEntity> ew = new EntityWrapper<ZhiyuanzhejiuzhuEntity>();

		PageUtils page = zhiyuanzhejiuzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhejiuzhu), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu){
       	EntityWrapper<ZhiyuanzhejiuzhuEntity> ew = new EntityWrapper<ZhiyuanzhejiuzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanzhejiuzhu, "zhiyuanzhejiuzhu")); 
        return R.ok().put("data", zhiyuanzhejiuzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu){
        EntityWrapper< ZhiyuanzhejiuzhuEntity> ew = new EntityWrapper< ZhiyuanzhejiuzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanzhejiuzhu, "zhiyuanzhejiuzhu")); 
		ZhiyuanzhejiuzhuView zhiyuanzhejiuzhuView =  zhiyuanzhejiuzhuService.selectView(ew);
		return R.ok("查询志愿者领养成功").put("data", zhiyuanzhejiuzhuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu = zhiyuanzhejiuzhuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhiyuanzhejiuzhu,deSens);
        return R.ok().put("data", zhiyuanzhejiuzhu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu = zhiyuanzhejiuzhuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhiyuanzhejiuzhu,deSens);
        return R.ok().put("data", zhiyuanzhejiuzhu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhiyuanzhejiuzhu);
        zhiyuanzhejiuzhuService.insert(zhiyuanzhejiuzhu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhiyuanzhejiuzhu);
        zhiyuanzhejiuzhuService.insert(zhiyuanzhejiuzhu);
        return R.ok().put("data",zhiyuanzhejiuzhu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanzhejiuzhuEntity zhiyuanzhejiuzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanzhejiuzhu);
        //全部更新
        zhiyuanzhejiuzhuService.updateById(zhiyuanzhejiuzhu);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanzhejiuzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
