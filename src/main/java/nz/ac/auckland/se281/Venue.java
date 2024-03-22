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

  public void setvenueName(String venueName){
    this.venueName = venueName;
  }

  public String getvenueName(){
    return this.venueName;
  }

  public void setvenueCode(String venueCode){
      this.venueCode = venueCode;
  }

  public String getvenueCode(){
    return this.venueCode;
  }

  public void setcapacityInput(String capacityInput){
    this.capacityInput = capacityInput;
  }

  public String getcapacityInput(){
    return this.capacityInput;
  }

  public void sethireFeeInput(String hireFeeInput){
    this.hireFeeInput = hireFeeInput;
  }
  
  public String gethireFeeInput(){
    return this.hireFeeInput;
  }
}


