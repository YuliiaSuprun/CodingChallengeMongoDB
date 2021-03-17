package main.java;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONConversion {

    private JSONObject oldObj;
    private JSONObject newObj;

    public JSONConversion(String address) {
        this.oldObj = this.readJSON(address);
        this.newObj = new JSONObject();
    }
    public JSONConversion(JSONObject oldJSON) {
        this.oldObj = oldJSON;
        this.newObj = new JSONObject();
    }

    public JSONObject getNewJSON() {
        for (String name : oldObj.keySet()) {
            this.addValues(name, oldObj.get(name));
        }
        return this.newObj;
    }

    public static JSONObject readJSON(String address) {
        try {
            String contents = Files.readString(Paths.get(address));
            JSONObject obj = new JSONObject(contents);
            return obj;
        } catch (IOException e) {
            // Caught exception signifies that an input file is malformed
            e.printStackTrace();
        }
        return null;
    }
    private void addValues (String keyStr, Object ValueObj) {
        if (!(ValueObj instanceof JSONObject)) {
            this.newObj.put(keyStr, ValueObj);
        } else {
            JSONObject childObj = (JSONObject) ValueObj;
            for (String name : childObj.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(keyStr).append(".").append(name);
                this.addValues(sb.toString(), childObj.get(name));
            }
        }
    }
}

