package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);
    YearMonthDayCountDto selectYearMonthDayLogin(String yearMonthDay);
    AvgDailyUsersInPeriodDto selectAvgDailyUsersInPeriodLogin(String startDate, String endDate);
    BusinessUsersInPeriodDto selectBusinessUsersInPeriodLogin(String startDate, String endDate);
    List<DepartmentMonthDto> selectDepartmentMonthLogin(String yearMonth);

    String ping();

}
