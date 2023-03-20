package com.popjak.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        String age
) {
}
