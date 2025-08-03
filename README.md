# Low Level Design in Java

A collection of clean, modular, and testable Low-Level Design (LLD) implementations in Java for real-world system design problems and core design patterns.

---

## 📌 Objective

This repository is built to:

- Practice LLD concepts using Java.
- Showcase system design problem solutions (like Parking Lot, ATM, etc.).
- Demonstrate common design patterns in action.
- Maintain reusable utilities and shared components.

---

## 🧱 Tech Stack

- **Language**: Java 17
- **Build Tool**: Gradle
- **Testing**: JUnit 5

---

## 📁 Project Structure

## Low-Level Design (LLD) for Movie Ticket Booking System

Below is a detailed Low-Level Design (LLD) for the specified movie ticket booking system. The design includes main classes, relationships, key components, and considerations for scalability and real-time seat updates.

### 1. Core Entities (Classes)

#### User
- `userId: String`
- `name: String`
- `email: String`
- `role: Enum { CUSTOMER, ADMIN }`
- `paymentMethods: List`

#### Theater
- `theaterId: String`
- `name: String`
- `location: String`
- `screens: List`

#### Screen (auditorium in theater)
- `screenId: String`
- `name: String`
- `seatingArrangement: SeatingArrangement`
- `shows: List`

#### Movie
- `movieId: String`
- `title: String`
- `language: String`
- `genre: String`
- `durationMins: Integer`
- `description: String`
- `certificate: String`

#### Show
- `showId: String`
- `movie: Movie`
- `screen: Screen`
- `theater: Theater`
- `startTime: DateTime`
- `endTime: DateTime`
- `seatStatus: Map`
- `pricing: Map`

#### SeatingArrangement
- `seats: List`
- `rows: Integer`
- `columns: Integer`

#### Seat
- `seatId: String`
- `row: Integer`
- `column: Integer`
- `type: SeatType (NORMAL, PREMIUM, etc.)`

#### Booking
- `bookingId: String`
- `user: User`
- `show: Show`
- `selectedSeats: List`
- `totalPrice: Double`
- `status: Enum {PENDING_PAYMENT, CONFIRMED, CANCELLED}`
- `payment: Payment`

#### Payment
- `paymentId: String`
- `booking: Booking`
- `amount: Double`
- `status: Enum { PENDING, SUCCESSFUL, FAILED }`
- `paymentMethod: PaymentMethod`
- `transactionDetails: String`

#### PaymentMethod
- `type: Enum {CREDIT_CARD, DEBIT_CARD, UPI, NET_BANKING}`
- `details: String`

#### Admin (inherits User)
- `addMovie(movie: Movie)`
- `updateMovie(movieId, Movie)`
- `deleteMovie(movieId)`
- `addShow(show: Show)`
- `updateShow(showId, Show)`
- `deleteShow(showId)`
- `updateSeatingArrangement(screenId, seatingArrangement)`

### 2. Use Case Flows and Activities

#### View Movies & Theaters
- Browse list of movies by city or location.
- Select a particular movie to see all theaters and timings.

#### Book Ticket
- Select movie, theater, timing.
- View seating arrangement for selected show.
- Select seats → Seats are "locked" (pessimistic or optimistic locking).
- Enter payment details, confirm payment.
- Upon success, mark seats as "booked" and generate ticket.

#### Admin Management
- Admin users interface to add/update/remove movies, shows, seating.

### 3. Concurrency and Real-Time Availability

- Use distributed locking, e.g., Redis or DB-level "seat hold" with TTL.
- When user selects seats, mark seat status as `BLOCKED` with expiration.
- On successful payment, status changes to `BOOKED`.
- All seat updates propagate via message queue or WebSocket for real-time UI updates to all users viewing that show.

#### SeatStatus Enum
- `AVAILABLE`
- `BLOCKED`
- `BOOKED`

### 4. Scalability Considerations

- Use microservices: User Service, Movie/Show Service, Booking Service, Payment Service, Notification Service.
- Caching for movies, theaters, and shows using Redis/Memcached.
- Scale horizontally with load balancers and stateless services.
- Use message queues (Kafka/RabbitMQ) for handling payment confirmation and notifications.
- Use CDN for static content and heavy user interface assets.

### 5. Class Diagram (Textual Overview)

```
User [1]-----*[Booking] 
Booking [1]-----1[Payment]
User [1]-----*[PaymentMethod]

Theater [1]-----*[Screen]
Screen [1]-----1[SeatingArrangement]
SeatingArrangement [1]-----*[Seat]
Screen [1]-----*[Show]
Show [1]-----*[Booking]
Show [1]-----*[Seat] (composition for status)
Show [1]-----1[Movie]
```

### 6. Example: Booking Seats - Pseudocode

```java
// When user selects seats:
if (allSeatsAvailable(showId, seatList)) {
    lockSeats(showId, seatList, userId); // Lock with TTL
    // Proceed to payment
} else {
    // Inform user to reselect seats
}

// On payment success:
updateSeatsToBooked(showId, seatList);
generateBooking(userId, showId, seatList, paymentDetails);
```

### 7. API Endpoints (Suggested)

#### Customer APIs
- GET `/movies?location={city}`
- GET `/theaters/{theaterId}/shows?movieId={movieId}`
- GET `/shows/{showId}/seats`
- POST `/bookings` (with seats, show, user)
- POST `/payments`

#### Admin APIs
- POST/PUT/DELETE `/movies`
- POST/PUT/DELETE `/shows`
- POST/PUT/DELETE `/theaters`
- POST/PUT/DELETE `/screens`

### 8. Additional Notes

- All APIs should be stateless and secure (OAuth2/JWT recommended).
- Use validation and input sanitization throughout.
- For real-time seat selection, consider WebSocket or Server-Sent Events for UI.
- Logging, auditing, and alerting for admin actions.

This LLD covers all the major requirements: **seat selection with concurrency, multiple show/theater/movie selection, different seat-types and pricing, administrative management, and scalability**. Further detailed class diagrams, database schema, and interface definitions can be provided for implementation.