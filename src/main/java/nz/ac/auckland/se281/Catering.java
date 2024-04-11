package nz.ac.auckland.se281;

public class Catering extends Service {
  private String cateringType;
  private int cateringCost;

  public Catering(
      String serviceName,
      String bookingReference,
      String serviceDate,
      String customerEmail,
      String serviceAntendees,
      String cateringType,
      int cateringCost) {
    super(serviceName, bookingReference, serviceDate, customerEmail, serviceAntendees);
    this.cateringType = cateringType;
    this.cateringCost = cateringCost;
  }

  public String getType() {
    return cateringType;
  }

  public int getCost() {
    return cateringCost;
  }
}
