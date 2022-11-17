package com.techscroll.frinlen.dto.invoice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgentCustomerCreateRequestDto {
    private String name;
    private String email;
    private String mobile;
    private String address1;
    private String address2;
    private boolean isStandAlone;
    private String agentName;
    private String agentMobile;
    private String agentEmail;
}
