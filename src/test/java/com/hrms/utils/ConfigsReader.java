package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    static Properties prop;
    public static Properties readProperties(String filePath){

        /**
         * This method read any given property file
         * @param filePath
         * @return Properties
         */
        try
        {
            FileInputStream fis = new FileInputStream(filePath);
            prop=new Properties();
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}
