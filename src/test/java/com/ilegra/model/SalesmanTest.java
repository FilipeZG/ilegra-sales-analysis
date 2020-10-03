package com.ilegra.model;

import com.ilegra.domain.DataType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SalesmanTest {

    @Test
    public void testSalesmanFieldsValues() {
        Salesman salesman = new Salesman("123456", "Julio", new BigDecimal(450.50));

        assertEquals("123456", salesman.getCpf());
        assertEquals("Julio", salesman.getName());
        assertEquals(new BigDecimal(450.50), salesman.getSalary());
    }

    @Test
    public void testNullSalesmanFields() {
        Salesman salesman = new Salesman(null, null, null);

        assertNull(salesman.getCpf());
        assertNull(salesman.getName());
        assertNull(salesman.getSalary());
    }

    @Test
    public void testNotNullSalesmanFields() {
        Salesman salesman = new Salesman("123456", "Paulo", new BigDecimal(450.50));

        assertNotNull(salesman.getCpf());
        assertNotNull(salesman.getName());
        assertNotNull(salesman.getSalary());
    }

    @Test
    public void testSalesmanDataType() {
        Salesman salesman = new Salesman(null, null, null);
        assertEquals(salesman.getDataType(), DataType.SALESMAN);
    }

}
