package nz.ac.auckland.se281;

public class Catering extends Service {
  private String cateringType;
  private int cateringCost;

  public Catering(
      String serviceName,
      String bookingReference,
      String systemDate,
      String serviceDate,
      String customerEmail,
      String serviceAntendees,
      String cateringType,
      int cateringCost) {
    super(serviceName, bookingReference, systemDate, serviceDate, customerEmail, serviceAntendees);
    this.cateringType = cateringType;
    this.cateringCost = cateringCost;
  }

  @Override
  public String getType() {
    return cateringType;
  }

  @Override
  public int getCost() {
    return cateringCost;
  }
}
