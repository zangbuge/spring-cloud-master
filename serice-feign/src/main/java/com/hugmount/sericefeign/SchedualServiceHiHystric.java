package com.hugmount.sericefeign;


import org.springframework.stereotype.Component;

/** 自定义断路由返回的类
 * @Author: Li Huiming
 * @Date: 2019/4/8
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

    @Override
    public String sayHiFromClientOne(String name) {
        return "feign断路由返回的信息, sorry "+name;
    }
}
