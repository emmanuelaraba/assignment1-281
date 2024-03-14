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
    if (venueList.size() == 0){
      MessageCli.NO_VENUES.printMessage();
    } else if (venueList.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      for (Venue venue : venueList) {
        MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venue.getvenueName());
      }
    } else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(venueList.size()), "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(venue.getvenueName(), venue.getvenueCode(), venue.getcapacityInput(), venue.gethireFeeInput(), "");
      }
    }
  }

  public void createVenue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // creates new venue and adds it to the array of created venues 
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    boolean valid = true;
    // tests for checking if the venueName is empty
    if (venueName.isEmpty()){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      valid = false; 
    }
    // test to find if the venue has a positive capacity 
    if (valid){
      try {
        if (Integer.parseInt(capacityInput) < 0){
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
          valid = false;
        }
      } catch (Exception e){
        valid = false;
      }
    }
    // test case to check if the hire capacity is valid
    if (valid){
      try {
        Integer.parseInt(hireFeeInput);
      } catch (Exception e) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
        valid = false;
      }
    }
  
    // if all the tests pass and the new venue is valid, then print the success message 
    if (valid){
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
      venueList.add(newVenue);
    }

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
