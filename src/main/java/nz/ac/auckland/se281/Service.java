package nz.ac.auckland.se281;

public abstract class Service {
  protected String bookingReference;
  protected String serviceDate;
  protected String customerEmail;
  protected String serviceAntendees;

  // make constructor protected to prevent instantiation
  protected Service(
      String bookingReference, String serviceDate, String customerEmail, String serviceAntendees) {
    this.bookingReference = bookingReference;
    this.serviceDate = serviceDate;
    this.customerEmail = customerEmail;
    this.serviceAntendees = serviceAntendees;
  }

  // abstract method to be implemented by subclasses

}
