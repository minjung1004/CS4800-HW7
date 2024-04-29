package Flyweight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {
    @Test
    @DisplayName("Test Appending Char")
    public void testAppendCharacter(){
        Document testDocument = new Document();

        testDocument.appendCharacter('A', "Arial", "Red", 12);
        assertEquals("[A:Arial, Red, 12]\n", testDocument.getContent());
    }

    @Test
    @DisplayName("Testinf multiple times with different properties")
    public void testAppendCharacterMultipleTimes() {
        Document testDocument =  new Document();
        testDocument.appendCharacter('B', "Arial", "Blue", 14);
        testDocument.appendCharacter('C', "Calibri", "Black", 16);
        testDocument.appendCharacter('D', "Arial", "Blue", 12);
        testDocument.appendCharacter('E', "Verdana", "Red", 14);

        String expectedContent = "[B:Arial, Blue, 14]\n[C:Calibri, Black, 16]\n[D:Arial, Blue, 12]\n[E:Verdana, Red, 14]\n";
        assertEquals(expectedContent, testDocument.getContent());
    }

}