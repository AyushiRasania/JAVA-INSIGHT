package com.library;

public class Book {

    public int id;
    public String title;
    public String author;
    public String category;
    public double price;
    public int quantity;

    public Book(int id, String title, String author, String category, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
