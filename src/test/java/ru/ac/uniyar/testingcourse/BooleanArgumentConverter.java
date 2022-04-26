package ru.ac.uniyar.testingcourse;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.TypedArgumentConverter;

public class BooleanArgumentConverter extends TypedArgumentConverter<String, Boolean> {

    protected BooleanArgumentConverter() {
        super(String.class, Boolean.class);
    }

    protected Boolean convert(String str) {
        switch (str) {
            case "on":
            case "yes":
                return true;
            case "off":
            case "no":
                return false;
            default: throw new ArgumentConversionException(String.format("%s", str));
        }
    }
}
