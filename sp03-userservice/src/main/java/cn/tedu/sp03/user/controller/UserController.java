package cn.tedu.sp03.user.controller;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        User user = userService.getUser(userId); //获取用户
        return JsonResult.ok().data(user);
    }

    //      http://localhsot:8101/8/score?score=1000
    @GetMapping("/{userId}/score")
    public JsonResult<?> addScore(@PathVariable Integer userId, Integer score) {
        userService.addScore(userId, score); //增加用户积分
        return JsonResult.ok().msg("增加用户积分成功");   // "{code:200, msg:'xxxxxxx', data:null}"
    }

}
