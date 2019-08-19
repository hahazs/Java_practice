package tool;

import model.Book;

import java.io.*;

public class IO {
    public void load() {
        try {
            String filename = "D:\\Project\\Git_Project\\Java_practice\\BookManage\\book.txt";
            File file = new File(filename);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                String bookname = temp.split(",")[0];
                String author = temp.split(",")[1];
                String pricestr = temp.split(",")[2];
                float price = Float.parseFloat(pricestr);
                Book book = new Book(bookname, author, price);
                BookList.booklist.add(book);
/*                mainClass.count++;*/
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public void save(){
        String filename = "D:\\Project\\Git_Project\\Java_practice\\BookManage\\book.txt";
        String allbook="";
        for(int i = 0;i < BookList.booklist.size();i++){
            Book book = (Book) BookList.booklist.get(i);
            String temp = book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "\r\n";
            allbook += temp;
        }
        try {
            File file1 = new File(filename);
            FileWriter fileWriter;
            fileWriter = new FileWriter(file1);
            fileWriter.write(allbook);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
