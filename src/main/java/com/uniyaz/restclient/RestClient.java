package com.uniyaz.restclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uniyaz.core.domain.Musteri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

/**
 * Created by AKARTAL on 17.3.2021.
 */
public class RestClient {

    public List<Musteri> findAllMusteriFromRest() {

        String jsonAsStr = "";

        try {

            URL url = new URL("http://localhost:5858/api/musteri/findAll");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            String str;
            while ((str = br.readLine()) != null) {
                jsonAsStr += str;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
        Type musteriListType = new TypeToken<List<Musteri>>() {
        }.getType();
        List<Musteri> musteriList = gson.fromJson(jsonAsStr, musteriListType);
        return musteriList;
    }
}
