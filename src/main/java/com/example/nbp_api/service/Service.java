package com.example.nbp_api.service;


import org.json.JSONArray;
import org.json.JSONObject;

import static java.lang.Math.abs;

public class Service {

    static public String AvgExchange(String code, String date){
        double exchange = Double.parseDouble(new JSONObject(NbpApi.GetFromURl("https://api.nbp.pl/api/exchangerates/rates/A/" + code + "/" + date + "/")).getJSONArray("rates").getJSONObject(0).get("mid").toString());
        return "{\"exchange\":" + exchange + "}";

    }

    static public String MinMaxExchange(String code, int n){

        JSONArray rates = new JSONObject(NbpApi.GetFromURl("https://api.nbp.pl/api/exchangerates/rates/A/"+code+"/last/"+n)).getJSONArray("rates");


        double rate, min = Double.parseDouble(rates.getJSONObject(0).get("mid").toString()), max =  Double.parseDouble(rates.getJSONObject(0).get("mid").toString());

        for(int i=1; i<rates.length(); i++){

            rate = Double.parseDouble(rates.getJSONObject(i).get("mid").toString());

            if(rate>max)max = rate;
            if(rate<min)min = rate;

        }

        return "{\"min\":"+min+", \"max\":"+max+"}";

    }

    static public String DifferenceBuyAsk(String code, int n){

        JSONArray rates = new JSONObject(NbpApi.GetFromURl("https://api.nbp.pl/api/exchangerates/rates/C/"+code+"/last/"+n)).getJSONArray("rates");

        double dif, maxDif = abs(Double.parseDouble(rates.getJSONObject(0).get("bid").toString())-Double.parseDouble(rates.getJSONObject(0).get("ask").toString()));

        for(int i=1; i<rates.length(); i++){

            dif = abs(Double.parseDouble(rates.getJSONObject(i).get("bid").toString())-Double.parseDouble(rates.getJSONObject(i).get("ask").toString()));

            if(dif>maxDif)maxDif = dif;

        }

        return "{\"dif\":"+ maxDif +"}";

    }


}
