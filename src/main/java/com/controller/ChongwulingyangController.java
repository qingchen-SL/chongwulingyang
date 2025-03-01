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

import com.entity.ChongwulingyangEntity;
import com.entity.view.ChongwulingyangView;

import com.service.ChongwulingyangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 宠物领养
 * 后端接口
 * @author 
 * @email 
 * @date 2030-11-24 16:15:44
 */
@RestController
@RequestMapping("/chongwulingyang")
public class ChongwulingyangController {
    @Autowired
    private ChongwulingyangService chongwulingyangService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongwulingyangEntity chongwulingyang,
		HttpServletRequest request){

        EntityWrapper<ChongwulingyangEntity> ew = new EntityWrapper<ChongwulingyangEntity>();



		PageUtils page = chongwulingyangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwulingyang), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongwulingyangEntity chongwulingyang, 
		HttpServletRequest request){
        EntityWrapper<ChongwulingyangEntity> ew = new EntityWrapper<ChongwulingyangEntity>();

		PageUtils page = chongwulingyangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwulingyang), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongwulingyangEntity chongwulingyang){
       	EntityWrapper<ChongwulingyangEntity> ew = new EntityWrapper<ChongwulingyangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongwulingyang, "chongwulingyang")); 
        return R.ok().put("data", chongwulingyangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongwulingyangEntity chongwulingyang){
        EntityWrapper< ChongwulingyangEntity> ew = new EntityWrapper< ChongwulingyangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongwulingyang, "chongwulingyang")); 
		ChongwulingyangView chongwulingyangView =  chongwulingyangService.selectView(ew);
		return R.ok("查询宠物领养成功").put("data", chongwulingyangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongwulingyangEntity chongwulingyang = chongwulingyangService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(chongwulingyang,deSens);
        return R.ok().put("data", chongwulingyang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongwulingyangEntity chongwulingyang = chongwulingyangService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(chongwulingyang,deSens);
        return R.ok().put("data", chongwulingyang);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChongwulingyangEntity chongwulingyang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chongwulingyang);
        chongwulingyangService.insert(chongwulingyang);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChongwulingyangEntity chongwulingyang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chongwulingyang);
        chongwulingyangService.insert(chongwulingyang);
        return R.ok().put("data",chongwulingyang.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChongwulingyangEntity chongwulingyang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongwulingyang);
        //全部更新
        chongwulingyangService.updateById(chongwulingyang);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ChongwulingyangEntity> list = new ArrayList<ChongwulingyangEntity>();
        for(Long id : ids) {
            ChongwulingyangEntity chongwulingyang = chongwulingyangService.selectById(id);
            chongwulingyang.setSfsh(sfsh);
            chongwulingyang.setShhf(shhf);
            list.add(chongwulingyang);
        }
        chongwulingyangService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chongwulingyangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
