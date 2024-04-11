package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // creates new venue list to store the names of the venues
  private ArrayList<Venue> venueList;

  // create variable for the system date
  private String systemDate = null;

  // create a list of all the bookings
  private ArrayList<Booking> bookingList;

  // create a list of all the services
  private ArrayList<Service> serviceList;

  public VenueHireSystem() {

    // when a new venuehiresystem object is instantiated, create a new array to store the venues in
    this.venueList = new ArrayList<>();

    // create a new array to store the bookings in
    this.bookingList = new ArrayList<>();
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
            findNextAvailableDate(venue.getVenueCode()));
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
            findNextAvailableDate(venue.getVenueCode()));
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
            findNextAvailableDate(venue.getVenueCode()));
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
    // checking if the input is empty, otherwise setting the system date
    if (dateInput != null) {
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
    // first parse the options that are inputted into the method
    String venueCode = options[0];
    String intendedDate = options[1];
    String clientEmail = options[2];
    String intendedGuests = options[3];

    // boolean to check is booking passes all the tests
    boolean valid = true;

    // finding if the venue code is in the system, and also finding the venue
    Venue venue = null;
    for (Venue venue1 : venueList) {
      if (venue1.getVenueCode().equals(venueCode)) {
        venue = venue1;
        valid = true;
        break;
      } else {
        valid = false;
      }
    }
    // if the venue is not found, print the message
    if (!valid) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(venueCode);
    }

    // test to make sure that a system date is set, and check if the intended date is not in the
    // past
    if (valid) {
      if (systemDate == null) {
        MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
        valid = false;
        // check if date is not before intended date
      } else {
        String[] systemDateSplit = systemDate.split("/");
        String[] intendedDateSplit = intendedDate.split("/");
        // first compare the year
        if (Integer.parseInt(intendedDateSplit[2]) < Integer.parseInt(systemDateSplit[2])) {
          MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(intendedDate, systemDate);
          // then compare the month
        } else if (Integer.parseInt(intendedDateSplit[1]) < Integer.parseInt(systemDateSplit[1])) {
          MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(intendedDate, systemDate);
          // last, compare the day
        } else if (Integer.parseInt(intendedDateSplit[0]) < Integer.parseInt(systemDateSplit[0])) {
          MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(intendedDate, systemDate);
        } else {
          // if all tests pass, the date is valid
          valid = true;
        }
      }
    }

    // check if there are venues in the system
    if (valid) {
      if (venueList.size() == 0) {
        MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
        valid = false;
      }
    }

    // test to make sure the number of attendees is more than 25% of the venue capacity and not more
    // than the venue
    // capacity
    if (valid) {
      if (Integer.parseInt(intendedGuests) < (Integer.parseInt(venue.getCapacityInput()) * 0.25)) {
        int intGuests = (int) (Integer.parseInt(venue.getCapacityInput()) * 0.25);
        String newGuests = String.valueOf(intGuests);
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
            intendedGuests, newGuests, venue.getCapacityInput());
        // adjusting the intended guests to 25% of the venue capacity
        intendedGuests = newGuests;
      } else if (Integer.parseInt(intendedGuests) > Integer.parseInt(venue.getCapacityInput())) {
        // adjust number of guests to the venue capacity
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
            intendedGuests, venue.getCapacityInput(), venue.getCapacityInput());
        valid = true;
        // adjusting the intended guests to the venue capacity
        intendedGuests = String.valueOf(Integer.parseInt(venue.getCapacityInput()));
      }
    }

    // now we have the venue and the venue attributes, we can check if the venue is already booked
    if (valid) {
      for (Booking booking : bookingList) {
        if (booking.getVenueCode().equals(venue.getVenueCode())
            && booking.getBookingDate().equals(intendedDate)) {
          MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(
              venue.getVenueName(), intendedDate);
          valid = false;
        }
      }
    }

    // finally, if all the tests pass, we can create a new booking and store it in our booking array
    if (valid) {
      String bookingReference = BookingReferenceGenerator.generateBookingReference();
      Booking newBooking =
          new Booking(bookingReference, clientEmail, intendedDate, venueCode, intendedGuests);
      bookingList.add(newBooking);
      newBooking.setSystemDate(systemDate);
      MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
          newBooking.getBookingReference(),
          venue.getVenueName(),
          newBooking.getBookingDate(),
          newBooking.getNumberOfGuests());
    }
  }

  public String findNextAvailableDate(String venueCode) {
    boolean valid = true;

    // find the venue code in the system
    Venue venue = null;
    for (Venue venue1 : venueList) {
      if (venue1.getVenueCode().equals(venueCode)) {
        venue = venue1;
        valid = true;
        break;
      } else {
        valid = false;
      }
    }
    // if system date is null, return ""
    if (systemDate == null) {
      return "";
    }

    // if there are no booking in the system and just venues, then the next available date is the
    // system date
    if (bookingList.size() == 0) {
      return systemDate;
    }

    String availableDate = systemDate;
    if (valid) {
      String[] systemDateSplit = systemDate.split("/");
      int day = Integer.parseInt(systemDateSplit[0]);
      int month = Integer.parseInt(systemDateSplit[1]);
      int year = Integer.parseInt(systemDateSplit[2]);
      boolean dateIsBooked;
      do {
        dateIsBooked = false;
        for (Booking booking : bookingList) {
          if (booking.getVenueCode().equals(venue.getVenueCode())) {
            String[] bookingDateSplit = booking.getBookingDate().split("/");
            int bookingDay = Integer.parseInt(bookingDateSplit[0]);
            int bookingMonth = Integer.parseInt(bookingDateSplit[1]);
            int bookingYear = Integer.parseInt(bookingDateSplit[2]);
            if (day == bookingDay && month == bookingMonth && year == bookingYear) {
              dateIsBooked = true;
              break;
            }
          }
        }
        if (dateIsBooked) {
          day++;
          if (day > 31) { // simple check, does not account for different month lengths
            day = 1;
            month++;
            if (month > 12) {
              month = 1;
              year++;
            }
          }
        }
      } while (dateIsBooked);
      availableDate = String.format("%02d/%02d/%04d", day, month, year);
    }
    return availableDate;
  }

  public void printBookings(String venueCode) {
    // find the venue code in the system
    Venue venue = null;
    boolean valid = true;
    for (Venue venue1 : venueList) {
      if (venue1.getVenueCode().equals(venueCode)) {
        venue = venue1;
        valid = true;
        break;
      } else {
        valid = false;
      }
    }
    // if the venue is not found, print the message
    if (!valid) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    }

    // if the venue is found, print the bookings
    if (valid) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venue.getVenueName());
      boolean bookingsExist = false;
      for (Booking booking : bookingList) {
        if (booking.getVenueCode().equals(venue.getVenueCode())) {
          MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(
              booking.getBookingReference(), booking.getBookingDate());
          bookingsExist = true;
        }
      }
      // if there are no bookings, print the message
      if (!bookingsExist) {
        MessageCli.PRINT_BOOKINGS_NONE.printMessage(venue.getVenueName());
      }
    }
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    boolean valid = true;
    // checking if there are bookings in the system
    if (bookingList.size() == 0) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
      valid = false;
    }

    // check if the booking reference is in the system
    Booking booking = null;
    for (Booking booking2 : bookingList) {
      if (booking2.getBookingReference().equals(bookingReference)) {
        booking = booking2;
        valid = true;
        break;
      } else {
        MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
        valid = false;
      }
    }
    // calculate the total cost of the catering
    int totalCost = cateringType.getCostPerPerson() * Integer.parseInt(booking.getNumberOfGuests());

    // final output if all checks pass
    if (valid) {
      Catering newCatering =
          new Catering(
              cateringType.getName(),
              bookingReference,
              booking.getSystemDate(),
              booking.getBookingDate(),
              booking.getCustomerEmail(),
              booking.getNumberOfGuests(),
              cateringType.getName(),
              totalCost);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(
          "Catering (" + cateringType.getName() + ")", bookingReference);
      serviceList.add(newCatering);
    }
  }

  public void addServiceMusic(String bookingReference) {
    boolean valid = true;
    // checking if there are bookings in the system
    if (bookingList.size() == 0) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
      valid = false;
    }

    // check if the booking reference is in the system
    Booking booking = null;
    for (Booking booking2 : bookingList) {
      if (booking2.getBookingReference().equals(bookingReference)) {
        booking = booking2;
        valid = true;
        break;
      } else {
        MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
        valid = false;
      }
    }

    if (valid) {
      Music newMusic =
          new Music(
              "Music",
              bookingReference,
              booking.getSystemDate(),
              booking.getBookingDate(),
              booking.getCustomerEmail(),
              booking.getNumberOfGuests(),
              500);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
      serviceList.add(newMusic);
    }
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    boolean valid = true;
    // checking if there are bookings in the system
    if (bookingList.size() == 0) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
      valid = false;
    }

    // check if the booking reference is in the system
    Booking booking = null;
    for (Booking booking2 : bookingList) {
      if (booking2.getBookingReference().equals(bookingReference)) {
        booking = booking2;
        valid = true;
        break;
      } else {
        MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
        valid = false;
      }
    }
    int totalCost = floralType.getCost() + Integer.parseInt(booking.getNumberOfGuests());
    if (valid) {
      Floral newFloral =
          new Floral(
              floralType.getName(),
              bookingReference,
              booking.getSystemDate(),
              booking.getBookingDate(),
              booking.getCustomerEmail(),
              booking.getNumberOfGuests(),
              floralType.getName(),
              totalCost);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Floral", bookingReference);
      serviceList.add(newFloral);
    }
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
