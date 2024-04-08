package nz.ac.auckland.se281;

import java.util.*;

public class Booking {
  private String bookingReference;
  private String customerEmail;
  private String bookingDate;
  private String venueCode;
  private String numberOfGuests;

  private Map<String, String> bookings;

  public Booking(
      String bookingReference,
      String customerEmail,
      String bookingDate,
      String venueCode,
      String numberOfGuests) {
    this.bookingReference = bookingReference;
    this.customerEmail = customerEmail;
    this.bookingDate = bookingDate;
    this.venueCode = venueCode;
    this.numberOfGuests = numberOfGuests;
  }

  public String getBookingReference() {
    return bookingReference;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public String getBookingDate() {
    return bookingDate;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public String getNumberOfGuests() {
    return numberOfGuests;
  }
}
