package com.everis.example.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {
	
	private String input;
    private String output;

    public ParameterizedTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameters
    public static Collection<String[]> testConditions() {
        String[][] expectedOutputs = { {"Input1", "Input1--->processed!"}, {"Input2", "Input2--->processed!"} };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testDoWhatever() {
    	DummyClass dummyClass= new DummyClass();
        assertEquals(output, dummyClass.doSomething(input));
    } 
}
