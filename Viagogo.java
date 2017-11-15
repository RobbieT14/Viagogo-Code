import java.util.*;

class Viagogo
{
  public static void addRandomEvent(Coordinates c)  //adds event to random coordinate
  {

    Random rn = new Random();
    int randomTile = rn.nextInt(440) +1;  //random number of events
    for(int i = 0; i < randomTile; i++)
      {

        int randomAxis = rn.nextInt(19) + 1;
        int randomAxis2 = rn.nextInt(19) + 1;
        double randomPrice = (1+(rn.nextDouble() * (999 - 1)));

        Event e = new Event(i,randomPrice);
        c.add(randomAxis, randomAxis2, e );
      }

  }

  public static void main(String[] args)
  {
    Coordinates c = new Coordinates(); //objects referring to Coordinates class

    addRandomEvent(c);

    Scanner input = new Scanner(System.in);
    System.out.println("Enter a coordinate (x and y separated by a space)");
    String line = input.nextLine();
    String[] numbers = line.trim().split(" +");
    int[] integers = new int[numbers.length];

    for(int i=0; i<numbers.length; i++)
        integers[i] = Integer.parseInt(numbers[i]);


    ArrayList<Event> ClosestEvent = c.ClosestEvent(integers);

    for(int i=0; i<ClosestEvent.size(); i++)
    {
      System.out.println("Event " + ClosestEvent.get(i).getID() + " " +ClosestEvent.get(i).getPrice() + " " +ClosestEvent.get(i).getDistance());
    }
  }



}
