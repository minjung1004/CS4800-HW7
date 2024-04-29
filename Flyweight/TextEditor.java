package Flyweight;
import java.io.*;


public class TextEditor {
    public static void main(String[] args){

        String[] fonts = {"Arial", "Calibri", "Verdana"};
        String[] colors = {"Red", "Blue", "Black"};
        int[] sizes = {12, 14,16};

        for (int i = 0; i < 4; i++) {
            Document document = new Document();

            // Read input file, modify characters, and append to document
            try (BufferedReader reader = new BufferedReader(new FileReader("Flyweight/input.txt"))) {
                int fontIndex = 0;
                int colorIndex = 0;
                int sizeIndex = 0;

                int character;
                while ((character = reader.read()) != -1) {
                    char c = (char) character;
                    String font = fonts[fontIndex];
                    String color = colors[colorIndex];
                    int size = sizes[sizeIndex];

                    // Append character to document with flyweight character properties
                    document.appendCharacter(c, font, color, size);

                    // Move to the next font, color, and size for the next character
                    fontIndex = (fontIndex + 1) % fonts.length;
                    colorIndex = (colorIndex + 1) % colors.length;
                    sizeIndex = (sizeIndex + 1) % sizes.length;
                }

                // Save the document to a file
                String outputFileName = "Flyweight/output" + (i + 1) + ".txt";
                document.saveToFile(outputFileName);
                System.out.println("Output file " + outputFileName + " generated successfully.");
            } catch (IOException e) {
                System.err.println("Error processing iteration " + (i + 1) + ": " + e.getMessage());
            }
        }
    }
}
