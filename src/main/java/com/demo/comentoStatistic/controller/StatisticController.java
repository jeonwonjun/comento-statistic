package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.*;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/api/usage")
@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    // 년도별 접속자 수
    @GetMapping(value="/access/year/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){
        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    // 월별 접속자 수
    @GetMapping(value="/access/month/{yearMonth}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearMonthCountDto> getYearMonthLoginCount(@PathVariable("yearMonth") String yearMonth){
        return ResponseEntity.ok(statisticService.getYearMonthLogins(yearMonth));
    }

    // 일자별 접속자 수
    @GetMapping(value = "/access/day/{yearMonthDay}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearMonthDayCountDto> getYearMonthDayLoginCount(@PathVariable("yearMonthDay") String yearMonthDay){
        return ResponseEntity.ok(statisticService.getYearMonthDayLogins(yearMonthDay));
    }

    // 하루 평균 접속자 수
    @GetMapping(value = "/access/avg/{startDate}/{endDate}", produces = "application/json")
    public ResponseEntity<AvgDailyUsersInPeriodDto> getAvgDailyUsersInPeriod(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        return ResponseEntity.ok(statisticService.getAvgDailyUsersInPeriodLogins(startDate, endDate));
    }

    // 휴일을 제외한 로그인 수
    @GetMapping(value = "/login/noHolidays/{startDate}/{endDate}", produces = "application/json")
    public ResponseEntity<BusinessUsersInPeriodDto> getBusinessUsersInPeriod(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        return ResponseEntity.ok(statisticService.getBusinessUsersInPeriodLogins(startDate, endDate));
    }

    // 부서별 월별 로그인 수
    @GetMapping(value = "/login/department/{yearMonth}", produces = "application/json")
    public ResponseEntity<List<DepartmentMonthDto>> getDepartmentMonth(@PathVariable("yearMonth") String yearMonth){
        return ResponseEntity.ok(statisticService.getDepartmentMonthLogins(yearMonth));
    }


}