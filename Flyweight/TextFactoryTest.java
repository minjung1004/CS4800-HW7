package Flyweight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFactoryTest {
    @Test
    @DisplayName("Test getting text properties")
    public void testGetTextProperties() {
        TextFactory testTextFactory = new TextFactory();
        TextProperties testTextProperties = testTextFactory.getTextProperties("Arial", "Red", 12);

        assertEquals("Arial", testTextProperties.getFont());
        assertEquals("Red", testTextProperties.getColor());
        assertEquals(12, testTextProperties.getSize());
    }

    @Test
    @DisplayName("Test Caches")
    public void testGetTextPropertiesCache() {
        TextFactory testTextFactory = new TextFactory();

        TextProperties testProperties1 = testTextFactory.getTextProperties("Arial", "Red", 12);
        TextProperties testProperties2 = testTextFactory.getTextProperties("Arial", "Red", 12);

        assertSame(testProperties1, testProperties2);
    }

    @Test
    @DisplayName("Testing different properties")
    void testGetTextPropertiesDifferentProperties() {
        TextFactory textFactory = new TextFactory();

        TextProperties textProperties1 = textFactory.getTextProperties("Arial", "Red", 12);
        TextProperties textProperties2 = textFactory.getTextProperties("Arial", "Red", 14);

        assertNotSame(textProperties1, textProperties2);
    }

}