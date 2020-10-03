package com.ilegra.domain;

import com.ilegra.parser.ClientParser;
import com.ilegra.parser.DataParser;
import com.ilegra.parser.SaleParser;
import com.ilegra.parser.SalesmanParser;

import java.util.stream.Stream;

public enum DataType {

    SALESMAN("001") {

        @Override
        public DataParser getParser() {
            return new SalesmanParser();
        }

    },
    CLIENT("002") {

        @Override
        public DataParser getParser() {
            return new ClientParser();
        }

    },
    SALE("003") {

        @Override
        public DataParser getParser() {
            return new SaleParser();
        }

    };

    private String id;

    DataType(String id) {
        this.id = id;
    }

    public static DataType dateTypeOf(String id) {
        DataType type = Stream.of(DataType.values())
                                          .filter(mt -> mt.id.equals(id))
                                          .findFirst()
                                          .orElse(null);

        if (type == null)
            throw new RuntimeException(String.format("Type with id %s does not exists", id));

        return type;
    }

    public abstract DataParser getParser();

}
