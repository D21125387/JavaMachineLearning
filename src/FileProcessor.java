import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {
    protected File file;
    protected String fileName;

    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    public void open() {
        file = new File(this.fileName);
    }

    public ArrayList<String> read() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(this.file);
            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void write(String text) {
        File file = new File("RolesUsed.txt");
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(text+"\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
