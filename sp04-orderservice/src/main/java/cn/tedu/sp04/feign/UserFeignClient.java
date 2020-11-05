package cn.tedu.sp04.feign;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/*
从注册表可以获得 user-service 的地址

注册表：
item-service:  localhost:8001,localhost:8002
user-service:  localhost:8101
order-service:  localhost:8201,localhost:8202

 */

@FeignClient(name = "user-service",fallback = UserFeignClientFB.class)
public interface UserFeignClient {
    @GetMapping("/{userId}")
    JsonResult<User> getUser(@PathVariable Integer userId);

    @GetMapping("/{userId}/score")
    JsonResult<?> addScore(@PathVariable Integer userId, @RequestParam Integer score);
}
