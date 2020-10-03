package com.ilegra.model;

import com.ilegra.domain.DataType;

public class Client implements Data {

    private String cnpj;
    private String name;
    private String businessArea;

    public Client(String cnpj, String name, String businessArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    @Override
    public DataType getDataType() {
        return DataType.CLIENT;
    }
}
