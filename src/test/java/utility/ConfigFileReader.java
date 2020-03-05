package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties = new Properties();
    private static final String PROPERTY_FILE = "src//test//resources//app.properties";

    public ConfigFileReader() {
        try {
            InputStream inputStream = new FileInputStream(PROPERTY_FILE);

            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAppURL() {
        String url = properties.getProperty("URL");
        if (url != null)
            return url;
        else
            throw new RuntimeException("url not specified in the app.properties file.");
    }
}
