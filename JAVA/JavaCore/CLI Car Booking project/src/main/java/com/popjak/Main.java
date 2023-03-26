package com.popjak;

import com.popjak.booking.BookingDataAccessService;
import com.popjak.booking.BookingServices;
import com.popjak.car.CarDataAccessService;
import com.popjak.car.CarServices;
import com.popjak.mainmenu.MainMenu;
import com.popjak.user.UserDataAccessService;
import com.popjak.user.UserServices;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        UserServices userServices = new UserServices(new UserDataAccessService());
        CarServices carServices = new CarServices(new CarDataAccessService());
        BookingServices bookingServices = new BookingServices(new BookingDataAccessService(),carServices,userServices);
        MainMenu menu = new MainMenu(carServices,bookingServices,userServices);


        menu.mainMenu();











    }
}
