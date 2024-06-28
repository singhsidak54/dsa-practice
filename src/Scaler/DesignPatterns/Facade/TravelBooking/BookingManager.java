package Scaler.DesignPatterns.Facade.TravelBooking;

import Scaler.DesignPatterns.Facade.TravelBooking.services.*;
import Scaler.DesignPatterns.Facade.TravelBooking.models.*;

import java.time.LocalDate;

public class BookingManager {

    private BookingManagerFacade bookingManagerFacade;

    public BookingManager(AvailabilityService availabilityService, PaymentService paymentService,
                          NotificationService notificationService, LoyaltyService loyaltyService,
                          AccommodationDetailsService accommodationDetailsService) {
        this.bookingManagerFacade = new BookingManagerFacade(availabilityService, paymentService, notificationService, loyaltyService, accommodationDetailsService);
    }

    public BookingResult bookAccommodation(String userId, String accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
        return this.bookingManagerFacade.bookAccommodation(userId, accommodationId, checkInDate, checkOutDate);
    }
}