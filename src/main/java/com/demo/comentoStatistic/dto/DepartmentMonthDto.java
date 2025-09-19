package com.demo.comentoStatistic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentMonthDto {
    private String yearMonth; // "2025-09"
    private String deptName;
    private long count;       // 로그인 수(횟수)
}
