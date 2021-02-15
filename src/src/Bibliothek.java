import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bibliothek {
    private List<Book> bookList;

    public Bibliothek() {
        bookList = new ArrayList<>();
        readFromTextFile();
    }

    public void readFromTextFile(){
        try{
            File textFile = new File("E:\\Info\\Anul2\\Programare\\Milosteanu_Andrei_RES_Aufgabe_1\\bibliothek.txt");
            Scanner myReader = new Scanner(textFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] entries = data.split("&");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
                Book b = new Book(entries[0],entries[1],LocalDate.parse(entries[2],formatter),Integer.parseInt(entries[3]),Integer.parseInt(entries[4]));
                bookList.add(b);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void printBooks(){
        for(Book b:bookList)
            System.out.println(b);
    }
    public List<Book> sortName(){
        bookList.sort(Comparator.comparing(Book::getName).reversed());
        return bookList;
    }
}
