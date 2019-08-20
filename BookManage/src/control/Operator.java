package control;

import jdbc.database;
import model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Operator {
    public ArrayList<Book> getBookList(){
        ArrayList<Book> booklist = new ArrayList<Book>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //通过与数据库的链接进行增删改查
        try{
            conn = database.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select id,bookname,author,price from book");
            while(rs.next()){//如果对象中有数据，就会循环打印出来
                String bookname = rs.getString("bookname");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                Book book = new Book(bookname,author,price);
                booklist.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.close(conn, stmt, rs);
        }
        return booklist;
    }
    public boolean addBook(String bookname,String author,float price){
       /* Book book = new Book(bookname,author,price);
        if(BookList.booklist.add(book)){
            return true;
        }
        else {
            return false;
        }*/
       Connection conn = null;
       Statement stmt = null;
       try {
           conn = database.getConnection();
           stmt = conn.createStatement();
           String sql = "insert into book(bookname,author,price) values('"+bookname+"','"+author+"',"+price+")";
           stmt.execute(sql);
           return true;
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }finally {
           database.close(conn, stmt);
       }
    }
    public boolean deleteBook(int id,String bookname){
/*        if(BookList.booklist.remove(id) != null){
            return true;
        }
        else {
            return false;
        }*/
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = database.getConnection();
            stmt = conn.createStatement();
            String sql;
            if (id != -1){
                sql = "delete from book where id ="+id;
            }
            else {
                sql = "delete from book where bookname ='"+bookname+"'";
            }
            if (stmt.execute(sql)){
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.close(conn, stmt);
        }
    }
    public boolean changeBook(int id,String bookname,String changename){
        /*Book book = (Book) BookList.booklist.get(id);
        if(book.setBook(bookname,author,price)){
            return true;
        }
        else {
            return false;
        }*/
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = database.getConnection();
            stmt = conn.createStatement();
            String sql;
            if (id != -1){
                sql = "update book set bookname ='"+bookname+"'"+"where id="+id;
            }
            else {
                sql = "update book set bookname='"+changename+"'"+"where bookname='"+bookname+"'";
            }
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.close(conn,stmt);
        }
    }
    public void findBook(int id,String bookname,String author,String dimname,float minprice,float maxprice){
        /*Book book = (Book) BookList.booklist.get(id);
        System.out.println("查找成功，您查找到的书为第"+(id+1)+"本书！"+"书名为："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");
    */
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = database.getConnection();
            stmt = conn.createStatement();
            String sql;
            if (id != -1){
                sql = "select id,bookname,author,price from book"+" where id='"+id;
            }
            else if (bookname != null){
                sql = "select id,bookname,author,price from book"+" where bookname='"+bookname+"'";
            }
            else if (author != null){
                sql = "select id,bookname,author,price from book"+" where author='"+author+"'";
            }
            else if (dimname != null){
                sql = "select id,bookname,author,price from book"+" where bookname like'%"+bookname+"%'";
            }
            else if (maxprice != 0){
                sql = "select id,bookname,author,price from book where price>="+minprice+" and price<="+maxprice;
            }
            else {
                System.out.println("出现未知错误，请联系管理员!");
                sql="";
            }
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                System.out.println("未找到您想要的图书！");
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            database.close(conn,stmt,rs);
        }
    }
/*    public int orderFind(int number){
        if(number <= BookList.booklist.size()){
            int id = number - 1;
            return id;
        }
        else{
            return -1;
        }
    }
    public int nameFind(String name) {
        int id = -1;
        for (int i = 0; i < BookList.booklist.size(); i++) {
            Book book = (Book) BookList.booklist.get(i);
            if (book.getBookname().equals(name)) {
                id = i;
                break;
            } else if (i < BookList.booklist.size()) {
                continue;
            } else {
                System.out.println("未找到您想要的书名");
                break;
            }
        }
        return id;
    }*/

    public void printAllBook() {
/*        for (int i = 0; i < BookList.booklist.size(); i++) {
            Book book = (Book) BookList.booklist.get(i);
            System.out.println("第" + (i + 1) + "本书名：" + book.getBookname() + " 作者：" + book.getAuthor() + " 单价：" + book.getPrice() + "元/本");
        }*/
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = database.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select id,bookname,author,price from book");
            if (rs.next()){
                do {
                    System.out.println("编号："+rs.getInt("id")+" 书名："+rs.getString("bookname")+",作者："+rs.getString("author")+",价格："+rs.getFloat("price"));
                }while (rs.next());
            }
            else {
                System.out.println("图书库为空，请添加图书！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.close(conn, stmt, rs);
        }
    }

    public boolean clearBook(){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = database.getConnection();
            stmt = conn.createStatement();
            String sql = "truncate table book";
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            database.close(conn, stmt);
        }
    }

}
