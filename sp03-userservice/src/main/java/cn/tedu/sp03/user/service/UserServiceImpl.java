package cn.tedu.sp03.user.service;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.web.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Value("${sp.user-service.users}")
    private String userJson; //yml配置中的测试用用户数据

    //根据用户id获取用户
    @Override
    public User getUser(Integer userId) {
        log.info("获取用户，userId="+userId+", userJson="+userJson);
        //从测试用的用户数据中寻找
        List<User> list = JsonUtil.from(userJson, new TypeReference<List<User>>() {});
        for (User u:list) {
            if (u.getId().equals(userId)) {
                return u;
            }
        }

        //找不到，就返回一个写死的用户
        return new User(userId, "用户名"+userId, "密码"+userId);
    }

    //增加用户积分
    @Override
    public void addScore(Integer userId, Integer score) {
        log.info("增加用户积分，userId="+userId+", score="+score);
    }
}
