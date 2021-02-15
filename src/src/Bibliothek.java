import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    public List<Book> filterAutor(){
        List<Book> aux = new ArrayList<>();
        aux = bookList.stream().filter(n->n.getAutor().startsWith("S")).collect(Collectors.toList());
        aux.sort(Comparator.comparing(Book::getAutor));
        return aux;
    }
    public List<Book> filterBooks(){
        List<Book> aux = new ArrayList<>();
        aux = bookList.stream().filter(n->n.getVerfExemplare()>3).collect(Collectors.toList());
        aux.sort(Comparator.comparing(Book::getEjahr).reversed());
        return aux;
    }
    public void gesamtAnzahl(){
        int sum=0;
        for(Book b:bookList){
            sum+=b.getNrKopien();
        }
        System.out.println("Exista "+sum+" carti in biblioteca");
    }
    public void writeSortedNames(){
            try{
                String filename = "name.txt";
                FileWriter writer = new FileWriter(filename);
                List<Book> aux = new ArrayList<>();
                aux = sortName();
                for(Book b:aux){
                    writer.write(b.getName()+'#'+b.getAutor()+'#'+b.getEjahr()+'#'+b.getNrKopien()+'#'+b.getVerfExemplare()+'\n');
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void writeFilteredAutor(){
        try{
            String filename = "autor.txt";
            FileWriter writer = new FileWriter(filename);
            List<Book> aux = new ArrayList<>();
            aux = filterAutor();
            for(Book b:aux){
                writer.write(b.getName()+'#'+b.getAutor()+'#'+b.getEjahr()+'#'+b.getNrKopien()+'#'+b.getVerfExemplare()+'\n');
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFilteredBooks(){
        try{
            String filename = "exemplare.txt";
            FileWriter writer = new FileWriter(filename);
            List<Book> aux = new ArrayList<>();
            aux = filterBooks();
            for(Book b:aux){
                writer.write(b.getName()+'#'+b.getAutor()+'#'+b.getEjahr()+'#'+b.getNrKopien()+'#'+b.getVerfExemplare()+'\n');
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
