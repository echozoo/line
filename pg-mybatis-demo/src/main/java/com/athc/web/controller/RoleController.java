package com.athc.web.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.athc.web.model.Role;
import com.athc.web.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * ${table.comment} 前端控制器
 * </p>
 *
 * @author dujf
 * @since 2018-05-17
 */
@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping()
    public String listRole() {
        Page<Role> roleList = roleService.selectPage(new Page<Role>(1, 2), new EntityWrapper<Role>());
        return JSON.toJSONString(roleList);
    }
}
