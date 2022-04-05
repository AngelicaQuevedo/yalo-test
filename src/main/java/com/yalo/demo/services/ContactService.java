package com.yalo.demo.services;


import com.yalo.demo.entity.PhoneEntity;

import com.yalo.demo.entity.Response;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class ContactService {

    private List<PhoneEntity> getNumbers() {

        final String url = "https://615207624a5f22001701d5da.mockapi.io/phone-search";

        RestTemplate rest = new RestTemplate();

        RestTemplate restTemplate = new RestTemplate();
        List<PhoneEntity> numberList = null;
        try {
            ResponseEntity<List<PhoneEntity>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<PhoneEntity>>() {
                    });
            if (response != null && response.hasBody()) {
                numberList = response.getBody();
            }
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return numberList;
    }


    private Response validateNumber(String id) {

        final String url = "https://615207624a5f22001701d5da.mockapi.io/phone-check/" + id;

        RestTemplate rest = new RestTemplate();

        RestTemplate restTemplate = new RestTemplate();
        Response phoneResponse = null;
        try {
            ResponseEntity<Response> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Response>() {
                    });
            if (response != null && response.hasBody()) {
                phoneResponse = response.getBody();
            }
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
            phoneResponse = new Response("Not found");

        }
        return phoneResponse;
    }


    /*
     * validate if there are matches in the ids and enter another list
     * retun List<PhoneEntity>
     * */
    public List<PhoneEntity> checkNumbers() throws InterruptedException {
        List<PhoneEntity> validatedPhones = new ArrayList<>();
        Response result;

        for (PhoneEntity phone : getNumbers()) {
            result = validateNumber(phone.getId());

            if (!result.getId().equals("Not found")) {
                validatedPhones.add(phone);
            }
            Thread.sleep(2000);
        }
        return validatedPhones;
    }


}






