/* 
 * 
 * Example for Open Close princicle
 *
 */

//====================================================================================================================
// A bank need to verify whether a client is a valid candidate for a loan or not. The candidate can be an individual,
// small business, large business, cooperation...
//====================================================================================================================
// input: a client instance
//====================================================================================================================
// output: valid or invalid
// ===================================================================================================================



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Bad example
// 
// The loanApproval() class has direct implementations for Individual() and smallBusiness() class.
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

public class Individual{
  private String name;
  private int age;
  private String sex;
  private String address;
  private double[] deposit;
  private double balance;
  private String[] returnRate; // early, on-time, late 

  public boolean isValid(){
    // the logic to check valid candidate
    if ( ( balance > 5000 ) && ( returnRate[returnRate.length-1] == "early" ) ){
      return true;
    }else{
      return false;
    }
  }
}

public class smallBusiness{
  private String name;
  private String found_date;
  private String address;
  private double[] deposit;
  private double balance;
  private String[] returnRate; // early, on-time, late 

  public boolean isValid(){
    // the logic to check valid candidate
    if ( ( balance > 1000000) && ( returnRate[returnRate.length-1] == "early"  || returnRate[returnRate.length-1] == "on-time" ) ){
      return true;
    }else{
      return false;
    }
  }
}

public class loanApproval{

  public void individualRequest (Individual client) {
    if client.isValid(){
      System.out.println("Loan approved!");
    }else{
      System.out.println("Loan not approved!");
    }
  }

  public void smallBusinessRequest(smallBusiness client) {
    if client.isValid(){
      System.out.println("Loan approved!");
    }else{
      System.out.println("Loan not approved!");
    }
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Good example
// 
// Using an abstrct "client" class as an interface for client instance in the "loanApproval" class
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

public abstract class Client {
  public abstract boolean isValid();
}

public class Individual extends Client {
  private String name;
  private int age;
  private String sex;
  private String address;
  private double[] deposit;
  private double balance;
  private String[] returnRate; // early, on-time, late 

  public boolean isValid(){
    // the logic to check valid individual 
    if ( ( balance > 5000 ) && ( returnRate[returnRate.length-1] == "early" ) ){
      return true;
    }else{
      return false;
    }
  }
}

public class smallBusiness extends Client {
  private String name;
  private String found_date;
  private String address;
  private double[] deposit;
  private double balance;
  private String[] returnRate; // early, on-time, late 

  public boolean isValid(){
    // the logic to check valid small business
    if ( ( balance > 1000000) && ( returnRate[returnRate.length-1] == "early"  || returnRate[returnRate.length-1] == "on-time" ) ){
      return true;
    }else{
      return false;
    }
  }
}

public class loanApproval{

  public void clientRequest (Client client) {
    if client.isValid(){
      System.out.println("Loan approved!");
    }else{
      System.out.println("Loan not approved!");
    }
  }
}

