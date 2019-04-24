package com.qf.with_my_car;

import com.qf.with_my_car.mapper.Memb_bgMapper;
import com.qf.with_my_car.service.Memb_bgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithMyCarApplicationTests {
    @Autowired
    Memb_bgMapper memb_bgMapper;
    @Autowired
    Memb_bgService service;

    @Test
    public void contextLoads() {
        System.out.println(memb_bgMapper.getAllMember_bg());
        System.out.println(memb_bgMapper.getFavCarById(2));
//        System.out.println("-------------");
        System.out.println(memb_bgMapper.getActiviById(2));
        System.out.println(service.getArticById(2));
    }
    @Test
    public void contextLoads3() {
        Date date=new Date();
        int year= date.getYear()+1900;
        int month = date.getMonth()+1;
        int day = date.getDate();
//        System.out.println(1900+year+"|"+month+"|"+day);
        String time=year+""+month+day;
        int createTime=Integer.valueOf(time);
    }

    @Test
    public void contextLoads2() {
        System.out.println(memb_bgMapper.mohusousuo_bg("中国","奇"));
    }

}
