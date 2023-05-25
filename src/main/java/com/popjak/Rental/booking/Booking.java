package com.popjak.Rental.booking;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.time.format.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "booking_data")

public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "booking_start_date")
    private LocalDate bookingDate;

    @Column(name = "booking_end_date")
    private LocalDate bookingEndDate;

    @Column(name = "reg_num")
    private String regNum;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "customer_paid")
    private Integer customerPaid;


    public Booking(Integer bookingEndDate, String regNum, String userEmail, Integer customerPaid) {
        this.bookingDate = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        this.bookingEndDate = this.bookingDate.plusDays(bookingEndDate);
        this.regNum = regNum;
        this.userEmail = userEmail;
        this.customerPaid = customerPaid;
    }
}
