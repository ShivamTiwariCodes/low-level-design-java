package problems.movieticketbookingsystem;

import java.io.FileReader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import problems.movieticketbookingsystem.controller.ThreaterController;
import problems.movieticketbookingsystem.controller.UserController;
import problems.movieticketbookingsystem.models.Booking;
import problems.movieticketbookingsystem.models.IPaymentStrategy;
import problems.movieticketbookingsystem.models.Movie;
import problems.movieticketbookingsystem.models.Screen;
import problems.movieticketbookingsystem.models.Seat;
import problems.movieticketbookingsystem.models.SeatType;
import problems.movieticketbookingsystem.models.Show;
import problems.movieticketbookingsystem.models.Threater;
import problems.movieticketbookingsystem.models.UPIPaymentStrategy;
import problems.movieticketbookingsystem.models.User;
import problems.movieticketbookingsystem.service.BookingService;
import problems.movieticketbookingsystem.service.ShowService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MovieTicketBookingSystemDemo {

    public static void runDemo() {

        // get instances of required class
        UserController userController = UserController.getInstance();
        ShowService showService = ShowService.getInstance();
        ThreaterController threaterController = ThreaterController.getInstance();
        BookingService bookingService = BookingService.getInstance();
        
        // create users
        User user1 = new User("user_1","user 1");
        User user2 = new User("user_2", "User 2");

        // register user
        userController.registerUser(user1);
        userController.registerUser(user2);

        // create a list of 3 NORMAL and 2 PREMIUM seats
        List<Seat> seats1 = new ArrayList<>();
        seats1.add(new Seat("seat_1", SeatType.NORMAL, 100));
        seats1.add(new Seat("seat_2", SeatType.NORMAL, 100));
        seats1.add(new Seat("seat_3", SeatType.NORMAL, 100));
        seats1.add(new Seat("seat_6", SeatType.PREMIUM, 200));
        seats1.add(new Seat("seat_7", SeatType.PREMIUM, 200));

        // create a list of 2 NORMAL and 3 PREMIUM seats
        List<Seat> seats2 = new ArrayList<>();
        seats2.add(new Seat("seat_4", SeatType.NORMAL, 100));
        seats2.add(new Seat("seat_5", SeatType.NORMAL, 100));
        seats2.add(new Seat("seat_8", SeatType.PREMIUM, 200));
        seats2.add(new Seat("seat_9", SeatType.PREMIUM, 200));
        seats2.add(new Seat("seat_10", SeatType.PREMIUM, 200));

        // create screens for threater 1
        Screen screen_t1_1 = new Screen("s1_t1", "Screen 1", 5, new ArrayList<>(seats1));
        Screen screen_t1_2 = new Screen("s2_t1", "Screen 2", 5, new ArrayList<>(seats1));

        // create screens for threater 2
        Screen screen_t2_1 = new Screen("s1_t2", "Screen 1", 5, new ArrayList<>(seats1));
        Screen screen_t2_2 = new Screen("s2_t2", "Screen 2", 5, new ArrayList<>(seats2));

        // create threaters
        Threater threater1 = new Threater("t1", "Bengaluru", new ArrayList<>(List.of(screen_t1_1, screen_t1_2)));
        Threater threater2 = new Threater("t2", "Delhi", new ArrayList<>(List.of(screen_t2_1, screen_t2_2)));

        // add threaters
        threaterController.addThreater(threater1);
        threaterController.addThreater(threater2);

        // create movies
        Movie movie1 = new Movie("movie_1", "movie 1", "2 hr 30 min");
        Movie movie2 = new Movie("movie_2", "movie 2", "2 hr 15 min");

        // create shows 
        Show show_s1_t1_1 = new Show("s1_t1_1", movie1, Instant.EPOCH.plusNanos((long)86400000), screen_t1_1);
        Show show_s1_t1_2 = new Show("s1_t1_2", movie2, Instant.EPOCH.plusNanos((long)86400000), screen_t1_2);

        // add shows, shows has screen, screen has threater
        showService.addShow(show_s1_t1_1);
        showService.addShow(show_s1_t1_2);

        // get all shows for a city
        String city = "Bengaluru";

        // get the list of shows for given city
        List<Show> availableShows = showService.getAllShowsByCity(city);

        // Selecting the first show from the available list of shows
        Show selectedShow = availableShows.get(0);

        // select seats from the selected show
        List<Seat> seatsToBook = new ArrayList<>();
        seatsToBook.addAll(selectedShow.getAvailableSeats(SeatType.NORMAL, 2));
        seatsToBook.addAll(selectedShow.getAvailableSeats(SeatType.PREMIUM, 1));

//      Add stratrgy by which you want to pay i.e. cash, upi or credit card
        IPaymentStrategy paymentStrategy = new UPIPaymentStrategy("example@upi");

        // make booking
        Booking booking = bookingService.bookSeats(user1, selectedShow, seatsToBook, paymentStrategy);

        // final step to book the tickets
        booking.pay();

        System.out.println(booking.toString());

    }
}