package com.example.nbp_api.service;

import org.springframework.web.reactive.function.client.WebClient;

public class NbpApi {

    static public String GetFromURl(String url) {

        WebClient.Builder builder = WebClient.builder();

        return builder.build().get().uri(url).retrieve().bodyToMono(String.class).block();
    }

}
