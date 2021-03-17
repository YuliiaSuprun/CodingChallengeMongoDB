package main.java;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class represents the process of flattening JSONObject.
 */
public class JSONConversion {
    /**
     * The initial JSONObject.
     */
    private final JSONObject oldObj;
    /**
     * The flattened JSONObject.
     */
    private final JSONObject newObj;

    /**
     * Constructor for for a JSONConversion object.
     * Creates JSONObject containing the contents of the given JSON file.
     * Initializes the flattened JSONObject to the empty JSONObject.
     *
     * @param address the absolute filepath of the given JSON file.
     */
    public JSONConversion(String address) {
        this.oldObj = readJSON(address);
        this.newObj = new JSONObject();
    }

    /**
     * Reads the contents of the JSON file and creates the corresponding JSONObject.
     *
     * @param address the absolute filepath of the given JSON file.
     * @return the JSONObject representing the given JSON file.
     * @throws IOException if the operation of reading the contents of file fails.
     */
    public static JSONObject readJSON(String address) {
        try {
            // Read the contents of the file located at given filepath
            String contents = Files.readString(Paths.get(address));
            // Create the corresponding JSONObject
            JSONObject obj = new JSONObject(contents);
            return obj;
        } catch (IOException e) {
            // Caught exception signifies that an input file is malformed
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Converts the given JSON Object.
     *
     * @return the JSONObject representing the flattened JSON Object.
     */
    public JSONObject getNewJSON() {
        // Call the recursive function, which adds the flattened keys to new JSONObject.
        for (String name : oldObj.keySet()) {
            this.addValues(name, oldObj.get(name));
        }
        return this.newObj;
    }

    /**
     * The recursive function that iterates over all keys on a given "layer",
     * appends the corresponding endings to the key names, and adds the key-value pair
     * if the new value doesn't represent JSONObject.
     *
     * @param keyStr   the string representing the appended keys (AKA "key path") to the
     *                 given value
     * @param ValueObj the value at the corresponding "key path".
     */
    private void addValues(String keyStr, Object ValueObj) {
        // Base Case: if the value is not JSONObject
        if (!(ValueObj instanceof JSONObject)) {
            // Add this value to the new JSONObject with a key representing a "key path"
            this.newObj.put(keyStr, ValueObj);
            // Recursive Case: if the value is of type JSONObject
        } else {
            JSONObject childObj = (JSONObject) ValueObj;
            // Keep iterating over all keys, calling recursively addValues()
            for (String name : childObj.keySet()) {
                // Update the "key path" by appending these keys to the given "key path"
                StringBuilder sb = new StringBuilder();
                sb.append(keyStr).append(".").append(name);
                this.addValues(sb.toString(), childObj.get(name));
            }
        }
    }
}

