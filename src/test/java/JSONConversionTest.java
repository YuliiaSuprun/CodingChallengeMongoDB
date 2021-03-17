package test.java;

import main.java.JSONConversion;
import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for the JSONConversion class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JSONConversionTest {

    /**
     * Tests the conversion of the provided instance of JSONObject.
     */
    @Test
    @Order(0)
    void testSample1() {
        //TODO: change the given addresses to the absolute addresses on the local machine.
        JSONObject refObj = JSONConversion.readJSON(
            "/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/reference1"
                + ".json");
        JSONConversion conversion = new JSONConversion(
            "/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/sample1"
                + ".json");
        assertEquals(refObj.toString(), conversion.getNewJSON().toString());
    }

    /**
     * Tests the conversion of more nested instance of JSONObject.
     */
    @Test
    @Order(1)
    void testSample2() {
        //TODO: change the given addresses to the absolute addresses on the local machine.
        JSONObject refObj = JSONConversion.readJSON(
            "/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/reference2"
                + ".json");
        JSONConversion conversion = new JSONConversion(
            "/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/sample2"
                + ".json");
        assertEquals(refObj.toString(), conversion.getNewJSON().toString());
    }

    /**
     * Tests the conversion of an instance of JSONObject that contains a single value but
     * a long "key path".
     */
    @Test
    @Order(3)
    void testSample3() {
        //TODO: change the given addresses to the absolute addresses on the local machine.
        JSONObject refObj = JSONConversion.readJSON(
            "/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/reference3"
                + ".json");
        JSONConversion conversion = new JSONConversion(
            "/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/sample3"
                + ".json");
        assertEquals(refObj.toString(), conversion.getNewJSON().toString());
    }

}
