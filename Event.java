import java.text.DecimalFormat;

class Event
{
  private int uniqueIdentifier;
  private int tickets;
  private double price;
  private int distance;

  public Event(int eventNo, double usd)
  {
    uniqueIdentifier = eventNo;
    price = usd;
  }

  public int getID()
  {
    return uniqueIdentifier;
  }

  public double getPrice()
  {
    DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(price));
  }

  public int getDistance()
  {
    return distance;
  }

  public void setDistance(int n)
  {
    distance = n;
  }

}
