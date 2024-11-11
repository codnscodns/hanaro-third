package p1;

import java.time.LocalDate;
import java.util.*;

public class Cart {
    List<Book> books = Book.getBookList();
//    List<p1.Book> cart = new ArrayList<p1.Book>();
    Scanner scanner = new Scanner(System.in);
    Print print = new Print();

    private List<CartItem> cartItems; // 장바구니에 담긴 도서 정보 리스트

    public Cart() {
        cartItems = new ArrayList<>();
    }

    // CartItem 클래스 정의 (ISBN, 개수, 총 가격)
    private static class CartItem {
        private String isbn;
        private int count;
        private int price;

        public CartItem(String isbn, int price) {
            this.isbn = isbn;
            this.count = 1;
            this.price = price;
        }

        public String getIsbn() {
            return isbn;
        }

        public int getCount() {
            return count;
        }

        public int getPrice() {
            return price;
        }

        public void incrementCount(int price) {
            this.count++;
            this.price += price;
        }
    }

    public void printCart(){
        if(!cartItems.isEmpty()) {
            print.cartList();
            for (CartItem item : cartItems) {
                System.out.printf("%s      | %d             | %d\n", item.getIsbn(), item.getCount(), item.getPrice());
            }
            System.out.println("-------------------------------------------");
        }else{
            System.out.println("장바구니가 비어있습니다.");
        }
    }

    public void addCart(){
        String addBookId;
        Book book;

        for(Book b: books){
            System.out.println(b.toString());
        }

        while(true){
            System.out.printf("장바구니에 추가할 도서의 ID를 입력하세요: ");
            String bookId = scanner.nextLine();
            book = Book.findBookById(bookId);
            if (book != null){
                break;
            }
            System.out.println("존재하지 않는 책입니다. 다시 입력해주세요.");
        }

        while (true) {
            System.out.printf("장바구니에 추가하겠습니까? Y|N ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Y")) {
                CartItem existingItem = findCartItem(book.getIsbn());
                if (existingItem != null) {
                    existingItem.incrementCount(book.getPrice()); // 개수와 총 가격 업데이트
                } else {
                    cartItems.add(new CartItem(book.getIsbn(), book.getPrice())); // 새 항목 추가
                }
                System.out.println("도서가 장바구니에 추가되었습니다.");
                break;
            } else if (input.equalsIgnoreCase("N")) {
                System.out.println("도서가 장바구니에 추가되지 않았습니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. Y 또는 N을 입력해주세요 ");
            }
        }
    }

    // 장바구니 내 특정 ISBN 도서를 찾는 메서드
    private CartItem findCartItem(String isbn) {
        for (CartItem item : cartItems) {
            if (item.isbn.equals(isbn)) {
                return item;
            }
        }
        return null;
    }

    public void clearCart() {
        cartItems.clear();
        System.out.println("장바구니의 모든 아이템을 삭제했습니다.");
    }

    public void deleteFromCart(String isbn) {
        CartItem itemRemove = findCartItem(isbn);
        if (itemRemove != null) {
            cartItems.remove(itemRemove);
            System.out.println("장바구니에서 " + isbn + "가 삭제되었습니다.");
        } else {
            System.out.println("해당 ID의 도서를 장바구니에서 찾을 수 없습니다.");
        }
    }

    public void recipt(User user){
        if(cartItems.isEmpty()){
            System.out.println("장바주니가 비어있습니다.");
            return;
        }

        while (true) {
            System.out.printf("배송받을 분은 고객 정보와 같습니까? ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Y")) {
                System.out.print("배송지를 입력해주세요: ");
                String address = scanner.nextLine();

                System.out.println("------------배송 받을 고객 정보------------");
                System.out.println("고객명: " + user.getName() + " 연락처: " + user.getPhoneNumber());
                System.out.println("배송지: " + address + " 발송일: " + LocalDate.now());
                printCart();
                System.out.printf("총액: %d원\n", getTotalPrice());

                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }
}
