package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties proprty = new Properties();

    static {

        String path = "config.properties";

        FileInputStream file;

        {
            try {
                file = new FileInputStream(path);
                proprty.load(file);
                file.close();

            } catch (IOException e) {
                System.out.println("File not found !!");;
            }
        }
    }

    public static String getProprty(String key){
        return  proprty.getProperty(key);
    }
}
