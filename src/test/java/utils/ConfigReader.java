package utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    public static void initializeProperties(){
        try {
            FileReader fileReader = new FileReader("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileReader);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty (String key){
        return properties.getProperty(key);
    }
}
