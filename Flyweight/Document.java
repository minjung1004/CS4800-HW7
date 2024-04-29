package Flyweight;
import java.io.*;

class Document {
    private StringBuilder content = new StringBuilder();
    private TextFactory textFactory = new TextFactory();

    public void appendCharacter(char c, String font, String color, int size) {
        TextProperties properties = textFactory.getTextProperties(font, color, size);
        content.append("[").append(c).append(":").append(properties.getFont()).append(", ")
                .append(properties.getColor()).append(", ").append(properties.getSize()).append("]\n");
    }

    public void saveToFile(String filename) throws IOException{
        try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            writer.println(content.toString());
        }
    }

}