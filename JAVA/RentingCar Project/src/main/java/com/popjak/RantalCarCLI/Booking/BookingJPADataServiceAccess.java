package com.popjak.RantalCarCLI.booking;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class BookingJPADataServiceAccess implements BookingDAO {

    private final EntityManager entityManager;

    public BookingJPADataServiceAccess(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
