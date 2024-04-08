package nz.ac.auckland.se281;

public class Booking {
  private String bookingReference;
  private String customerEmail;
  private String bookingDate;
  private String partyDate;
  private String venueCode;
  private String numberOfGuests;

  public Booking(
      String bookingReference,
      String customerEmail,
      String bookingDate,
      String partyDate,
      String venueCode,
      String numberOfGuests) {
    this.bookingReference = bookingReference;
    this.customerEmail = customerEmail;
    this.bookingDate = bookingDate;
    this.partyDate = partyDate;
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

  public String getPartyDate() {
    return partyDate;
  }

  public String getVenueCode() {
    return venueCode;
  }

  public String getNumberOfGuests() {
    return numberOfGuests;
  }
}
