import java.util.*;

class Coordinates
{
  final int x = 20; //x-coord size
  final int y = 20; // y-coord size

  private Event[][] world = new Event[x][y]; // creates 20x20 2D array

// Adds random generated event into the 2D array
  public void add(int x, int y, Event obj)
  {
    world[x][y] = obj;
  }

// Finds the closest events from the inputted coordinate
  public ArrayList<Event> ClosestEvent(int[] coordinates)
  {
    int[] userCoord = {(coordinates[0]+10), (10-coordinates[1])}; // algorithm to relate x,y coordinate to 2D array position
    ArrayList<int[]> actualEvents = new ArrayList<int[]>();

    for(int i=0; i<world.length; i++)
    {
      for(int j=0; j<world.length-1; j++)
      {
        if(world[i][j] instanceof Event) // finds all events that exist in the 2D array
        {
          int[] a = {i,j};
          actualEvents.add(a); // stores positions of coordinate which has an Event
        }
      }
    }
      int[] dist = new int[actualEvents.size()]; // keeps track of distance of coordinates
      Event[] pos = new Event[actualEvents.size()]; // keeps track of position of coordinate for its calculated distance

      for(int i=0; i< actualEvents.size(); i++)
      {
          dist[i] = Math.abs(actualEvents.get(i)[0]-userCoord[0]) + Math.abs(actualEvents.get(i)[1]-userCoord[1]); //Manhattan distance algorithm
          pos[i] = world[actualEvents.get(i)[0]][actualEvents.get(i)[1]];
        }


// sorting of the distances 
      int n = dist.length;
      int temp = 0;
        Event tempEvent;

        for(int i=0; i < n; i++)
            for(int j=1; j < (n-i); j++)
              if(dist[j-1] < dist[j])
                {
                  tempEvent = pos[j-1];
                  //swap the elements descending
                  temp = dist[j-1];
                  pos[j-1] = pos[j];
                  dist[j-1] = dist[j];
                  pos[j] = tempEvent;
                  dist[j] = temp;
                }

// Prints out first 5 events as they will be the closest after sorting
      ArrayList<Event> topFive = new ArrayList<Event>();
      for(int i=0; i<dist.length; i++)
      {
        if(i == 5)
        {
          break;
        }
        else
        {
          pos[i].setDistance(dist[i]);
          topFive.add(pos[i]);
        }
      }
      return topFive;
}
}
