package model;

public class Book {
    private String bookname;
    private String author;
    private float price;

    public Book(String bookname,String author,float price)
    {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
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

    public void setBook(String bookname,String author,float price) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

}
