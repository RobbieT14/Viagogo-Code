import java.util.*;

class Coordinates
{
  final int x = 20;
  final int y = 20;

  private Event[][] world = new Event[x][y];

  public Coordinates()
  {

  }

  public void add(int x, int y, Event obj)
  {
    world[x][y] = obj;
  }

  public ArrayList<Event> ClosestEvent(int[] coordinates)
  {
    int[] userCoord = {(coordinates[0]+10), (10-coordinates[1])};
    ArrayList<int[]> actualEvents = new ArrayList<int[]>();

    for(int i=0; i<world.length; i++)
    {
      for(int j=0; j<world.length-1; j++)
      {
        if(world[i][j] instanceof Event)
        {
          int[] a = {i,j};
          actualEvents.add(a);
        }
      }
    }
      int[] dist = new int[actualEvents.size()];
      Event[] pos = new Event[actualEvents.size()];

      for(int i=0; i< actualEvents.size(); i++)
      {
          dist[i] = Math.abs(actualEvents.get(i)[0]-userCoord[0]) + Math.abs(actualEvents.get(i)[1]-userCoord[1]);
          pos[i] = world[actualEvents.get(i)[0]][actualEvents.get(i)[1]];
        }

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
