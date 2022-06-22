package dataProvider;

import java.io.InputStream;
import java.util.Properties;

public class propertyFileReader {

    public static Properties objectRepositoryGet(String propertyFilePath, String propertyFileName) {
        try {
            InputStream stream;
            stream = ClassLoader.getSystemResourceAsStream(propertyFilePath + propertyFileName + ".properties");
            Properties properties = new Properties();
            properties.load(stream);
            return properties;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
