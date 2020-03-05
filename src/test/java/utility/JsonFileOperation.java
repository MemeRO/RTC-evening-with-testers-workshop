package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonFileOperation {

    private static String readJsonFromFile(String jsonFileName) {
        String myJSONData = null;
        try {
            FileInputStream fin = new FileInputStream(new File(System.getProperty("user.dir") + "//src//test//resources//testData//" + jsonFileName));
            InputStreamReader in = new InputStreamReader(fin);
            BufferedReader bufferedReader = new BufferedReader(in);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            myJSONData = sb.toString();

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myJSONData;
    }

    private static JsonObject transformStringIntoObject(String myString) {
        JsonParser parser = new com.google.gson.JsonParser();
        return (JsonObject) parser.parse(myString);
    }

    public static JsonObject getData(String jsonName) {
        String myJson = JsonFileOperation.readJsonFromFile(jsonName);
        return JsonFileOperation.transformStringIntoObject(myJson);
    }
}
