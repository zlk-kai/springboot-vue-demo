package com.ybzyq.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ybzyq.common.Result;
import com.ybzyq.entity.User;
import com.ybzyq.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@RestController
@RequestMapping("/user")

public class UserController {

    @Resource
    UserMapper userMapper;
//  插入数据
    @PostMapping
    public Result<?> save(@RequestBody User user){

        if (user.getPassword() == null){
            user.setPassword("123456");
        }
        userMapper.insert(user);

        return Result.success();
    }
//    模糊查询
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "") String search){
        return Result.success(userMapper.selectPage(new Page<>(pageNum,pageSize), Wrappers.<User>lambdaQuery().like(User::getNickname,search)));
    }
}
