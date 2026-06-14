package com.bice.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class DataProvider {

    private static final ObjectMapper mapper = new ObjectMapper();

    private DataProvider() {}
    

    // Data provider user
    public static UserData getUser(String key) {
        try {
            InputStream input = DataProvider.class
                .getClassLoader()
                .getResourceAsStream("data/users.json");

            JsonNode root = mapper.readTree(input);
            JsonNode node = root.get(key);

            return mapper.treeToValue(node, UserData.class);

        } catch (Exception e) {
            throw new RuntimeException("No se pudo cargar usuario con key: " + key, e);
        }
    }


    // Data provider customer
    public static Customer getCustomer (String key){
        try{
            InputStream input = DataProvider.class
                .getClassLoader()
                .getResourceAsStream("data/customer.json");
            JsonNode root = mapper.readTree(input);
            JsonNode node = root.get(key);

            return mapper.treeToValue(node, Customer.class);
        }catch (Exception e){
            throw new RuntimeException("No se pudo cargar customer con key: " + key, e);
        }
    }
}
