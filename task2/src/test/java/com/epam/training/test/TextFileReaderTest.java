package com.epam.training.test;

import com.epam.training.util.TextFileConstants;
import com.epam.training.util.TextFileReader;
import model.CompositeElement;
import org.testng.annotations.Test;
import parser.PatternTextParser;

public class TextFileReaderTest {

    @Test
    public void testReadFile(){
        TextFileReader textFileReader = new TextFileReader();
        String test = textFileReader.readTextFromFile(TextFileConstants.TEST);
        CompositeElement wholeText = new CompositeElement();
        PatternTextParser patternTextParser = new PatternTextParser();

        wholeText=patternTextParser.parse(test);
        System.out.println(" ");
        System.out.println(wholeText.toString());

    }

}
