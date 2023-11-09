package com.seungh1024.generic;

public class GenericWildcardSample<T> {
    public static void main(String[] args) {
        GenericWildcardSample sample = new GenericWildcardSample();
        sample.callGenericMethod();
    }

    /**
     *
     * 기존 제네릭 사용법은 매개 변수로 사용된 객체에 값을 추가할 수 없는 문제가 있다.
     * 아래처럼 메소드 선언시 리턴 타입 앞에 제네릭한 타입을 선언해주고 그 타입을 매개변수에서 사용하면 컴파일할 때 전혀 문제가 없다.
     *
     */
    public <T> void genericMethod(WildcardGeneric<T> c, T addValue) {
        c.setWildcard(addValue);
        T value = c.getWildcard();
        System.out.println(value);
    }

    public void callGenericMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
        genericMethod(wildcard,"data");

        WildcardGeneric<Car> wildcard2 = new WildcardGeneric<Car>();
        boundedGenericMethod(wildcard2, new Bus("1111"));
        new GenericWildcardSample(wildcard2,new Bus("123"));
    }

    /**
     * 당연히 이 방법도 bounded wildcards처럼 사용할 수 있다.
     */
    public <T extends Car> void boundedGenericMethod(WildcardGeneric<T> c, T addValue) {
        c.setWildcard(addValue);
        T value = c.getWildcard();
        System.out.println(value);
    }

    /**
     * 매개변수를 제네릭 타입 두 개를 받는다면 아래처럼 콤마로 나열해서 사용이 가능하다
     */
    public <S extends Bus,T extends Car> void multiGenericMethod(WildcardGeneric<T> c, T addValue, S another) {
        c.setWildcard(addValue);
        T value = c.getWildcard();
        System.out.println(value);
    }

    public GenericWildcardSample(WildcardGeneric<T> c, T object) {
        c.setWildcard(object);
    }
    public GenericWildcardSample(){};
}
