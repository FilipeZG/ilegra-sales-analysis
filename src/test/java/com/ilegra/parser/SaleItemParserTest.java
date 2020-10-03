package com.ilegra.parser;

import com.ilegra.model.SaleItem;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SaleItemParserTest {

    private SaleItemParser parser;

    @Before
    public void init() {
        parser = new SaleItemParser();
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDataFormat() {
        parser.parse("1--100");
    }

    @Test()
    public void testValidDataFormat() {
        SaleItem saleItem = parser.parse("1-10-100");
        assertEquals(1, saleItem.getId().intValue());
        assertEquals(10, saleItem.getQuantity().intValue());
        assertEquals(new BigDecimal(100), saleItem.getPrice());
        assertEquals(new BigDecimal(1000), saleItem.getTotalPrice());
    }

}
