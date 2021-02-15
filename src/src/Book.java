import java.time.LocalDate;

public class Book {
    private String name;
    private String autor;
    private LocalDate ejahr;
    private int nrKopien;
    private int verfExemplare;

    public Book(String name, String autor, LocalDate ejahr, int nrKopien, int verfExemplare) {
        this.name = name;
        this.autor = autor;
        this.ejahr = ejahr;
        this.nrKopien = nrKopien;
        this.verfExemplare = verfExemplare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getEjahr() {
        return ejahr;
    }

    public void setEjahr(LocalDate ejahr) {
        this.ejahr = ejahr;
    }

    public int getNrKopien() {
        return nrKopien;
    }

    public void setNrKopien(int nrKopien) {
        this.nrKopien = nrKopien;
    }

    public int getVerfExemplare() {
        return verfExemplare;
    }

    public void setVerfExemplare(int verfExemplare) {
        this.verfExemplare = verfExemplare;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", autor='" + autor + '\'' +
                ", ejahr=" + ejahr +
                ", nrKopien=" + nrKopien +
                ", verfExemplare=" + verfExemplare +
                '}';
    }
}

