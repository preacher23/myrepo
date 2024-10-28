package com.dailycodebuffer.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aunthenicateresponse {
    private String userid;
    private String accesstoken;
    private String refreshtoken;
    private Long expiresat;
    private Collection<String> authoritylist;
}
