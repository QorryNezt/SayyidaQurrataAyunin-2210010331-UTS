import java.io.*;
import java.util.ArrayList;
import java.util.List;
// Sayyida Qurrata A'yunin (2210010331)
public class FileUtils {
    private static final String FILE_NAME = "agenda.csv";

    public static List<String[]> readData() {
        List<String[]> data = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    data.add(fields);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void writeData(List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String[] entry : data) {
                bw.write(String.join(",", entry));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendData(String[] entry) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(String.join(",", entry));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
