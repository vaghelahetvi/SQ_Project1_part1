class BookingModuleTests {

    @Test
    void testCreateBookingSuccess() {
        // Assuming createBooking returns a BookingConfirmation object on success
        assertNotNull(BookingModule.createBooking(1, new FlightDetails("Flight123")));
    }

    @Test
    void testCreateBookingNonExistentUser() {
        // Assuming createBooking throws IllegalArgumentException for non-existent user ID
        assertThrows(IllegalArgumentException.class, () -> {
            BookingModule.createBooking(-1, new FlightDetails("Flight123"));
        });
    }

    @Test
    void testCreateBookingFullyBookedFlight() {
        // Assuming createBooking throws IllegalArgumentException for a fully booked flight
        assertThrows(IllegalArgumentException.class, () -> {
            BookingModule.createBooking(1, new FlightDetails("FullyBookedFlight"));
        });
    }
}