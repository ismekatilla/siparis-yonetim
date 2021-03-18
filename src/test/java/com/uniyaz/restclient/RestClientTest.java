package com.uniyaz.restclient;

import com.uniyaz.core.domain.Musteri;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by AKARTAL on 17.3.2021.
 */
public class RestClientTest {

    @Test
    public void findAllMusteriFromRest() throws Exception {
        RestClient restClient = new RestClient();
        List<Musteri> musteriList = restClient.findAllMusteriFromRest();
        for (Musteri musteri : musteriList) {
            System.out.println(musteri.getAdi());
        }
    }
}