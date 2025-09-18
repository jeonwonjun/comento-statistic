package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);
    YearMonthDayCountDto selectYearMonthDayLogin(String yearMonthDay);
    avgDailyUsersInPeriodDto selectAvgDailyUsersInPeriodLogin(String startDate, String endDate);
    BusinessUsersInPeriodDto selectBusinessUsersInPeriodLogin(String startDate, String endDate);
    DepartmentMonthDto selectDepartmentMonthLogin(String yearMonth);

}
