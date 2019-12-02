package com.example.springboot;

import com.example.springboot.dao.OscMapper;
import com.example.springboot.domain.Osc;
import com.example.springboot.service.OscService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    private OscMapper oscMapper;

    @Autowired
    private OscService oscService;

    @Test
    void contextLoads() {

//        Osc osc = new Osc("3","2","3","4","5");
//        oscService.add(osc);
//        System.out.println(a.getAll().toString());
//                System.out.println("a.getFromName(1).toString()");


    }

}
