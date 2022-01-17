package QuanLy;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Book implements Serializable {//bat buoc phai ke thua nhu the nay thi moi luu duoc file object
    private String bookName, authorName, publishDate, manufacturerName;
    int price;

    public Book() {
    }

    public Book(String bookName, String authorName, String publishDate, String manufacturerName, int price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.manufacturerName = manufacturerName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", price=" + price +
                '}';
    }
    public void display(){
        System.out.println(this);
    }
    public void input(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten sach:");
        bookName = sc.nextLine();

        System.out.println("Nhap ten tac gia:");
        authorName = sc.nextLine();

        System.out.println("Ngay xuat ban:");
        publishDate = sc.nextLine();

        System.out.println("Nha san xuat:");
        manufacturerName = sc.nextLine();

        System.out.println("Nhap gia: ");
        price = Integer.parseInt(sc.nextLine());
    }
    public String getFileLine(){
        return bookName+","+authorName+","+price+","+publishDate+","+manufacturerName+"\n";
    }
}
