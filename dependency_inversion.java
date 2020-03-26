/* 
 * 
 * Example for Dependency Inversion princicle
 *
 */

//====================================================================================================================
// 
// Consider a method that need to grab data from different sources such as database and local file... and print the
// data on the screen.
//
//====================================================================================================================



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Bad example
//
// The displayData() class is directly coupled with the getDataFromLocal() class
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

public class getDataFromLocal() {
  private ArrayList<String> data = new ArrayList<String>();
  public void readFile(Scanner scanner) {
    if ( scanner.hasNext() ) {
      data.add(scanner.nextLine());
    }
  }
  public ArrayList<String> getData (Scanner scanner) {
    readFile(scanner);
    if ( data.isEmpty() ){
      System.out.println("No data found!");
      return data; 
    }else{
      return data;
    }
  }
}

public class displayData() {
   public getDataFromLocal source;
   private ArrayList<String> data = new ArrayList<String>();
   public display(getDataFromLocal source, String[] fileName) {
     data = source.getData ( fileName );
     for (int i = 0; i < data.length; i++) {
       System.out.print("%s",data[i]);
     }
   }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Good example
//
// Implementing an interface to couple the low-level and high-level classes
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

public interface dataSource {
  void readFile();
  ArrayList<String> getData();
}

public class getDataFromLocal() implements dataSource {
  private ArrayList<String> data = new ArrayList<String>();

  @Override
  public void readFile(Scanner scanner) {
    if ( scanner.hasNext() ) {
      data.add(scanner.nextLine());
    }
  }

  @Override
  public ArrayList<String> getData (Scanner scanner) {
    readFile(scanner);
    if ( data.isEmpty() ){
      System.out.println("No data found!");
      return data; 
    }else{
      return data;
    }
  }
}


public class getDataFromGoogleDrive() implements dataSource {
  private ArrayList<String> data = new ArrayList<String>();

  @Override
  public void readFile(Scanner scanner) {
	  // readFile on google drive
    }
  }

  @Override
  public ArrayList<String> getData (Scanner scanner) {
	 // return the data in the file
    }
  }
}

public class displayData() {
   public dataSource source;
   private ArrayList<String> data = new ArrayList<String>();
   public display(dataSource source, String[] fileName) {
     data = source.getData ( fileName );
     for (int i = 0; i < data.length; i++) {
       System.out.print("%s",data[i]);
     }
   }
}
