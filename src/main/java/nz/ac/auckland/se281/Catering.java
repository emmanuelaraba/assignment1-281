package nz.ac.auckland.se281;

public class Catering extends Service {
  private String cateringType;
  private String cateringCost;

  public Catering(
      String bookingReference,
      String serviceDate,
      String customerEmail,
      String serviceAntendees,
      String cateringType,
      String cateringCost) {
    super(bookingReference, serviceDate, customerEmail, serviceAntendees);
    this.cateringType = cateringType;
    this.cateringCost = cateringCost;
  }

  public String getType() {
    return cateringType;
  }

  public String getCost() {
    return cateringCost;
  }
}
