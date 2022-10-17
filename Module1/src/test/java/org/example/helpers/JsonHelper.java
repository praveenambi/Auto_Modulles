package org.example.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JsonHelper {
    @Test
    public void testreadJson()
    {
        System.out.println(getNodeValue("/Application/Amazon/amazonUsername"));
    }

    public static String getNodeValue(String nodeValues) {
        try {
            ObjectNode node = new ObjectMapper().readValue(new File("./src/test/resources/datafiles/amazon_data.json"), ObjectNode.class);
      JsonNode actNode= node.at(nodeValues);
      return actNode.asText();

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
