package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // creates new venue list to store the names of the venues
  private ArrayList<Venue> venueList;
  // create variable for the system date
  private String systemDate;

  public VenueHireSystem() {

    // when the class is called, create a new array to store the venues in
    this.venueList = new ArrayList<>();
  }

  public void printVenues() {

    // list of the names of the numbers, to correspond to the number
    String[] prefixList = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    // checking if the array that contains the venues is empty
    if (venueList.size() == 0) {
      MessageCli.NO_VENUES.printMessage();

      // test case for one - contains different articles etc
    } else if (venueList.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getVenueName(),
            venue.getVenueCode(),
            venue.getCapacityInput(),
            venue.getHireFeeInput(),
            "");
      }

      // between 1 and 10 (exclusive), we need to write out the number format, not the word
    } else if ((venueList.size() > 1) & (venueList.size() < 10)) {
      MessageCli.NUMBER_VENUES.printMessage("are", prefixList[venueList.size() - 1], "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getVenueName(),
            venue.getVenueCode(),
            venue.getCapacityInput(),
            venue.getHireFeeInput(),
            "");
      }
      // 10 and above, print the number
    } else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(venueList.size()), "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getVenueName(),
            venue.getVenueCode(),
            venue.getCapacityInput(),
            venue.getHireFeeInput(),
            "");
      }
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    // boolean for checking if the new venue passes all the tests, must be true for the new instance
    // to be created
    boolean valid = true;

    // tests for checking if the venueName is empty
    if (valid) {
      if (venueName.isEmpty()) {
        MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
        valid = false;
      }
    }

    // test to find if the venue has a positive capacity
    if (valid) {
      try {
        if (Integer.parseInt(capacityInput) < 0) {
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
          valid = false;
        }
      } catch (Exception e) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
        valid = false;
      }
    }

    // test case to check if the hire capacity is valid
    if (valid) {
      try {
        Integer.parseInt(hireFeeInput);
      } catch (Exception e) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
        valid = false;
      }
    }

    // checking we don't have a duplicate venue code
    if (valid) {
      for (Venue venue : venueList) {
        if (venueCode.equals(venue.getVenueCode())) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venue.getVenueName());
          valid = false;
        }
      }
    }
    // checking if the hire fee is a positive number
    if (valid) {
      if (Integer.parseInt(hireFeeInput) < 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        valid = false;
      }
    }

    // if all the tests pass, then create a new venue instance, then print the success message
    if (valid) {

      // creates new venue instance
      Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
      venueList.add(newVenue);
    }
  }

  public void setSystemDate(String dateInput) {
    // checking if the date is empty, otherwise setting the system date
    if (!dateInput.isEmpty()) {
      MessageCli.DATE_SET.printMessage(dateInput);
    }
    systemDate = dateInput;
  }

  public void printSystemDate() {
    // checking if the system date is empty, otherwise printing the date
    if (systemDate == null) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      MessageCli.CURRENT_DATE.printMessage(systemDate);
    }
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
