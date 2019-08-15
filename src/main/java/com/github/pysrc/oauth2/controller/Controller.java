package com.github.pysrc.oauth2.controller;


import com.github.pysrc.oauth2.dto.OAuthDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class Controller {
    @Value("${security.oauth2.client.client-id}")
    String clientId;
    @Value("${security.oauth2.client.client-secret}")
    String secret;
    @Value("${security.oauth2.client.access-token-uri}")
    String tokenUrl;
    @Value("${server.port}")
    Integer port;


    @GetMapping("/recv")
    String[] recv(String code) {
        RestTemplate template = new RestTemplate();
        String url = tokenUrl+"?client_id=" + clientId + "&grant_type=authorization_code&grant_type=authorization_code&client_secret=" + secret + "&code=" + code;
        OAuthDto dto = template.postForObject(url, null, OAuthDto.class);
        String baseUrl = "http://127.0.0.1:"+port.toString()+"%s?access_token="+dto.getAccess_token();
        String[] urls = new String[]{
                String.format(baseUrl,"/view/666"),
                String.format(baseUrl,"/insert/666"),
                String.format(baseUrl,"/update/666"),
                String.format(baseUrl,"/delete/666")

        };
        return urls;
    }

    @GetMapping("/view/{id}")
    String view(@PathVariable("id") Long id) {
        return "view: " + id;
    }

    @GetMapping("/insert/{id}")
    String insert(@PathVariable("id") Long id) {
        return "insert: " + id;
    }

    @GetMapping("/update/{id}")
    String update(@PathVariable("id") Long id) {
        return "update: " + id;
    }

    @GetMapping("/delete/{id}")
    String delete(@PathVariable("id") Long id) {
        return "delete: " + id;
    }

}
