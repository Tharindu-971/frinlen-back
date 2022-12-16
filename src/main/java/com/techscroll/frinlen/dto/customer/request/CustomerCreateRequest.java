package com.techscroll.frinlen.dto.customer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCreateRequest {
    private String name;
    private String mobile;
    private String email;
    private String vatNo;
    private boolean isActive;
    private String address1;
    private String address2;
    private Long agentId;
}
