package com.demo.comentoStatistic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YearMonthDayCountDto {
    private String yearMonthDay;  // "2025-09-19"
    private long count;   // 고유 사용자 수
}
