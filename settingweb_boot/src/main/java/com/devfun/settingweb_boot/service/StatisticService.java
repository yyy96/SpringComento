package com.devfun.settingweb_boot.service;

import java.util.HashMap;
 
public interface StatisticService {
    public HashMap<String,Object> yearloginNum (String year);
    public HashMap<String,Object> monthloginNum (String month);
    public HashMap<String,Object> dayloginNum (String year, String month, String day);
    public HashMap<String,Object> averageloginNum ();
    public HashMap<String,Object> notholidayloginNum ();
    public HashMap<String,Object> organmonthloginNum (String organ, String month);
}