package com.seungh1024.generic;

public class CarWildcardSample {
    public static void main(String[] args) {
        CarWildcardSample sample = new CarWildcardSample();
        sample.callBoundedWildcardMethod();
        sample.callBusBoundedWildcardMethod();
    }

    private void callBoundedWildcardMethod() {
        WildcardGeneric<Car> wildcard = new WildcardGeneric<Car>();
        wildcard.setWildcard(new Car("Mustang"));
        boundedWildcardMethod(wildcard);
    }

    /**
     *
     * 이렇게 ? extends Car를 사용하면 Car를 상속받은 모든 클래스를 사용할 수 있다는 의미이다.
     * 이런 방식을 bounded wildcards라고 부른다.
     * bound가 경계라는 의미가 있어, 매개 변수로 넘어오는 제네릭 타입의 경계를 지정하는 데 사용한다는 의미이다.
     */
    private void boundedWildcardMethod(WildcardGeneric<? extends Car> wildcard) {
        Car value = wildcard.getWildcard();
        System.out.println(value);
    }

    private void callBusBoundedWildcardMethod() {
        WildcardGeneric<Bus> wildcard = new WildcardGeneric<Bus>();
        wildcard.setWildcard(new Bus("6900"));
        boundedWildcardMethod(wildcard);
    }
}
