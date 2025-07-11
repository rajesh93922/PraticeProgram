package com.javaassignment.collectionassignment;

import com.javaassignment.collectionsassignment.ABCElectronicCompany;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ABCElectronicCompanyTest {

    @Test
    void testMainMethod(){

            String simulatedInput = String.join(System.lineSeparator(),
                    "2",                  // Number of records
                    "Alice:TV",           // Record 1
                    "Bob:Fridge",         // Record 2
                    "TV",                 // Product to search for number of customers
                    "Fridge",             // Product to get customer names
                    "Alice"               // Customer to get product
            ) + System.lineSeparator();

            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;

            ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);

            try {
                System.setIn(inputStream);
                System.setOut(printStream);

                ABCElectronicCompany.main(new String[]{});

                String output = outputStream.toString();
                Assertions.assertNotNull(output);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }
    }

}
