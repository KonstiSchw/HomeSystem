package at.konsti.landania.homesystem.common;



import at.konsti.landania.homesystem.common.mysql.Connection;
import at.konsti.landania.homesystem.spigot.HomeSystem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

public class Config {

    private static File file;

    public static void startConfig(File f) {
        file = new File(f, "config.json");
        try{
            if(file.createNewFile()) createConfig();

        } catch(IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static String read(String key){
        try {
            FileReader reader = new FileReader(file);
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(reader);
            String value = null;
            for (Object o : array) {
                JSONObject obj = (JSONObject) o;

                if((String) obj.get(key) != null){
                    value = (String) obj.get(key);
                }
            }
            return value;

        } catch (IOException | ParseException e) {
            return null;
        }

    }

    private static void createConfig() throws IOException, ParseException {
        JSONObject obj = new JSONObject();

        obj.put("mysql-login", "landania");
        obj.put("mysql-password", "Ln7Q8SfhVYcXUCdg");
        obj.put("mysql-database", "landania");
        obj.put("mysql-server", "konsti.tech");
        obj.put("prefix", "§4[Home] §6");

        JSONArray config = new JSONArray();
        config.add(obj);

        FileWriter writer = new FileWriter(file);
        writer.write(config.toJSONString());
        writer.flush();

    }

}
