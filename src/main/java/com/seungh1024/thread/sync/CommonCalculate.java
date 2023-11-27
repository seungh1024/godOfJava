package com.seungh1024.thread.sync;

public class CommonCalculate {
    private int amount;
    public CommonCalculate() {
        amount = 0;
    }

//    public synchronized void plus(int value) {
//        amount+=value;
//    }
//
//    public synchronized void minus(int value) {
//        amount -=value;
//    }

    /**
     *
     * 메소드 전체에 synchronized를 사용하면 불필요한 부분에도 적용되어서 성능이 떨어질 수 있다.
     * 그 때 아래처럼 특정 부분만 따로 처리할 수 있다.
     * 소괄호 안 this는 잠금 처리를 하기 위한 객체를 선언한다
     * 일반적으로는 별도의 객체를 선언해서 사용한다
     */
    Object lock = new Object();
    public void plus(int value) {
        synchronized (lock){
            amount+=value;
        }
    }

    public void minus(int value) {
        synchronized (this){
            amount-=value;
        }
    }

    /**
     * 여러 개의 변수를 처리할 때에도 여러 스레드에서 접근하면 안되는 경우 아래와 같이 사용한다.
     * 각각의 lock 객체를 만들어서 각각의 변수의 문지기를 시키는 것이다.
     * 만약 하나의 Lock객체만 사용한다면 amount에 변경이 발생할 때 interset의 변경은 막지 못할 것이다.
     * 운영체제에서 배운 lock획득의 개념으로 생각하면 된다!
     */
    private int interest;
    private Object interestLock = new Object();
    private Object amountLock = new Object();
    public void addInterest(int value) {
        synchronized (interestLock) {
            interest+=value;
        }
    }
    public void addAmount(int value) {
        synchronized (amountLock) {
            amount += value;
        }
    }

    public int getAmount() {
        return amount;
    }
}
