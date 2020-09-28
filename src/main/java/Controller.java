import model.BusInPath;
import model.PlaceLocation;
import utils.BusStop;
import utils.Graph;

import java.util.Arrays;
import java.util.List;

public class Controller {

  public Controller() {
      List<BusStop> busStops = ResourceReader.getBusStops();
      Graph graph = new Graph(busStops);
      System.out.println("Done");
  }

  public List<BusInPath> findPath(double fromLat, double fromLng, double toLat, double toLng) {
    return Arrays.asList(new BusInPath("No implementado", 0, 0, 0, 0));
  }

  public List<PlaceLocation> findPlaces(String searchTerm) {
    return Arrays.asList(ResourceReader.getTop10(searchTerm));
  }
}
