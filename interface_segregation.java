/* 
 * 
 * Example for Interface Segregation princicle
 *
 */

//====================================================================================================================
// 
// Consider an application that is used to manage the facilities of a room in a hotel. A hotel will have three types
// of rooms: economics, business, luxury. 
//   - Each room will have a room number, price, renting dates (start and end). 
//   - Business class room has an additional feature of serving lunch and diner at the room.
//   - Luxury class room provides access to massage, golf course, and 4 stars restaurant service.
//
//====================================================================================================================



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Bad example
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

public interface Room {
  void setNumber(int roomRumber);
  void setPrice(double roomPrice);
  void enableMealService(int roomNumber, int mealOrder); // mealOrder is a number that represents the order of the 
  							 // customer saved in the database.
                                                         // order consists of: the kind dishes, when to serve 
							 // (noon, night)
  void enableCampusService(int number);
}

public class economicsRoom implements Room {
  int number;
  double price;

  @Override
  public void setNumber(int roomNumber) {
    this.number = roomNumber; 
  }

  @Override
  public void setPrice(double roomPrice) {
    this.price = roomPrice;
  }

  @Override
  public void enableMealService(int roomNumber; int mealOrder){}

  @Override
  public void enableCampusService(int roomNumber; int mealOrder){}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Good example
//
// Implementing 3 different interfaces
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

public interface Room {
  void setNumber(int roomRumber);
  void setPrice(double roomPrice);
}

public interface businessClass {
  void enableMealService(int roomNumber, int mealOrder); // mealOrder is a number that represents the order of the 
  							 // customer saved in the database.
                                                         // order consists of: the kind dishes, when to serve 
							 // (noon, night)
}

public interface luxuryClass {
  void enableCampusService(int number);
}

public class economicsRoom implements Room {
  int number;
  double price;

  @Override
  public void setNumber(int roomNumber) {
    this.number = roomNumber; 
  }

  @Override
  public void setPrice(double roomPrice) {
    this.price = roomPrice;
  }
}

public class businessRoom implements Room, businessClass {
  int number;
  double price;

  @Override
  public void setNumber(int roomNumber) {
    this.number = roomNumber; 
  }

  @Override
  public void setPrice(double roomPrice) {
    this.price = roomPrice;
  }

  @Override
  public void enableMealService(int roomNumber; int mealOrder){}
}


public class luxuryRoom implements Room, businessClass, luxuryClass {
  int number;
  double price;

  @Override
  public void setNumber(int roomNumber) {
    this.number = roomNumber; 
  }

  @Override
  public void setPrice(double roomPrice) {
    this.price = roomPrice;
  }

  @Override
  public void enableMealService(int roomNumber; int mealOrder){}

  @Override
  public void enableCampusService(int roomNumber; int mealOrder){}
}
