package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  private List<Venue> venues;

  public VenueHireSystem() {
    this.venues = new ArrayList<>();
  }
  
  private class Venue{
    String venueName;
    String venueCode;
    String capacityInput;
    String hireFeeInput;

    public Venue (String venueName, String venueCode, String capacityInput, String hireFeeInput){
      this.venueName = venueName;
      this.venueCode = venueCode;
      this.capacityInput = capacityInput;
      this.hireFeeInput = hireFeeInput;
    }
  }

  public void printVenues() {
    MessageCli.NO_VENUES.printMessage(null);
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    venues.add(newVenue);
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
