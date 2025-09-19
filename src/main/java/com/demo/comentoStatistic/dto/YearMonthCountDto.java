package com.demo.comentoStatistic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YearMonthCountDto {
    private String yearMonth; // "2025-09"
    private long count;       // 고유 사용자 수
}
