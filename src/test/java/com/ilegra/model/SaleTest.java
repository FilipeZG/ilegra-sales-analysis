package com.ilegra.model;

import com.ilegra.domain.DataType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SaleTest {

    @Test
    public void testSaleFieldsValues() {
        Sale sale = new Sale(1, "Paulo", Arrays.asList(new SaleItem(1 , 1, BigDecimal.ONE)));

        assertEquals(1, sale.getId().intValue());
        assertEquals("Paulo", sale.getSalesmanName());
        assertEquals(1, sale.getItems().size());
        assertEquals(BigDecimal.ONE, sale.getPrice());
    }

    @Test
    public void testNullSaleFields() {
        Sale sale = new Sale(null, null, null);

        assertNull(sale.getId());
        assertNull(sale.getSalesmanName());
        assertNull(sale.getItems());
        assertNull(sale.getPrice());
    }

    @Test
    public void testNotNullSaleFields() {
        Sale sale = new Sale(1, "Paulo", Arrays.asList(new SaleItem(1 , 1, BigDecimal.ONE)));

        assertNotNull(sale.getId());
        assertNotNull(sale.getSalesmanName());
        assertNotNull(sale.getItems());
        assertNotNull(sale.getPrice());
    }

    @Test
    public void testSaleDataType() {
        Sale sale = new Sale(null, null, null);
        assertEquals(sale.getDataType(), DataType.SALE);
    }

}
