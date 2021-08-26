package com.devfun.settingweb_boot.service;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    public HashMap<String, Object> yearloginNum (String year) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        try {
            retVal = uMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("success", true);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        return retVal;
    }
    
    @Override
    public HashMap<String, Object> monthloginNum (String month) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        try {
            retVal = uMapper.selectMonthLogin(month);
            retVal.put("month", month);
            retVal.put("success", true);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        return retVal;
    }
    
    @Override
    public HashMap<String, Object> dayloginNum (String year, String month, String day) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        try {
            retVal = uMapper.selectDayLogin(year, month, day);
            retVal.put("year", year);
            retVal.put("month", month);
            retVal.put("day", day);
            retVal.put("success", true);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        return retVal;
    }
    
    @Override
    public HashMap<String, Object> averageloginNum () {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        try {
            retVal = uMapper.selectAverageLogin();
            retVal.put("success", true);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        return retVal;
    }
    
    @Override
    public HashMap<String, Object> notholidayloginNum () {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        try {
            retVal = uMapper.selectnotHolidayLogin();
            retVal.put("success", true);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        return retVal;
    }
    
    
    @Override
    public HashMap<String, Object> organmonthloginNum (String organ, String month) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        try {
            retVal = uMapper.selectorganMonthLogin(organ, month);
            retVal.put("month", organ);
            retVal.put("month", month);
            retVal.put("success", true);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        return retVal;
    }
 
 
}