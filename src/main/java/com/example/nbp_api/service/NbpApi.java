package com.example.nbp_api.service;


import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.reactive.function.client.WebClient;


import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

public class NbpApi {

    static public String GetFromURl(String url) {

        WebClient.Builder builder = WebClient.builder();

        return builder.build().get().uri(url).retrieve().bodyToMono(String.class).block();
    }

}
