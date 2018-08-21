package utils;

import java.io.IOException;
import java.util.Properties;

import java.io.InputStream;

public class PropertiesLoader {
    private Properties property;

    private PropertiesLoader() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        property = new Properties();
        try {
            property.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static final PropertiesLoader INSTANCE = new PropertiesLoader();

    public static PropertiesLoader getInstance() { return INSTANCE; }
    public String getresourceByName(String name) { return property.getProperty(name); }
}
