package com.example.validator;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Map;

public class MapSafeHtmlValidator  implements ConstraintValidator<Annotation, Map<String, String>> {

    @Override
    public void initialize(Annotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Map<String, String> value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        boolean valid = true;

       for(Map.Entry<String, String> request: value.entrySet()) {
           if (!Jsoup.isValid(request.getKey(), Whitelist.basic()) || !Jsoup.isValid(request.getValue(), Whitelist.basic())) {
               valid = false;
               break;
           }
       }
        return valid;
    }
}
