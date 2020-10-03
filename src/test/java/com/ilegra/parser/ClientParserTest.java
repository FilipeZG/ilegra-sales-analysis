package com.ilegra.parser;

import com.ilegra.model.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientParserTest {

    private ClientParser parser;

    @Before
    public void init() {
        parser = new ClientParser();
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDataFormat() {
        parser.parse("2345675433444345çEduardo Pereira");
    }

    @Test()
    public void testValidDataFormat() {
        Client client = parser.parse("2345675433444345çEduardo PereiraçRural");
        assertEquals("2345675433444345", client.getCnpj());
        assertEquals("Eduardo Pereira", client.getName());
        assertEquals("Rural", client.getBusinessArea());
    }


}
