package com.epam.training.test;

import com.epam.training.util.TextFileConstants;
import model.CompositeElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.PatternTextParser;

public class PatternTextParserTest extends BasicTest {

    @DataProvider
    public Object[][] dataParseToSymbol() {
        return new Object[][]{{TextFileConstants.SYMBOL_TEST},{TextFileConstants.SYMBOL_TEST2}};
    }

    @Test(dataProvider = "dataParseToSymbol")
    public void testParseToSymbol(String fileName){
        CompositeElement compositeSymbol = new CompositeElement();
        String expectedResult = readTextFromFile(fileName);

        patternTextParser.parseToSymbol(compositeSymbol,expectedResult);

        Assert.assertEquals(compositeSymbol.toString(),expectedResult);
    }

    @DataProvider
    public Object[][] dataParseToWordAndSign() {
        return new Object[][]{{TextFileConstants.SYMBOL_TEST2},{TextFileConstants.SYMBOL_TEST}};
    }

    @Test(dataProvider = "dataParseToWordAndSign")
    public void testParseToWordAndSign(String fileName){
        CompositeElement compositeWordAndSign = new CompositeElement();
        String expectedResult = readTextFromFile(fileName);

        patternTextParser.parseToWordAndSign(compositeWordAndSign,expectedResult);

        Assert.assertEquals(compositeWordAndSign.toString(),expectedResult);
    }

    @DataProvider
    public Object[][] dataParseToWord() {
        return new Object[][]{{TextFileConstants.WORD_TEST},{TextFileConstants.WORD_TEST2}};
    }

    @Test(dataProvider = "dataParseToWord")
    public void testParseToWord(String fileName){
        CompositeElement compositeWord = new CompositeElement();
        String expectedResult = readTextFromFile(fileName);

        patternTextParser.parseToWord(compositeWord,expectedResult);

        Assert.assertEquals(compositeWord.toString(),expectedResult);
    }

    @DataProvider
    public Object[][] dataParseToSentence() {
        return new Object[][]{{TextFileConstants.SENTENCE_TEST},{TextFileConstants.WORD_TEST}};
    }

    @Test(dataProvider = "dataParseToSentence")
    public void testParseToSentence(String fileName){
        CompositeElement compositeSentence = new CompositeElement();
        String expectedResult = readTextFromFile(fileName);

        patternTextParser.parseToSentence(compositeSentence,expectedResult);

        Assert.assertEquals(compositeSentence.toString(),expectedResult);
    }

    @DataProvider
    public Object[][] dataParseToParagraph() {
        return new Object[][]{{TextFileConstants.PARAGRAPH_TEST}};
    }

    @Test(dataProvider = "dataParseToParagraph")
    public void testParseToParagraph(String fileName){
        CompositeElement compositeParagraph = new CompositeElement();
        String expectedResult = readTextFromFile(fileName);

        patternTextParser.parseToParagraph(compositeParagraph,expectedResult);

        Assert.assertEquals(compositeParagraph.toString(),expectedResult);
    }

    @DataProvider
    public Object[][] dataParse() {
        return new Object[][]{{TextFileConstants.PARSE_TEST},{TextFileConstants.TEST}};
    }

    @Test(dataProvider = "dataParse")
    public void testParse(String fileName){
        CompositeElement compositeText;
        String expectedResult = readTextFromFile(fileName);

        compositeText=patternTextParser.parse(expectedResult);

        Assert.assertEquals(compositeText.toString(),expectedResult);
    }

}
