package com.popjak;

import java.util.Arrays;

public class Calculator {

    public int add(int ...numbers) {
        return Arrays.stream(numbers).sum();
    }

    public int subtract(int a, int b) {
        return Math.subtractExact(a,b);

    }
}
