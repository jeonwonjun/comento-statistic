package com.demo.comentoStatistic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvgDailyUsersInPeriodDto {
    private String startDate; // "2025-09-01"
    private String endDate;   // "2025-09-30"
    private Double average;     // floor(합/일수)
}
