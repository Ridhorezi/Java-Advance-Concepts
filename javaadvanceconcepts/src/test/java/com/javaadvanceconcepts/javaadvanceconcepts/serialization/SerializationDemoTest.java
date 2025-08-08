package com.javaadvanceconcepts.javaadvanceconcepts.serialization;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SerializationDemoTest {
    
    @Test
    void testSerialization() throws IOException, ClassNotFoundException {
        SerializationDemo.demonstrateSerialization();
        System.out.println("Serialization test completed");
    }
}