package com.popjak.CliWithTesting.booking;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
