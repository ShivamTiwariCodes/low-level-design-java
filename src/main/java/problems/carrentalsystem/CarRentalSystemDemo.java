package problems.carrentalsystem;

import problems.carrentalsystem.models.*;
import problems.carrentalsystem.services.BookingService;
import problems.carrentalsystem.services.CarService;
import problems.carrentalsystem.services.UserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CarRentalSystemDemo {

//    The car rental system should allow customers to browse and reserve available cars for specific dates.
//    Each car should have details such as make, model, year, license plate number, and rental price per day.
//    Customers should be able to search for cars based on various criteria, such as car type, price range and availability.
//    The system should handle reservations, including creating, modifying, and canceling reservations.
//    The system should keep track of the availability of cars and update their status accordingly.
//    The system should handle customer information, including name, contact details, and driver's license information.
//    The system should handle payment processing for reservations.
//    The system should be able to handle concurrent reservations and ensure data consistency.

//    Entities : Customer, Car ( make, model, year, license plate number, rental price per day ), Reservation, System,
//    Payment,

//    Functional requirements :
//    1. Customer can register and update their info
//    2. customer can search car based on such as car type, price range, and availability.
//    3. Customer can book and pay separately
//    4. user can update and cancel the reservation

//    Non-function
//    1. can handle concurrent reservations and ensure data consistency

//    Flow :
//    Register user -> get list of available cars -> pick one car -> book it -> make payment -> check booking
//    fetch list of available car and verify booked not found
//    try to book the same car

public static void run() {

        UserService userService = UserService.getCarServiceInstance();
        CarService carService = CarService.getCarServiceInstance();
        BookingService bookingService = BookingService.getBookingServiceInstance();

        User user1 = new User("user_1", "user1", "9887988798", "UP8382732");
        User user2 = new User("user_2", "user2", "9887989867", "UP3278328");
        User user3 = new User("user_3", "user3", "9887984567", "UP8636823");

        userService.register(user1);
        userService.register(user2);
        userService.register(user3);

        userService.updateUser("user_1", "name", "updated_user_1");

//        Created 3 cars
        Car car1 = new Car(UUID.randomUUID().toString(), "Manufacturer_1", "model 1",
                "license 1", new BigDecimal(10), CarType.SEDAN);
        Car car2 = new Car(UUID.randomUUID().toString(), "Manufacturer_2", "model 2",
                "license 2", new BigDecimal(50), CarType.SUV);
        Car car3 = new Car(UUID.randomUUID().toString(), "Manufacturer_1", "model 3",
                "license 3", new BigDecimal(100), CarType.COUPE);

//        Added 3 cars
        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);


        LocalDateTime startTime = LocalDateTime.now().plusDays(1).plusHours(1);
        LocalDateTime endTime = LocalDateTime.now().plusDays(2).plusHours(1);

        Filter filter1 = new Filter(new DateRange(startTime, endTime));

        List<Car> availableCars = carService.getAvailableCars(filter1);



        System.out.println("Booking car with carId : " + availableCars.get(0).getId() + " for filters " + filter1.toString());

        Filter filter2 = new Filter(new DateRange(LocalDateTime.now().plusDays(1).plusHours(2), LocalDateTime.now().plusDays(2).plusHours(1)));
        availableCars = carService.getAvailableCars(filter2);






    }
}
