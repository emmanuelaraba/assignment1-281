package nz.ac.auckland.se281;

public class Booking {
  private String bookingReference;
  private String customerEmail;
  private String bookingDate;
  private String venueCode;
  private String numberOfGuests;

  // initialising the system date
  private String systemDate = null;

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

  // method to find the next available date for the venue
  public void findNextAvailableDate() {}

  public void setSystemDate(String inputDate) {
    this.systemDate = inputDate;
  }

  public String getSystemDate() {
    return this.systemDate;
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
