package com.ilegra.parser;

import com.ilegra.model.Salesman;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SalesmanParserTest {

    private SalesmanParser parser;

    @Before
    public void init() {
        parser = new SalesmanParser();
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDataFormat() {
        parser.parse("3245678865434çPaulo");
    }

    @Test()
    public void testValidDataFormat() {
        Salesman salesman = parser.parse("3245678865434çPauloç40000.99");
        assertEquals("3245678865434", salesman.getCpf());
        assertEquals("Paulo", salesman.getName());
        assertEquals(new BigDecimal("40000.99"), salesman.getSalary());
    }

}
