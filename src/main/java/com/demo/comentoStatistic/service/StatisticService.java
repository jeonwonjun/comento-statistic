package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    @Autowired
    StatisticMapper statisticMapper;

    // 1. 접속자 수 - 연도별 탐색
    public YearCountDto getYearLogins(String year){
        return statisticMapper.selectYearLogin(year);
    }

    // 2. 접속자 수 - 월별 탐색
    public YearMonthCountDto getYearMonthLogins(String yearMonth){
        return statisticMapper.selectYearMonthLogin(yearMonth);
    }

    // 3. 접속자 수 - 일자별 탐색
    public YearMonthDayCountDto getYearMonthDayLogins(String yearMonthDay){
        return statisticMapper.selectYearMonthDayLogin(yearMonthDay);
    }

    // 3. 접속자 수 - 일자별 탐색
    public avgDailyUsersInPeriodDto getAvgDailyUsersInPeriodLogins(String startDate, String endDate){
        return statisticMapper.selectAvgDailyUsersInPeriodLogin(startDate, endDate);
    }

    // 4. 휴일제외 로그인 수
    public BusinessUsersInPeriodDto getBusinessUsersInPeriodLogins(String startDate, String endDate){
        return statisticMapper.selectBusinessUsersInPeriodLogin(startDate, endDate);
    }

    // 5. 부서별 월별 로그인 수
    public DepartmentMonthDto getDepartmentMonthLogins(String yearMonth){
        return statisticMapper.selectDepartmentMonthLogin(yearMonth);
    }
}