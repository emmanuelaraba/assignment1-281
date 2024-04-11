package nz.ac.auckland.se281;

public class Floral extends Service {
  private String floralType;
  private String floralCost;

  public Floral(
      String bookingReference,
      String serviceDate,
      String customerEmail,
      String serviceAntendees,
      String floralType,
      String floralCost) {
    super(bookingReference, serviceDate, customerEmail, serviceAntendees);
    this.floralType = floralType;
    this.floralCost = floralCost;
  }

  public String getType() {
    return floralType;
  }

  public String getCost() {
    return floralCost;
  }
}
