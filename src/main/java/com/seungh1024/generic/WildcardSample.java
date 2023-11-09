package com.seungh1024.generic;

public class WildcardSample {
    public static void main(String[] args) {
        WildcardSample sample = new WildcardSample();
        sample.callWildcardMethod();
    }

    private void callWildcardMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<>();
        wildcard.setWildcard("A");
        wildcardStringMethod(wildcard);
    }

    @Deprecated
    private void wildcardStringMethod(WildcardGeneric<String> wildcard) {
        String value = wildcard.getWildcard();
        System.out.println(value);
    }


    /**
     * 위의 wildcardStringMethod는 WildcardGeneric<String> 타입만 받을 수 있는 문제가 있다.
     * WildcardGeneric<Integer>도 넣고 싶다면 WildcardGeneric<?>와 같이 선언하는 방법이 있다
     * 대신 타입을 정확히 모르기 때문에 Object로 처리해야한다. 이때 ?로 명시한 타입을 와일드카드라고 부른다.
     */
    public void wildcardStringMethod2(WildcardGeneric<?> wildcard) {
        Object value = wildcard.getWildcard();
        System.out.println(value);
    }
}
