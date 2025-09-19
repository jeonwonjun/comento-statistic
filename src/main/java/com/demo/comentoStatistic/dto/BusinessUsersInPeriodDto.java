package com.demo.comentoStatistic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessUsersInPeriodDto {
    private String startDate;
    private String endDate;
    private long count;   // 로그인 수(횟수) or 고유 사용자 수
}
