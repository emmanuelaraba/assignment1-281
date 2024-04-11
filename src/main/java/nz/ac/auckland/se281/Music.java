package nz.ac.auckland.se281;

public class Music extends Service {
  private String musicType;
  private String musicCost;

  public Music(
      String bookingReference,
      String serviceDate,
      String customerEmail,
      String serviceAntendees,
      String musicType,
      String musicCost) {
    super(bookingReference, serviceDate, customerEmail, serviceAntendees);
    this.musicType = musicType;
    this.musicCost = musicCost;
  }

  public String getType() {
    return musicType;
  }

  public String getCost() {
    return musicCost;
  }
}
