package com.techprimelab.project.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatusCount {
    private Number totalProject;
    private Number closed;
    private Number running;
    private Number cancelled;
    private Number closureDelay;


}
