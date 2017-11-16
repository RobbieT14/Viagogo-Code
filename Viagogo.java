import java.util.*;

class Viagogo
{

  public static void main(String[] args)
  {
    Coordinates c = new Coordinates(); //objects referring to Coordinates class

    addRandomEvent(c);

// Allows user to input coordinate between the range -10 to 10
  boolean end = false;
  String[] numbers = new String[2];
  while(!end)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a coordinate (x and y separated by a space)");
    String line = input.nextLine();
    numbers = line.trim().split(" +");
    int c1 = Integer.parseInt(numbers[0]);
    int c2 = Integer.parseInt(numbers[1]);
    if(c1 >= -10 && c1 <= 10 && c2 >= -10 && c2 <=10) end = true;
    if(!end)
      System.out.println("Coordinates must be between -10 and 10");
  }

    int[] integers = new int[numbers.length];
// stores coordinate into integer array
    for(int i=0; i<numbers.length; i++)
        integers[i] = Integer.parseInt(numbers[i]);

// Calculates the distances for events located around the given coordinate and stores them in ArrayList
    ArrayList<Event> ClosestEvent = c.ClosestEvent(integers);

// Prints out top 5 events which are located cloeset to the given coordinate
    for(int i=0; i<ClosestEvent.size(); i++)
    {
      System.out.println("Event " + ClosestEvent.get(i).getID() + " - $" +ClosestEvent.get(i).getPrice() + ", Distance " +ClosestEvent.get(i).getDistance());
    }
  }


//adds event to random coordinate
  public static void addRandomEvent(Coordinates c)
  {
    Random rn = new Random();
    int randomTile = rn.nextInt(440) +1;  //random number of events
    for(int i = 0; i < randomTile; i++) // creates 'randomTile' number of events
      {

        int randomAxis = rn.nextInt(19) + 1; //random x-coordinate
        int randomAxis2 = rn.nextInt(19) + 1; // random y-coordinate
        double randomPrice = (1+(rn.nextDouble() * (999 - 1))); // random price with max being $1000

        Event e = new Event(i,randomPrice); // creates and event with EventID and price
        c.add(randomAxis, randomAxis2, e ); // adds event into the coordinate
      }

  }


}
