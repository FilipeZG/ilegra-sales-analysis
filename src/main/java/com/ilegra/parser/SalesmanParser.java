package com.ilegra.parser;

import com.ilegra.model.Salesman;
import java.math.BigDecimal;

public class SalesmanParser implements DataParser<Salesman> {

    @Override
    public Salesman parse(String unparsedData) {
        String[] data = split(unparsedData);

        validate(data, 3, Salesman.class);

        String cpf = data[0];
        String name = data[1];
        BigDecimal salary = new BigDecimal(data[2]);

        return new Salesman(cpf, name, salary);
    }

}
