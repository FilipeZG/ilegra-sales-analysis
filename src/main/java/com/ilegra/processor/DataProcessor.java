package com.ilegra.processor;

import com.ilegra.domain.DataType;
import com.ilegra.model.Data;
import com.ilegra.model.ResultData;
import com.ilegra.model.Sale;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ilegra.domain.DataType.*;

public class DataProcessor {

    public ResultData processFile(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            Map<DataType, List<Data>> parserResult = lines.filter(StringUtils::isNotBlank)
                                                          .map(this::parseData)
                                                          .collect(Collectors.groupingBy(Data::getDataType));

            return processResultData(parserResult);
        }
    }

    private ResultData processResultData(Map<DataType, List<Data>> parserResult) {
        Integer clientAmount = parserResult.containsKey(CLIENT) ? parserResult.get(CLIENT).size() : 0;
        Integer salesmanAmount = parserResult.containsKey(SALESMAN) ? parserResult.get(SALESMAN).size() : 0;
        Sale sale = parserResult.containsKey(SALE) ? mostExpensiveSale(parserResult.get(SALE)) : null;
        String worstSalesman = parserResult.containsKey(SALE) ? getWorstSalesman(parserResult.get(SALE)) : null;

        return new ResultData(sale, worstSalesman, clientAmount, salesmanAmount);
    }

    private String getWorstSalesman(List<Data> salesman) {
        return salesman.stream()
                       .map(s -> (Sale) s)
                       .collect(Collectors.groupingBy(Sale::getSalesmanName,
                                                      Collectors.reducing(BigDecimal.ZERO, Sale::getPrice, BigDecimal::add)))
                       .entrySet().stream()
                                  .min(Map.Entry.comparingByValue())
                                  .get()
                                  .getKey();
    }

    private Sale mostExpensiveSale(List<Data> sales) {
        return sales.stream()
                    .map(sale -> (Sale) sale)
                    .max(Comparator.comparing(Sale::getPrice))
                    .get();
    }

    private Data parseData(String line) {
        return DataType.dateTypeOf(line.substring(0, 3))
                       .getParser()
                       .parse(line.substring(4));
    }

}
