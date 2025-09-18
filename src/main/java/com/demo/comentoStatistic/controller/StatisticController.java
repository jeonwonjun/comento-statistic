package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.DepartmentMonthDto;
import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.dto.YearMonthCountDto;
import com.demo.comentoStatistic.dto.YearMonthDayCountDto;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    // 년도별 접속자 수
    @RequestMapping(value="/api/usage/access/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){
        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    // 월별 접속자 수
    @RequestMapping(value="/api/usage/access/month/{yearMonth}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearMonthCountDto> getYearMonthLoginCount(@PathVariable("yearMonth") String yearMonth){
        return ResponseEntity.ok(statisticService.getYearMonthLogins(yearMonth));
    }

    // 일자별 접속자 수
    @RequestMapping(value = "/api/usage/access/{yearMonthDay}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearMonthDayCountDto> getYearMonthDayLoginCount(@PathVariable("yearMonthDay") String yearMonthDay){
        return ResponseEntity.ok(statisticService.getYearMonthDayLogins(yearMonthDay));
    }

    // 하루 평균 접속자 수
    @RequestMapping(value = "/api/usage/access/avg/{startDate}/{endDate}", produces = "application/json")
    public Object getAvgDailyUsersInPeriod(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        return ResponseEntity.ok(statisticService.getAvgDailyUsersInPeriodLogins(startDate, endDate));
    }

    // 휴일을 제외한 로그인 수
    @RequestMapping(value = "/api/usage/login/noHolidays/{startDate}/{endDate}", produces = "application/json")
    public Object getBusinessUsersInPeriod(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        return ResponseEntity.ok(statisticService.getBusinessUsersInPeriodLogins(startDate, endDate));
    }

    // 부서별 월별 로그인 수
    @RequestMapping(value = "/api/usage/login/department/{yearMonth}", produces = "application/json")
    public ResponseEntity<DepartmentMonthDto> getDepartmentMonth(@PathVariable("yearMonth") String yearMonth){
        return ResponseEntity.ok(statisticService.getDepartmentMonthLogins(yearMonth));
    }
}