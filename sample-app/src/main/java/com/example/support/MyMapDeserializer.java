package com.example.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;

public class MyMapDeserializer extends JsonDeserializer<HashMap<String, String>> {

    @Override
    public HashMap<String, String> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {


        ObjectCodec oc = jp.getCodec();
        //can read node like this
//        JsonNode node = oc.readTree(jp);
//        final Long id = node.get("id").asLong();


        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
        };
        return jp.readValueAs(typeRef);
    }

    @Override
    public HashMap<String, String> deserialize(JsonParser p, DeserializationContext ctxt, HashMap<String, String> intoValue) throws IOException,
            JsonProcessingException {

        return super.deserialize(p, ctxt, intoValue);
    }
}
