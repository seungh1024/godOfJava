package com.seungh1024.nio;

import java.io.Serializable;

public class SerialDTO implements Serializable {
    // serialVersionUID가 있으면 클래스 필드가 추가되거나 제거되어도 같은 객체로 인식한다
    // 그래서 아래의 bookType을 bookTypes로 변경하고 저장한 객체를 읽어오려 하면 Null값을 읽어온다.
    // 변수 이름이 바뀌면 저장되어 있는 객체에서 찾지 못하기 때문이다.
    // 하지만 이렇게 객체가 바뀌었는데 예외가 발생하지 않는건 문제가 있다. 따라서 데이터가 바뀌면 serialUID를 변경하는 습관을 가져야 한다
    private static final long serialVersionUID = 1L;
    private String bookType = "IT";
    private String bookName;
    transient private int bookOrder;
    private boolean bestSeller;
    private long soldPerDay;

    public SerialDTO(String bookName, int bookOrder, boolean bestSeller, long soldPerDay) {
        super();
        this.bookName = bookName;
        this.bookOrder = bookOrder;
        this.bestSeller = bestSeller;
        this.soldPerDay = soldPerDay;
    }

    @Override
    public String toString() {
        return "SerialDTO [bookName = "+bookName + ", bookORder = " + bookOrder + ", bestSeller = " +
                bestSeller + ", soldPerDay = " + soldPerDay +  ", bookType = " + bookType + "]";
    }
}
