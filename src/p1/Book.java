package p1;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private int price;
    private String author;
    private String content;
    private String category;
    private String publishedAt;

    private static List<Book> bookList = new ArrayList<>();

    public Book(String isbn, String title, int price, String author, String content, String category, String publishedAt) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.author = author;
        this.content = content;
        this.category = category;
        this.publishedAt = publishedAt;
    }

    static{
        bookList.add(new Book("ISBN1234", "셜록홈즈", 20000, "코난 도일", "그 누구도 뛰어넘지 못했던 추리 소설의 고전", "추리소설", "2018/10/08"));
        bookList.add(new Book("ISBN2345", "도리안 그레이의 초상", 16000, "오스카 와일드", "예술을 위한 예술!", "고전소설", "2022/01/22"));
        bookList.add(new Book("ISBN3456", "쥐덫", 27000, "에거서크리스티", "폭설 속에 갇힌 몽스웰 여관 - 네 명의 손님과 주인 부부, 그리고 한 명의 형사", "추리소설", "2019/06/10"));
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public static List<Book> getBookList() {
        return bookList;
    }

    @Override
    public String toString() {
        return isbn + '|' +
                title + '|' +
                price + "원|" +
                author +  '|' +
                content +  '|' +
                category +  '|' +
                publishedAt;
    }

    public static Book findBookById(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
