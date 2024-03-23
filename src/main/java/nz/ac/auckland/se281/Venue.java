package nz.ac.auckland.se281;

public class Venue {
  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;

  public Venue (String venueName, String venueCode, String capacityInput, String hireFeeInput){
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;
  }

  public void setVenueName(String venueName){
    this.venueName = venueName;
  }

  public String getVenueName(){
    return this.venueName;
  }

  public void setVenueCode(String venueCode){
      this.venueCode = venueCode;
  }

  public String getVenueCode(){
    return this.venueCode;
  }

  public void setCapacityInput(String capacityInput){
    this.capacityInput = capacityInput;
  }

  public String getCapacityInput(){
    return this.capacityInput;
  }

  public void setHireFeeInput(String hireFeeInput){
    this.hireFeeInput = hireFeeInput;
  }
  
  public String getHireFeeInput(){
    return this.hireFeeInput;
  }
}


