package com.epam.training.test;

import com.epam.training.util.TextFileConstants;
import com.epam.training.util.TextFileReader;
import org.testng.annotations.Test;

public class TextFileReaderTest {

    @Test
    public void testReadFile(){
        TextFileReader textFileReader = new TextFileReader();
        String test = textFileReader.readTextFromFile(TextFileConstants.TEST);
        System.out.println(test);
    }

}
