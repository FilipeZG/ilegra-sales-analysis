package com.ilegra.parser;

import com.ilegra.model.SaleItem;

import java.math.BigDecimal;

public class SaleItemParser implements Parser {

    public SaleItem parse(String unparsedData) {
        String[] data = split(unparsedData, "-");

        validate(data, 3, SaleItem.class);

        Integer id = Integer.parseInt(data[0]);
        Integer quantity = Integer.parseInt(data[1]);
        BigDecimal price = new BigDecimal(data[2]);

        return new SaleItem(id, quantity, price);
    }

}
