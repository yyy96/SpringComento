package com.devfun.settingweb_boot.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
import com.devfun.settingweb_boot.service.StatisticService;
 
@Controller
@ResponseBody
@RequestMapping("/login")
public class settingTest {
    
    @Autowired
    private StatisticService service;
    
    @RequestMapping("/year")
    public Map<String, Object> yearLogin(String year) throws Exception{ 
        return service.yearloginNum(year);
    }
    
    @RequestMapping("/month")
    public Map<String, Object> monthLogin(String month) throws Exception{ 
        return service.monthloginNum(month);
    }
    
    @RequestMapping("/day")
    public Map<String, Object> dayLogin(String year, String month, String day) throws Exception{ 
        return service.dayloginNum(year, month, day);
    }
    
    @RequestMapping("/average")
    public Map<String, Object> averageLogin() throws Exception{ 
        return service.averageloginNum();
    }
    
    @RequestMapping("/notholiday")
    public Map<String, Object> notholidayLogin() throws Exception{ 
        return service.notholidayloginNum();
    }
    
    @RequestMapping("/organ")
    public Map<String, Object> organmonthloginNum(String organ, String month) throws Exception{ 
        return service.organmonthloginNum(organ, month);
    }
    
    
    @RequestMapping("/test") 
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "devfunpj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}