package ru.ac.uniyar.testingcourse;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.TypedArgumentConverter;

public class TernarArgumentConverter extends TypedArgumentConverter<String, Ternar> {

    protected TernarArgumentConverter() {
        super(String.class, Ternar.class);
    }

    @Override
    protected Ternar convert(String str) {
        switch (str) {
            case "on": return Ternar.ON;
            case "off": return Ternar.OFF;
            case "blinking": return Ternar.BLINKING;
            default: throw new ArgumentConversionException(String.format("%s error argument", str));
        }
    }
}
