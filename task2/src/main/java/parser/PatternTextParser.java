package parser;

import model.CompositeElement;
import model.LeafElement;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTextParser implements ITextParser {

    private Logger logger = Logger.getLogger(PatternTextParser.class);

    public PatternTextParser() {
    }

    @Override
    public CompositeElement parse(String text) {
        CompositeElement wholeText = new CompositeElement();
        wholeText = parseToParagraph(wholeText,text);

        return wholeText;
    }

    @Override
    public CompositeElement parseToParagraph(CompositeElement wholeText, String text) {
        logger.debug("parseToParagraph:");
        CompositeElement paragraphList = new CompositeElement();
        Pattern paragraphPattern = Pattern.compile(REGEX_PARAGRAPH_WITH_LISTING);
        LeafElement paragraphLeaf = null;
        String paragraph;

        Matcher matcher = paragraphPattern.matcher(text);
        while (matcher.find()){
            paragraph=matcher.group();
            if (Pattern.matches(REGEX_LISTING,paragraph)){
                paragraphLeaf = new LeafElement(paragraph);
                logger.debug("Paragraph listing:"+paragraphLeaf.toString());
                paragraphList.addElement(paragraphLeaf);
            } else {
                logger.debug("Paragraph:"+paragraph);
                paragraphList=parseToSentence(paragraphList,paragraph);
                logger.debug("Paragraph end:"+paragraph);
                //paragraphLeaf = new LeafElement(paragraph);
                //paragraphList.addElement(paragraphLeaf);
            }
        }
        wholeText.addElement(paragraphList);
        return wholeText;
    }

    @Override
    public CompositeElement parseToSentence(CompositeElement paragraphList, String paragraph) {
        logger.debug("parseToSentence:");
        CompositeElement sentenceList = new CompositeElement();
        Pattern sentencePattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = sentencePattern.matcher(paragraph);
        //LeafElement sentenceLeaf = null;
        String sentence;
        while (matcher.find()){
            sentence=matcher.group();
            logger.debug("Sentence:"+sentence);
            sentenceList=parseToWord(sentenceList,sentence);
            //sentenceLeaf = new LeafElement(sentence);
            //sentenceList.addElement(sentenceLeaf);
        }
        paragraphList.addElement(sentenceList);
        return paragraphList;
    }

    @Override
    public CompositeElement parseToWord(CompositeElement sentenceList, String sentence) {
        logger.debug("parseToWord:");
        CompositeElement wordList = new CompositeElement();
        Pattern wordPattern = Pattern.compile(REGEX_WORD);
        Matcher matcher = wordPattern.matcher(sentence);
        //LeafElement wordLeaf = null;
        String word;
        while (matcher.find()){
            word=matcher.group();
            logger.debug("Word:"+word);
            wordList=parseToWordAndSign(wordList,word);
            //wordLeaf = new LeafElement(word);
            //wordList.addElement(wordLeaf);
        }
        sentenceList.addElement(wordList);
        return sentenceList;
    }

    @Override
    public CompositeElement parseToWordAndSign(CompositeElement wordList, String word) {
        logger.debug("parseToWordAndSign");
        CompositeElement wordAndSignList = new CompositeElement();
        Pattern wordAndSignPattern = Pattern.compile(REGEX_WORD_AND_SIGN);
        Matcher matcher = wordAndSignPattern.matcher(word);
        //LeafElement wordAndSignLeaf = null;
        String wordAndSign;
        while (matcher.find()){
            wordAndSign=matcher.group();
            wordAndSignList=parseToSymbol(wordAndSignList,wordAndSign);
            //wordAndSignLeaf= new LeafElement(wordAndSign);
            //wordAndSignList.addElement(wordAndSignLeaf);
        }
        wordList.addElement(wordAndSignList);
        return wordList;
    }

    @Override
    public CompositeElement parseToSymbol(CompositeElement wordAndSignList, String wordAndSign) {
        CompositeElement symbolList = new CompositeElement();
        Pattern symbolPattern = Pattern.compile(REGEX_SYMBOL);
        Matcher matcher = symbolPattern.matcher(wordAndSign);
        LeafElement symbolLeaf = null;
        String symbol;
        while (matcher.find()){
            symbol=matcher.group();
            symbolLeaf = new LeafElement(symbol);
            symbolList.addElement(symbolLeaf);
        }
        wordAndSignList.addElement(symbolList);
        return wordAndSignList;
    }
}
