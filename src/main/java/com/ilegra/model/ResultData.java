package com.ilegra.model;

public class ResultData {

    private Sale sale;
    private String worstSalesman;
    private Integer clientAmount;
    private Integer salesmanAmount;

    public ResultData(Sale sale, String worstSalesman, Integer clientAmount, Integer salesmanAmount) {
        this.sale = sale;
        this.worstSalesman = worstSalesman;
        this.clientAmount = clientAmount;
        this.salesmanAmount = salesmanAmount;
    }

    public String getSaleId() {
        return sale != null ? sale.getId().toString() : "Undefined";
    }

    public String getWorstSalesman() {
        return worstSalesman != null ? worstSalesman : "Undefined";
    }

    public Integer getClientAmount() {
        return clientAmount;
    }

    public Integer getSalesmanAmount() {
        return salesmanAmount;
    }

}
