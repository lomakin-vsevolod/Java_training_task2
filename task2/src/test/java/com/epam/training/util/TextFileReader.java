package com.epam.training.util;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextFileReader {

    private static final Logger logger = Logger.getLogger(TextFileReader.class);

    private static final String FILES_LOCATION = "src\\test\\resources\\";

    public String readTextFromFile(String fileName){
        try {
            InputStream inputStream = new FileInputStream(FILES_LOCATION + fileName);
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            logger.error("File not found exception!");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Throws IOException!");
            e.printStackTrace();
        }
        return null;
    }
}
