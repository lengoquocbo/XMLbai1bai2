import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Folder {
    public Folder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn thư mục: ");
        String path = scanner.nextLine();
        File directory = new File(path);
        
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("true");
            System.out.println("Tên thư mục: " + directory.getName());
            System.out.println("Dung lượng: " + directory.length() + " byte");
            createXML(directory);
        } else {
            System.out.println("Thư mục không tồn tại hoặc không hợp lệ.");
        }
    }

    private void createXML(File directory) {
        try {
            FileWriter writer = new FileWriter("output.xml");
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<" + directory.getName() + ">\n");
            listFilesAndDirectories(directory, writer);
            writer.write("</" + directory.getName() + ">");
            writer.close();
            System.out.println("Đã tạo file XML thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listFilesAndDirectories(File directory, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    writer.write("<" + file.getName() + ">\n");
                    listFilesAndDirectories(file, writer);
                    writer.write("</" + file.getName() + ">\n");
                } else {
                    writer.write("<file>" + file.getName() + "</file>\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Folder();
    }
}
