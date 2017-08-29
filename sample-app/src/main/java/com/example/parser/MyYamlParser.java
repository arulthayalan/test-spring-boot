package com.example.parser;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.TypeDescription;
import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;
import com.fasterxml.jackson.dataformat.yaml.snakeyaml.constructor.Constructor;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * Created by p711679 on 13/10/2015.
 */
public class MyYamlParser {

    public ListOperation getListObject(String yamlStr) throws IOException {

       /* ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<ParserModel> operations = new ArrayList<>();
        operations = mapper.readValue(yamlStr, new TypeReference<Collection<ParserModel>>() {});
        return operations;
        */

        Constructor constructor = new Constructor(ListOperation.class);
        TypeDescription carDescription = new TypeDescription(ListOperation.class);
        carDescription.putListPropertyType("models", ParserModel.class);
        constructor.addTypeDescription(carDescription);

        Yaml yaml = new Yaml();
       // ListOperation car = (ListOperation) yaml.load(yamlStr);
     //  ListOperation car = (ListOperation) yaml.loadAs(yamlStr, ListOperation.class);

        ListOperation operations = (ListOperation) yaml.loadAs(new ClassPathResource("/ListOperation.yaml").getInputStream(), ListOperation.class);

        for (ParserModel model:operations.getModels()) {
           // System.out.println(model.getName());
        }
        return operations;
    }

    public ParserModel getObject(String yamlStr) throws IOException {
       /* ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ParserModel model = mapper.readValue(yaml, ParserModel.class);
        return model;
        */

        Yaml yaml = new Yaml();
        ParserModel model = yaml.loadAs(yamlStr, ParserModel.class);
        return model;
    }
}
