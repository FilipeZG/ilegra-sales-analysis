package com.ilegra.model;

import com.ilegra.domain.DataType;

import java.math.BigDecimal;
import java.util.List;

public class Sale implements Data {

    private Integer id;
    private String salesmanName;
    private List<SaleItem> items;

    public Sale(Integer id, String salesmanName, List<SaleItem> items) {
        this.id = id;
        this.salesmanName = salesmanName;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public BigDecimal getPrice() {
        return items != null ? items.stream()
                                    .map(SaleItem::getTotalPrice)
                                    .reduce(BigDecimal::add)
                                    .orElse(BigDecimal.ZERO) : null;
    }

    @Override
    public DataType getDataType() {
        return DataType.SALE;
    }
}
