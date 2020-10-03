package com.ilegra.parser;

import com.ilegra.model.Sale;
import com.ilegra.model.SaleItem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SaleParser implements DataParser<Sale> {

    @Override
    public Sale parse(String unparsedData) {
        String[] data = split(unparsedData);

        validate(data, 3, Sale.class);

        Integer id = Integer.parseInt(data[0]);
        String salesmanName = data[2];

        return new Sale(id, salesmanName, parseSaleItems(data[1]));
    }

    private List<SaleItem> parseSaleItems(String rawData) {
        String[] unparsedItems = rawData.substring(1, rawData.length() - 1).split(",");
        return Stream.of(unparsedItems)
                     .map(item -> new SaleItemParser().parse(item))
                     .collect(Collectors.toList());
    }

}
