package nz.ac.auckland.se281;

public class Floral extends Service {
  private String floralType;
  private int floralCost;

  public Floral(
      String serviceName,
      String bookingReference,
      String serviceDate,
      String customerEmail,
      String serviceAntendees,
      String floralType,
      int floralCost) {
    super(serviceName, bookingReference, serviceDate, customerEmail, serviceAntendees);
    this.floralType = floralType;
    this.floralCost = floralCost;
  }

  public String getType() {
    return floralType;
  }

  public int getCost() {
    return floralCost;
  }
}
