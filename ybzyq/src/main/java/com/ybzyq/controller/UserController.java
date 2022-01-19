package com.ybzyq.controller;

import com.ybzyq.common.Result;
import com.ybzyq.entity.User;
import com.ybzyq.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping
    public Result save(@RequestBody User user){
        userMapper.insert(user);
        return Result.success();
    }
}
