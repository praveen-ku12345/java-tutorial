import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomBufferedReader {
    public static void main(String[] args) {
        // Replace "important1.txt" with the actual name of your text file.
        String fileName = "iccv.txt";
        String filePath = "C:\\Certificate\\" + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int lineLength = line.length();
                System.out.println("Line: " + line + ", Length: " + lineLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
