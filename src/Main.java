import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeFile(String path, List<Book> books) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("truyen kieu", "Nguyen Du", 60000, 50));
       books.add(new Book("lao hac", "Nam Cao", 80000, 50));
       books.add(new Book("truyen cuoi","tg",30000,20));
       writeFile("luong.txt",books);
        List<Book> employeeDataFromFile = readDataFromFile("luong.txt");
        for (Book e : employeeDataFromFile
        ) {
            System.out.println(e);
        }

    }

    //phuong thuc doc file
    public static List<Book> readDataFromFile(String path) {
        List<Book> books = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            books = (List<Book>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}