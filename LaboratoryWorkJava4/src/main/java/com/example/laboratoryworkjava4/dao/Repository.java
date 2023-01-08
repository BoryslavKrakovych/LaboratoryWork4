package com.example.laboratoryworkjava4.dao;

import com.example.laboratoryworkjava4.dto.GreatestCommonDivisiorRequest;
import com.example.laboratoryworkjava4.model.GreatestCommonDivisiorResult;
import com.example.laboratoryworkjava4.service.GreatestCommonDivisiorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class Repository{

    private static final Map<Integer, GreatestCommonDivisiorResult> storage = new HashMap<>();




    public static GreatestCommonDivisiorResult getResponse(Integer Id) {
        return storage.get(Id);
    }



    public void saveFile(GreatestCommonDivisiorResult response) {
        final int index = storage.keySet().stream().mapToInt(x -> x).max().orElse(-1) + 1;

        response.ID(index);
        ObjectMapper mapper = new ObjectMapper();
        File file= new File("results" + response.getID() + ".json");
        try {

            String json = mapper.writeValueAsString(response);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(json);
            bufferedWriter.write('\n');
            bufferedWriter.flush();
        } catch (
                IOException e) {
            throw new RuntimeException(e);

        }
        storage.put(index, response);
    }

}
