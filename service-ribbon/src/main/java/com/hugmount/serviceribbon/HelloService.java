package com.hugmount.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Li Huiming
 * @Date: 2019/4/8
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError") //断路由注解
    public String hiService(String name){
        String res = restTemplate.getForObject("http://SERVICE-HI/hi?name="+name ,String.class);
        return res;
    }


    public String hiError(String name) {
        return "hi,"+name+",sorry,error! 这是断路由返回的固定信息";
    }
}
