package com.ilegra.parser;

import com.ilegra.model.Client;

public class ClientParser implements DataParser<Client> {

    @Override
    public Client parse(String unparsedData) {
        String[] data = split(unparsedData);

        validate(data, 3, Client.class);

        String cnpj = data[0];
        String name = data[1];
        String businessArea = data[2];

        return new Client(cnpj, name, businessArea);
    }
}
