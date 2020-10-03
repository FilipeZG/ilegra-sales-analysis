package com.ilegra.parser;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public interface Parser<T> {

    T parse(String unparsedData);

    default String[] split(String unparsedData) {
        return split(unparsedData, "ç");
    }

    default String[] split(String unparsedData, String separator) {
        return Arrays.stream(unparsedData.split(separator))
                     .map(String::trim)
                     .filter(StringUtils::isNotBlank)
                     .toArray(String[]::new);
    }

    default void validate(String[] data, Integer spectedLength, Class<T> clasz) {
        if (data.length < spectedLength) throw new RuntimeException(String.format("Invalid %s data format", clasz.getSimpleName()));
    }

}
