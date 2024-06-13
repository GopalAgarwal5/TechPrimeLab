package com.techprimelab.project.dto;

import lombok.*;

//@Data
@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class DepartmentCount {
    private String department;
    private Number closerCount;
    private Number totalCount;

    public DepartmentCount(String department, Long closerCount, Long totalCount) {
        this.department = department;
        this.closerCount = closerCount;
        this.totalCount = totalCount;
    }

    public DepartmentCount() {
    }
}
