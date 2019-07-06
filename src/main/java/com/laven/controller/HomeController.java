package com.laven.controller;

import com.laven.entity.Result;
import com.laven.entity.User;
import com.laven.enums.ResultEnum;
import com.laven.service.UserService;
import com.laven.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

/**
 * @Description:
 * @Author: laven
 * @Date: 2017/7/1 下午11:48
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService service;

    @PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> login(@RequestBody LinkedHashMap<String, String> entity){

        Subject user = SecurityUtils.getSubject();
        if (!user.isAuthenticated()) {
            try {
                UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(entity.get("name"), entity.get("password"));
                user.login(usernamePasswordToken);
                return ResultUtil.success();
            } catch ( UnknownAccountException uae ) {
                return ResultUtil.error(ResultEnum.UNKOWN_ACCOUNT);
            } catch ( IncorrectCredentialsException ice ) {
                return ResultUtil.error(ResultEnum.INCORRECT_PASSWORD);
            } catch ( LockedAccountException lae ) {
                return ResultUtil.error(ResultEnum.ACCOUNT_LOCKED);
            } catch ( AuthenticationException ae ) {
                return ResultUtil.error(ResultEnum.UNKOWN_ERROR);
            }
        }
        return ResultUtil.error(ResultEnum.UNKOWN_ERROR);
    }
}
