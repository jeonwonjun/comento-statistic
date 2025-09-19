package com.demo.comentoStatistic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YearCountDto {
    private String year;     // "2025"
    private long count;      // 고유 사용자 수
    // getters/setters
}
