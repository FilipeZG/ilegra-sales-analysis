package com.ilegra.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SaleItemTest {

    @Test
    public void testSaleItemFieldsValues() {
        SaleItem item = new SaleItem(1, 1, BigDecimal.ONE);
        assertEquals(1, item.getId().intValue());
        assertEquals(1, item.getQuantity().intValue());
        assertEquals( BigDecimal.ONE, item.getPrice());
    }

    @Test
    public void testNullSaleItemFields() {
        SaleItem item = new SaleItem(null, null, null);
        assertNull(item.getId());
        assertNull(item.getQuantity());
        assertNull(item.getPrice());
    }

    @Test
    public void testNotNullSaleItemFields() {
        SaleItem item = new SaleItem(1, 1, BigDecimal.ONE);
        assertNotNull(item.getId());
        assertNotNull(item.getQuantity());
        assertNotNull(item.getPrice());
    }

    @Test
    public void testSaleItemTotalPrice() {
        SaleItem item = new SaleItem(1, 10, BigDecimal.TEN);
        assertEquals(new BigDecimal(100), item.getTotalPrice());
    }

}
