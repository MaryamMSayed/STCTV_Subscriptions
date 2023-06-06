package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    // Load User data from Properties File
    public static Properties country = loadProperties(System.getProperty("user.dir") + "/src/main/java/properties/country.properties");

    public static Properties loadProperties(String path) {
        Properties properties = new Properties();
        // Stream For Reading  property File
        try {
            FileInputStream stream = new FileInputStream(path);
            properties.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found !!! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Not Found !!! " + e.getMessage());
        }

        return properties;

    }

}
