package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  // creates new venue list to store the names of the venues
  private ArrayList<Venue> venueList;

  public VenueHireSystem() {
    // when the class is called, create a new array to store the venues in
    this.venueList = new ArrayList<>();
  }
  
  public void printVenues() {
    // checking if the array that contains the venues is empty
    if (this.venueList.size() == 0){
      MessageCli.NO_VENUES.printMessage();
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // creates new venue and adds it to the array of created venues 
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    // tests for checking if the venueName is empty
    if (venueName.isEmpty()){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    } else if (Integer.parseInt(capacityInput) < 0){
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity ", " positive");
    } else {
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
    }
    venueList.add(newVenue);
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
