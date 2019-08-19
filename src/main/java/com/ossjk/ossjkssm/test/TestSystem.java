package com.ossjk.ossjkssm.test;

import com.alibaba.fastjson.JSON;
import com.ossjk.ossjkssm.system.entity.FbDictionary;
import com.ossjk.ossjkssm.system.service.FbDictionaryService;
import com.ossjk.ossjkssm.system.service.FurnitureBookManageService;
import com.ossjk.ossjkssm.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = "classpath:spring/spring-mvc.xml")
//没有上面两行代码会报空指针错误，location是spring的配置文件的位置
public class TestSystem {
    @Autowired
    private FurnitureBookManageService furnitureBookManageService;
    @Autowired
    private FbDictionaryService fbDictionaryService;
    @Autowired
    private UserService userService;
    @Test
    public void test() {
        String thisCode = furnitureBookManageService.selectLast();
        System.out.println(thisCode);
        String id = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMM");
        System.out.println(formatter);
        //查出的数据取年月部分
        String thisData = thisCode.substring(1, 5);
        System.out.println(thisData);
        //这个判断就是判断你数据取出来的最后一个业务单号是不是当月的
        if (!formatter.format(date).equals(thisData)) {
            System.out.println("新的一月");
            thisData = formatter.format(date);
            //如果是新的一月的就直接变成0001
            id = "J" + thisData + "01";
            System.out.println(id);
        } else {
            System.out.println("当月");
            DecimalFormat df = new DecimalFormat("00");

            //不是新的一月就累加，Integer.parseInt(thisCode.substring(9, 13))转换为int类型再加一
            id = "J" + formatter.format(date)
                    + df.format(1 + Integer.parseInt(thisCode.substring(5, 7)));
            System.out.println("id:" + id);

        }
    }
}
