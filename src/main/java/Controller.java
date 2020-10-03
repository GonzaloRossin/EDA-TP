import model.BusInPath;
import model.PlaceLocation;
import utils.BusStop;
import utils.Graph;
import utils.PathSolver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controller {

    PathSolver pathSolver;

  public Controller() {
      List<BusStop> busStops = ResourceReader.getBusStops();
      Graph graph = new Graph(busStops);
      graph.makeEdges();
      this.pathSolver = new PathSolver(graph);
  }

  public List<BusInPath> findPath(double fromLat, double fromLng, double toLat, double toLng) {
    return pathSolver.findPath(fromLat, fromLng, toLat, toLng);
  }

  public List<PlaceLocation> findPlaces(String searchTerm) {
    return Arrays.asList(ResourceReader.getTop10(searchTerm));
  }
}
