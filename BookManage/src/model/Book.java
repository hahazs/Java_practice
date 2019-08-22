package model;

public class Book {
    private int id;
    private String bookname;
    private String author;
    private float price;

    public Book(int id,String bookname,String author,float price)
    {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /*    public boolean setBook(String bookname, String author, float price) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        return true;
    }*/

}
