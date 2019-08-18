package ui;

import control.Operator;
import model.Book;
import model.BookList;
import sun.java2d.pipe.SpanIterator;
import tool.IO;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
/*    //设置图书库的图书存量上限
    private static final int size = 10;
    //新建一个Book数组
    Book[] booklist = new Book[size];*/
/*    public ArrayList booklist = new ArrayList();
    //新建一个整数计数
    public int count = 0;*/

    public MainClass() {
        Scanner scanner = new Scanner(System.in);
        IO io = new IO();
        io.load();
        printMenu();

        while (true) {
            //读取用户输入
            int choice = scanner.nextInt();
            if (choice == 5) {
                io.save();
                System.out.println("Exit Successfully");
                System.exit(0);
                break;
            }
            /*            else {*/
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    changeBook();
                    break;
                case 4:
                    findBook();
                    break;
                default:
                    System.out.println("Warning");
                    printMenu();
                    continue;
            }
            /*   }*/
        }
    }

    void printMenu() {
        System.out.println("Welcome");
        System.out.println("addBook......1");
        System.out.println("deleteBook...2");
        System.out.println("changeBook...3");
        System.out.println("findBook.....4");
        System.out.println("Exit.........5");
    }

    void addBook() {
        /*System.out.println("add");*/
/*        if(count > booklist.size()-1)
        {*/
        System.out.println("当前共有" + BookList.booklist.size() + "本书");
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入书名");
        String bookname = scan.next();
        System.out.println("请输入作者");
        String author = scan.next();
        System.out.println("请输入价格");
        float price = scan.nextFloat();
        Operator operator = new Operator();
        boolean isSuccess = operator.addBook(bookname, author, price);
        /*Book book = new Book(bookname, author, price);*/
        /*booklist[count] = book;*/
/*            booklist.add(book);
            count++;*/
        /*if(count <= size){*/
        if (isSuccess) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        operator.printAllBook();
        /*            printAllBook();*/
/*        }
        else {
            System.out.println("超过图书管理上限");
        }*/
        printMenu();
    }

    void deleteBook() {
        /*System.out.println("delete");*/
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请选择删除方式：1-序号   2-书名  3-返回主菜单");
            int choice_del = scan.nextInt();
            if (choice_del == 1) {
                System.out.println("请输入书本序号：");
                int num_book = scan.nextInt();
                Operator operator = new Operator();
                num_book = operator.orderFind(num_book);
                if (num_book != -1) {
                    /*for(int i = num_book;i < count;i++){
                        booklist[i] = booklist[i+1];*/
                    boolean isSuccess = operator.deleteBook(num_book);
                    if (isSuccess) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    operator.printAllBook();
                    /* BookList.booklist.remove(num_book);*/
                    /*  count--;*/


                } else {
                    System.out.println("输入非法");
                }
                /*  }*/
            } else if (choice_del == 2) {
                System.out.println("输入书本名称：");
                String name_book = scan.next();
                Operator operator1 = new Operator();
                int id = operator1.nameFind(name_book);
               /* for(int i = id;i < count;i++) {
                    booklist[i] = booklist[i + 1];*/
                if (id != -1) {
                    /*BookList.booklist.remove(id);*/
                    /*count--;*/
                    boolean isSuccess = operator1.deleteBook(id);
                    if (isSuccess) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    operator1.printAllBook();
                    /*                }*/
                } else {
                    System.out.println("输入非法");
                }
            } else if (choice_del == 3) {
                printMenu();
                break;
            } else {
                System.out.println("输入非法");
                /*System.out.println("请选择删除方式：1-序号 2-书名 3-返回主菜单");*/
            }
        }
    }

    void changeBook() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你要以何种方式对图书修改：1-序号  2-书名 3-返回主菜单");
            int choice_change = scanner.nextInt();
            if (choice_change == 1) {
                System.out.println("请输入图书的书号：");
                int id_book = scanner.nextInt();
                Operator operator = new Operator();
                id_book = operator.orderFind(id_book);
                if (id_book != -1) {
/*
                    System.out.println("原书名为：" + booklist[id_book].getBookname()+"请输入图书新名称：");
*/
                    Book book = (Book) BookList.booklist.get(id_book);
                    System.out.println("原书名：" + book.getBookname() + "请输入图书新名称：");
                    String new_bookname = scanner.next();
                    System.out.println("请输入图书新作者：");
                    String new_bookauthor = scanner.next();
                    System.out.println("请输入图书新价格：");
                    float new_bookprice = scanner.nextFloat();
                    /*booklist[id_book].setBook(new_bookname,new_bookauthor,new_bookprice);*/
                    boolean isSuccess = operator.changeBook(id_book, new_bookname, new_bookauthor, new_bookprice);
                    /*book.setBook(new_bookname, new_bookauthor, new_bookprice);*/
                    if (isSuccess) {
                        System.out.println("修改成功");
                    } else {
                        System.out.println("修改失败");
                    }
                    operator.printAllBook();
                } else {
                    System.out.println("输入错误");
                }
            } else if (choice_change == 2) {
                System.out.println("请输入图书的书名：");
                String name_book = scanner.next();
                Operator operator1 = new Operator();
                int id = operator1.nameFind(name_book);
                if (id != -1) {
                    /*System.out.println("原书名为：" + booklist[id].getBookname()+"请输入图书新名称：");*/
                    Book book = (Book) BookList.booklist.get(id);
                    System.out.println("原书名为：" + book.getBookname() + "请输入图书新名称：");
                    String new_bookname = scanner.next();
                    System.out.println("请输入图书新作者：");
                    String new_bookauthor = scanner.next();
                    System.out.println("请输入图书新价格：");
                    float new_bookprice = scanner.nextFloat();
                    /*booklist[id].setBook(new_bookname,new_bookauthor,new_bookprice);*/
                    /*book.setBook(new_bookname, new_bookauthor, new_bookprice);*/
                    boolean isSuccess = operator1.changeBook(id, new_bookname, new_bookauthor, new_bookprice);
                    if (isSuccess) {
                        System.out.println("修改成功");
                    } else {
                        System.out.println("修改失败");
                    }
                    operator1.printAllBook();
                } else {
                    System.out.println("输入错误");
                }
            } else if (choice_change == 3) {
                printMenu();
                break;
            } else {
                System.out.println("输入非法");
                /*System.out.println("请输入你要以何种方式对图书修改：1-序号  2-书名 3-返回主菜单");*/
            }
        }
        /*printMenu();*/
    }

    void findBook() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入想要以何种方式查找图书：1-序号 2-书名 3-返回主菜单");
            int find_choice = scanner.nextInt();
            if (find_choice == 1) {
                System.out.println("请输入序号：");
                int id = scanner.nextInt();
                Operator operator = new Operator();
                id = operator.orderFind(id);
                if (id != -1) {
                    /*Book book = (Book) BookList.booklist.get(id);*/
                    operator.findBook(id);
                    System.out.println("查找完成");
                    /*System.out.println("当前书籍的名称为：" + booklist[id].getBookname() + "当前书籍的作者为：" + booklist[id].getAuthor() + "当前书籍的价格为：" + booklist[id].getPrice());*/
                    /*System.out.println("当前书籍的名称为：" + book.getBookname() + "当前书籍的作者为：" + book.getAuthor() + "当前书籍的价格为：" + book.getPrice());*/
                } else {
                    System.out.println("输入错误");
                }
            } else if (find_choice == 2) {
                System.out.println("请输入书名：");
                String find_bookname = scanner.next();
                Operator operator1 = new Operator();
                int idname = operator1.nameFind(find_bookname);
                if (idname != -1) {
                    /*Book book = (Book) booklist.get(idname);*/
                    operator1.findBook(idname);
                    System.out.println("查找完成");
                    /*System.out.println("当前书籍的名称为：" + booklist[idname].getBookname() + "当前书籍的作者为：" + booklist[idname].getAuthor() + "当前书籍的价格为：" + booklist[idname].getPrice());*/
/*
                        System.out.println("当前书籍的名称为：" + book.getBookname() + "当前书籍的作者为：" + book.getAuthor() + "当前书籍的价格为：" + book.getPrice());
*/
                } else {
                    System.out.println("输入错误");
                }
            } else if (find_choice == 3) {
                printMenu();
                break;
            } else {
                System.out.println("输入非法");
            }
/*
                    System.out.println("请输入想要以何种方式查找图书：1-序号 2-书名 3-返回主菜单");
*/
        }
    }
    /*printMenu();*/
 /*   void printAllBook(){
        System.out.println("当前图书有:");
        for(int i = 0;i < count;i++){
            Book book = (Book) booklist.get(i);
            System.out.println("第"+(i+1)+"本书：书名"+book.getBookname()+"作者："+book.getAuthor()+"价格："+book.getPrice()+"元");
        }
    }
    int orfind(int number){
        if(number <= count && number > 0){
            int num_book = number - 1;
            return num_book;
        }
        else {
            return -1;
        }
    }
    int namefind(String name){
        int id = -1;
        for(int i = 0;i < count;i++){
            Book book = (Book) booklist.get(i);
            if(book.getBookname().equals(name)){
                id = i;
                break;
            }
            else if(i < count){
                continue;
            }
            else{
                System.out.println("未找到想要的书名");
                break;
            }
        }
        return id;
    }*/

    public static void main(String[] args) {
        new MainClass();
    }
}
