package utils;

// Import necessary classes for file reading and handling properties files
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    // Declare a static Properties object to store the configuration properties
    private static Properties properties;

    public static void loadProperties(String fileName) {


    // Static block to initialize the properties when the class is first loaded

        try {
            // Create a new Properties object
            properties = new Properties();

            // Open the configFile.properties file from the specified path
            FileInputStream fis = new FileInputStream("src/test/resources/environment/" + fileName);

            // Load the properties from the file into the Properties object
            properties.load(fis);
        } catch (IOException e) {
            // Print the stack trace if there is an I/O error
            e.printStackTrace();

            // Throw a RuntimeException if the properties file cannot be loaded
            throw new RuntimeException("Could not load configFile.properties");
        }
    }

    // Method to retrieve a property value by its key
    public static String getProperty(String key) {
        // Return the value associated with the specified key from the Properties object
        return properties.getProperty(key);
    }
}
