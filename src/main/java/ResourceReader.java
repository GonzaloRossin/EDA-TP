import model.BusInPath;
import model.PlaceLocation;
import utils.Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ResourceReader {
    public List<PlaceLocation> getSites(){
        String Path="C:\\Users\\gonza\\Downloads\\TP EDA - Base\\src\\main\\resources\\espacios-culturales";
        String line;
        List<PlaceLocation> sites=new ArrayList<>();
        try {

            BufferedReader buffer= new BufferedReader(new FileReader(Path));
            buffer.readLine();
            while((line=buffer.readLine())!=null){
                String[] value=line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                sites.add(new PlaceLocation(value[3], Double.parseDouble(value[13]), Double.parseDouble(value[14])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sites;
    }
    public static void main(String[] args) {
        String Path="G:\\EDA\\EDA-TP\\src\\main\\resources\\paradas-de-colectivo.csv";
        String line;
        Graph busGraph=new Graph(false);
        Map<Integer, Map<String, ArrayList<PlaceLocation>>> holder = new HashMap<>();
        try {
            BufferedReader buffer= new BufferedReader(new FileReader(Path));
            buffer.readLine();
            List<PlaceLocation> sites=new ArrayList<>();
            while((line=buffer.readLine())!=null){
                String[] value=line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                parseData(holder, Double.parseDouble(value[3]), Double.parseDouble(value[4]), Integer.parseInt(value[7]), value[8], value[10]);
                //busGraph.addNode();
                //sites.add(new PlaceLocation(value[3], Double.parseDouble(value[13]), Double.parseDouble(value[14])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }

    public static void parseData(Map<Integer, Map<String, ArrayList<PlaceLocation>>> holder, Double stop_lat, Double stop_lon, int agency_id, String route_short_name, String route_desc) {
            if(!holder.containsKey(agency_id)) {
                HashMap<String, ArrayList<PlaceLocation>> routes = new HashMap<>();
                ArrayList<PlaceLocation> stops = new ArrayList<>();
                stops.add(new PlaceLocation(route_desc, stop_lat, stop_lon));
                routes.put(route_short_name, stops);
                holder.put(agency_id, routes);
            } else {
                Map<String, ArrayList<PlaceLocation>> routes = holder.get(agency_id);
                ArrayList<PlaceLocation> stops;
                if(!routes.containsKey(route_short_name)) {
                    stops = new ArrayList<>();

                } else {
                    stops = routes.get(route_short_name);
                }
                stops.add(new PlaceLocation(route_desc, stop_lat, stop_lon));
                routes.put(route_short_name, stops);
                holder.put(agency_id, routes);
            }
    }

}
