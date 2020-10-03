package com.ilegra.model;

import com.ilegra.domain.DataType;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void testClientFieldsValues() {
        Client client = new Client("123456", "Paulo", "Rural");

        assertEquals("123456", client.getCnpj());
        assertEquals("Paulo", client.getName());
        assertEquals("Rural", client.getBusinessArea());
    }

    @Test
    public void testNullClientFields() {
        Client client = new Client(null, null, null);

        assertNull(client.getCnpj());
        assertNull(client.getName());
        assertNull(client.getBusinessArea());
    }

    @Test
    public void testNotNullClientFields() {
        Client client = new Client("123456", "Paulo", "Rural");

        assertNotNull(client.getCnpj());
        assertNotNull(client.getName());
        assertNotNull(client.getBusinessArea());
    }

    @Test
    public void testClientDataType() {
        Client client = new Client(null, null, null);
        assertEquals(client.getDataType(), DataType.CLIENT);
    }

}
