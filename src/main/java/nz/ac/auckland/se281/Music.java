package nz.ac.auckland.se281;

public class Music extends Service {
  private String musicType;
  private int musicCost = 500;

  public Music(
      String serviceName,
      String bookingReference,
      String systemDate,
      String serviceDate,
      String customerEmail,
      String serviceAntendees,
      int musicCost) {
    super(serviceName, bookingReference, systemDate, serviceDate, customerEmail, serviceAntendees);
    this.musicCost = 500;
  }

  @Override
  public String getType() {
    return musicType;
  }

  @Override
  public int getCost() {
    return musicCost;
  }
}
