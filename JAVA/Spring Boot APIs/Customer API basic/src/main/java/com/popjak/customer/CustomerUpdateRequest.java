package com.popjak.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        String age
) {
}
