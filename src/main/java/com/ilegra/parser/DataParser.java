package com.ilegra.parser;

import com.ilegra.model.Data;

public interface DataParser<T extends Data> extends Parser<T> {

    @Override
    T parse(String unparsedData);

}
