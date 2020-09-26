package model;

public class PlaceLocation {

  private double lat;
  private double lng;
  private String name;

  public PlaceLocation(String name,double lat,double lng) {
    this.lat=lat;
    this.lng=lng;
    this.name = name;
  }

  public double getLat() {
    return lat;
  }

  public double getLng() {
    return lng;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return  "{ lat=" + lat + ", lng=" + lng + ", name='" + name + '\'' + '}';
  }
}
