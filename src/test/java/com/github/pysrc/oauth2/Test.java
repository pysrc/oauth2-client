package com.github.pysrc.oauth2;


import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class Test {
    public static void main(String[] args){
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> exchange = template.exchange("http://localhost:8080/oauth/token?client_id=client&grant_type=authorization_code&grant_type=authorization_code&code=jMQ9q8&client_secret=secret", HttpMethod.POST, null, String.class);
        System.out.println(exchange.getBody());
    }
}
