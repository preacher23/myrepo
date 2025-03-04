package com.dailycodebuffer.apigateway.controller;

import com.dailycodebuffer.apigateway.model.Aunthenicateresponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/authenicate")
public class Aunthenicationcontroller {

    @GetMapping("/login")
    public ResponseEntity<Aunthenicateresponse> login(
            @AuthenticationPrincipal OidcUser oidcUser,
            Model model,
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient oAuth2AuthorizedClient
    ) {
        Aunthenicateresponse aunthenicateresponse = Aunthenicateresponse.builder().
                userid(oidcUser.getEmail()).accesstoken(oAuth2AuthorizedClient.getAccessToken().getTokenValue())
                .refreshtoken(oAuth2AuthorizedClient.getRefreshToken().getTokenValue())
                .expiresat(oAuth2AuthorizedClient.getAccessToken().getExpiresAt().getEpochSecond())
                .authoritylist(oidcUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())).

                build();
            return new ResponseEntity<>(aunthenicateresponse, HttpStatus.OK);
    }
}
