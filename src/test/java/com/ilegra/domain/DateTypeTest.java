package com.ilegra.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateTypeTest {

    @Test(expected = RuntimeException.class)
    public void testInvalidDataTypeIdError() {
        DataType.dateTypeOf("005");
    }

    @Test()
    public void testValidDataType() {
        DataType dataType = DataType.dateTypeOf("001");
        assertEquals(DataType.SALESMAN, dataType);
    }

}
