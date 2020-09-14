package com.xqcao.practice.apollo.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class DictionaryConfig {
    public static final String DICTIONARY_TEST = "com.practice.dictionary.test";
    private final TypeReference<HashMap<String, Object>> typeRef = new TypeReference<>() {
    };
    private ObjectMapper objectMapper = new ObjectMapper();

    private Map<String, Object> dictionary;

    @ApolloConfig("dictionary")
    private Config dictConfig;

    @ApolloConfigChangeListener("dictionary")
    private void anotherOnChange(ConfigChangeEvent changeEvent) {
        if (changeEvent.isChanged(DICTIONARY_TEST)) {
            dictionary = stringToMap(changeEvent.getChange(DICTIONARY_TEST).getNewValue());
        }
    }

    public Map<String, Object> getDictionary() {
        if (Objects.isNull(dictionary)) {
            dictionary = stringToMap(dictConfig.getProperty(DICTIONARY_TEST, "{}"));
        }
        return dictionary;
    }

    private Map<String, Object> stringToMap(String newValue) {
        try {
            return objectMapper.readValue(newValue, typeRef);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new HashMap<>(0);
    }
}
