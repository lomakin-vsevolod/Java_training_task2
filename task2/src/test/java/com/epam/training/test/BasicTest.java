package com.epam.training.test;

import com.epam.training.util.TextFileReader;
import org.testng.annotations.BeforeMethod;
import parser.PatternTextParser;

public abstract class BasicTest {

    protected TextFileReader textFileReader;
    protected PatternTextParser patternTextParser;

    @BeforeMethod
    protected void getFileReader(){
        textFileReader = new TextFileReader();
        patternTextParser = new PatternTextParser();
    }

    protected String readTextFromFile(String fileName){
        return textFileReader.readTextFromFile(fileName);
    }
}
