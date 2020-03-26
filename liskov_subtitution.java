/* 
 * 
 * Example for Liskov Subtitution princicle
 *
 */

//====================================================================================================================
// 
// A "watch" class
//
//   General feature
//     Tell time: hour, minute and second
//
//   Additional feature for electronic watch
//     Timer
//
//   Additional feature for smart watch
//     Receive call
//
//
//====================================================================================================================



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Bad example
//
// The watch class includes the "timer" and the "Receive call" feature which is not available in mechanical watch or
// automatic watch.
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

class watch
{
  private int hour;
  private int minute;
  private int second;

  private void setTime(int getHour, int getMinute, int getSecond){
    hour = getHour;
    minute = getMinute;
    second = getSecond;
  }

  private void displayTime(){
    System.out.println("%d:%d:%d",hour,minute,second);
  }

  private int counter;
  
  private void setTimer(int getCounter){
    counter = getCounter;
  }

  private void startTimer(){
    System.out.println("Timer start...");
    for(int i = counter; i >= 0; i--){
      System.out.println("%d",i);
      TimeUnit.SECONDS.sleep(1);
    }
  }

  private void receiveCall(Phone phone){
    if ( phone.isRinging() ) {
      System.out.println("You have a call from %s", phone.getCallerName());
    }
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Good example
//
// The "watch" class only has time viewing feature which is a general feature for all types of watch.
//
// Other watch classes are an extention of the original watch class. Any object that uses the derived class can use
// the functions setTime() and displayTime() without any problem.
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

class watch {

  private int hour;
  private int minute;
  private int second;

  private void setTime(int getHour, int getMinute, int getSecond){
    hour = getHour;
    minute = getMinute;
    second = getSecond;
  }

  private void displayTime(){
    System.out.println("%d:%d:%d",hour,minute,second);
  }

}

class electronicsWatch extends watch {

  private int counter;
  
  private void setTimer(int getCounter){
    counter = getCounter;
  }

  private void startTimer(){
    System.out.println("Timer start...");
    for(int i = counter; i >= 0; i--){
      System.out.println("%d",i);
      TimeUnit.SECONDS.sleep(1);
    }
  }
}

class smartWatch extends electronicsWatch {

  private void receiveCall(Phone phone){
    if ( phone.isRinging() ) {
      System.out.println("You have a call from %s", phone.getCallerName());
    }
  }

}
