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
import com.entity.TokenEntity;
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

import com.entity.ZhiyuanzheEntity;
import com.entity.view.ZhiyuanzheView;

import com.service.ZhiyuanzheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 志愿者
 * 后端接口
 * @author 
 * @email 
 * @date 2030-11-24 16:15:43
 */
@RestController
@RequestMapping("/zhiyuanzhe")
public class ZhiyuanzheController {
    @Autowired
    private ZhiyuanzheService zhiyuanzheService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ZhiyuanzheEntity u = zhiyuanzheService.selectOne(new EntityWrapper<ZhiyuanzheEntity>().eq("zhiyuanzhezhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"zhiyuanzhe",  "志愿者" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ZhiyuanzheEntity zhiyuanzhe){
    	//ValidatorUtils.validateEntity(zhiyuanzhe);
    	ZhiyuanzheEntity u = zhiyuanzheService.selectOne(new EntityWrapper<ZhiyuanzheEntity>().eq("zhiyuanzhezhanghao", zhiyuanzhe.getZhiyuanzhezhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		zhiyuanzhe.setId(uId);
        zhiyuanzheService.insert(zhiyuanzhe);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ZhiyuanzheEntity u = zhiyuanzheService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ZhiyuanzheEntity u = zhiyuanzheService.selectOne(new EntityWrapper<ZhiyuanzheEntity>().eq("zhiyuanzhezhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        zhiyuanzheService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanzheEntity zhiyuanzhe,
		HttpServletRequest request){
        EntityWrapper<ZhiyuanzheEntity> ew = new EntityWrapper<ZhiyuanzheEntity>();



		PageUtils page = zhiyuanzheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhe), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanzheEntity zhiyuanzhe, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanzheEntity> ew = new EntityWrapper<ZhiyuanzheEntity>();

		PageUtils page = zhiyuanzheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhe), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanzheEntity zhiyuanzhe){
       	EntityWrapper<ZhiyuanzheEntity> ew = new EntityWrapper<ZhiyuanzheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanzhe, "zhiyuanzhe")); 
        return R.ok().put("data", zhiyuanzheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanzheEntity zhiyuanzhe){
        EntityWrapper< ZhiyuanzheEntity> ew = new EntityWrapper< ZhiyuanzheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanzhe, "zhiyuanzhe")); 
		ZhiyuanzheView zhiyuanzheView =  zhiyuanzheService.selectView(ew);
		return R.ok("查询志愿者成功").put("data", zhiyuanzheView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhiyuanzhe,deSens);
        return R.ok().put("data", zhiyuanzhe);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zhiyuanzhe,deSens);
        return R.ok().put("data", zhiyuanzhe);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanzheEntity zhiyuanzhe, HttpServletRequest request){
        if(zhiyuanzheService.selectCount(new EntityWrapper<ZhiyuanzheEntity>().eq("zhiyuanzhezhanghao", zhiyuanzhe.getZhiyuanzhezhanghao()))>0) {
            return R.error("志愿者账号已存在");
        }
    	zhiyuanzhe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanzhe);
    	ZhiyuanzheEntity u = zhiyuanzheService.selectOne(new EntityWrapper<ZhiyuanzheEntity>().eq("zhiyuanzhezhanghao", zhiyuanzhe.getZhiyuanzhezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		zhiyuanzhe.setId(new Date().getTime());
        zhiyuanzheService.insert(zhiyuanzhe);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanzheEntity zhiyuanzhe, HttpServletRequest request){
        if(zhiyuanzheService.selectCount(new EntityWrapper<ZhiyuanzheEntity>().eq("zhiyuanzhezhanghao", zhiyuanzhe.getZhiyuanzhezhanghao()))>0) {
            return R.error("志愿者账号已存在");
        }
    	zhiyuanzhe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanzhe);
    	ZhiyuanzheEntity u = zhiyuanzheService.selectOne(new EntityWrapper<ZhiyuanzheEntity>().eq("zhiyuanzhezhanghao", zhiyuanzhe.getZhiyuanzhezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		zhiyuanzhe.setId(new Date().getTime());
        zhiyuanzheService.insert(zhiyuanzhe);
        return R.ok().put("data",zhiyuanzhe.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanzheEntity zhiyuanzhe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanzhe);
        if(zhiyuanzheService.selectCount(new EntityWrapper<ZhiyuanzheEntity>().ne("id", zhiyuanzhe.getId()).eq("zhiyuanzhezhanghao", zhiyuanzhe.getZhiyuanzhezhanghao()))>0) {
            return R.error("志愿者账号已存在");
        }
        //全部更新
        zhiyuanzheService.updateById(zhiyuanzhe);
        // 修改token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUsername(zhiyuanzhe.getZhiyuanzhezhanghao());
        tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", zhiyuanzhe.getId()));

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZhiyuanzheEntity> list = new ArrayList<ZhiyuanzheEntity>();
        for(Long id : ids) {
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(id);
            zhiyuanzhe.setSfsh(sfsh);
            zhiyuanzhe.setShhf(shhf);
            list.add(zhiyuanzhe);
        }
        zhiyuanzheService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanzheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
