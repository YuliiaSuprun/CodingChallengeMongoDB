package test.java;

import main.java.JSONConversion;

import org.json.JSONObject;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test cases for the BaseSetGenerator class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JSONConversionTest {

    /**
     * Tests exhaustive generation when there is only one argument with one option.
     */
    @Test
    @Order(0)
    void testSample1() {
        JSONObject refObj = JSONConversion.readJSON("/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/reference1.json");
        JSONConversion conversion = new JSONConversion("/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/sample1.json");
        assertEquals(refObj.toString(), conversion.getNewJSON().toString());
    }
    /**
     * Tests exhaustive generation when there is only one argument with one option.
     */
    @Test
    @Order(0)
    void testSample2() {
        JSONObject refObj = JSONConversion.readJSON("/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/reference2.json");
        JSONConversion conversion = new JSONConversion("/Users/yuliiasuprun/IdeaProjects/CodingChallenge/src/test/java/sample2.json");
        assertEquals(refObj.toString(), conversion.getNewJSON().toString());
    }


}
