package com.ilegra.model;

import com.ilegra.domain.DataType;

import java.math.BigDecimal;

public class Salesman implements Data {

    private String cpf;
    private String name;
    private BigDecimal salary;

    public Salesman(String cpf, String name, BigDecimal salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public DataType getDataType() {
        return DataType.SALESMAN;
    }
}
