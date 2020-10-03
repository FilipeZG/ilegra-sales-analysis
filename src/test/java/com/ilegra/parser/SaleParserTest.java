package com.ilegra.parser;

import com.ilegra.model.Sale;
import com.ilegra.model.Salesman;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.StringTokenizer;

import static org.junit.Assert.assertEquals;

public class SaleParserTest {

    private SaleParser parser;

    @Before
    public void init() {
        parser = new SaleParser();
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDataFormat() {
        parser.parse("10ççPedro");
    }

    @Test()
    public void testValidDataFormat() {
        Sale sale = parser.parse("10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
        assertEquals(10, sale.getId().intValue());
        assertEquals("Pedro", sale.getSalesmanName());
        assertEquals(3, sale.getItems().size());
    }

}
