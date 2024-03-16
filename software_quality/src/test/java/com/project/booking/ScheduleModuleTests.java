class ScheduleModuleTests {

    @Test
    void testAddFlightSuccess() {
        // Assuming addFlight returns true on successful addition
        assertTrue(ScheduleModule.addFlight(new FlightDetails("NewFlight")));
    }

    @Test
    void testAddFlightIncompleteDetails() {
        // Assuming addFlight throws IllegalArgumentException for incomplete details
        assertThrows(IllegalArgumentException.class, () -> {
            ScheduleModule.addFlight(new FlightDetails("")); // Assuming empty details are not allowed
        });
    }

    @Test
    void testGetWeeklySchedule() {
        // Assuming getWeeklySchedule returns a List of Flight objects
        assertNotNull(ScheduleModule.getWeeklySchedule());
    }
}