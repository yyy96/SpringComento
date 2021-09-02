package com.devfun.settingweb_boot.dao;

import java.util.HashMap;

import com.devfun.settingweb_boot.dto.StatisticDto;
 
public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
    public HashMap<String, Object> selectMonthLogin(String month);
    public HashMap<String, Object> selectDayLogin(String year, String month, String day);
    public HashMap<String, Object> selectAverageLogin();
    public HashMap<String, Object> selectnotHolidayLogin();
    public HashMap<String, Object> selectorganMonthLogin(String organ, String month);
 
}