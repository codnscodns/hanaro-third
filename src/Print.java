public class Print {
    public void menu(){
        System.out.println("******************************************");
        System.out.println("오늘의 선택, 코난문고\n영원한 스터디셀러, 명탐정 코난시리즈를 만나보세요~");
        System.out.println("1. 고객 정보 확인하기       2. 장바구니 상품 목록 보기");
        System.out.println("3. 바구니에 항목 추가하기    4. 장바구니의 항목 삭제하기");
        System.out.println("5. 장바구니 비우기          6. 영수증 표시하기        7. 종료");
        System.out.println("******************************************");
    }

    public void cartList(){
        System.out.println("장바구니 상품 목록:");
        System.out.println("-------------------------------------------");
        System.out.println("도서ID         | 수량           | 합계");
    }
}
