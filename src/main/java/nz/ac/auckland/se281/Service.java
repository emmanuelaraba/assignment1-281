package nz.ac.auckland.se281;

public abstract class Service {
  protected String serviceName;
  protected String bookingReference;
  protected String systemDate;
  protected String serviceDate;
  protected String customerEmail;
  protected String serviceAntendees;

  // make constructor protected to prevent instantiation
  protected Service(
      String serviceName,
      String bookingReference,
      String systemDate,
      String serviceDate,
      String customerEmail,
      String serviceAntendees) {
    this.serviceName = serviceName;
    this.bookingReference = bookingReference;
    this.systemDate = systemDate;
    this.serviceDate = serviceDate;
    this.customerEmail = customerEmail;
    this.serviceAntendees = serviceAntendees;
  }

  public String getServiceName() {
    return serviceName;
  }

  public String getBookingReference() {
    return bookingReference;
  }

  // abstract method to be implemented by subclasses
  public abstract String getType();

  public abstract int getCost();
}
