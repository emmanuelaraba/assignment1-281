package nz.ac.auckland.se281;

public class Music extends Service {
  private String musicType;
  private int musicCost;

  public Music(
      String serviceName,
      String bookingReference,
      String serviceDate,
      String customerEmail,
      String serviceAntendees,
      String musicType,
      int musicCost) {
    super(serviceName, bookingReference, serviceDate, customerEmail, serviceAntendees);
    this.musicType = musicType;
    this.musicCost = musicCost;
  }

  public String getType() {
    return musicType;
  }

  public int getCost() {
    return musicCost;
  }
}
