package problems.carrentalsystem.services;

public class BookingService {

    private static String DEFAULT_FORMAT = "";

    public static volatile BookingService bookingServiceInstance;
//    public final Map<String, List<>> abc;
//    LocalDateTime

    private BookingService() {}

    public BookingService getBookingServiceInstance() {
        if(bookingServiceInstance == null) {
            synchronized (BookingService.class) {
                if(bookingServiceInstance == null) {
                    bookingServiceInstance = new BookingService();
                }
            }
        }
        return bookingServiceInstance;
    }
}
