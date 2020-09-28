import model.BusInPath;
import model.PlaceLocation;
import utils.Graph;
import utils.Qgrams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ResourceReader {
    public static List<PlaceLocation> getSites(){

        String Path="C:\\Users\\gonza\\Downloads\\TP EDA - Base\\src\\main\\resources\\espacios-culturales.csv";
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
    public Map<Integer, Map<String, ArrayList<PlaceLocation>>> getBusStops() {
        String Path="G:\\EDA\\EDA-TP\\src\\main\\resources\\paradas-de-colectivo.csv";
        String line;

        Map<Integer, Map<String, ArrayList<PlaceLocation>>> holder = new HashMap<>();
        try {
            BufferedReader buffer= new BufferedReader(new FileReader(Path));
            buffer.readLine();
            List<PlaceLocation> sites=new ArrayList<>();
            while((line=buffer.readLine())!=null){
                String[] value=line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                parseData(holder, Double.parseDouble(value[3]), Double.parseDouble(value[4]), Integer.parseInt(value[7]), value[8], value[10]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return holder;
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
    public static PlaceLocation[] getTop10(String searchterm){
        int qgrams=8;
        searchterm=searchterm.toUpperCase();
        PlaceLocation[] top10=new PlaceLocation[10];
        boolean flag;
        Arrays.fill(top10,null);
        for(PlaceLocation database:getSites()){
            flag=false;
            double similarity= Qgrams.similarity(searchterm,database.getName(),qgrams);
            PlaceLocation candidate=database;
            for(int i=0;i< top10.length && !flag;i++){
                if(top10[i]==null){
                    top10[i]=candidate;
                    flag=true;
                }else if(similarity>Qgrams.similarity(searchterm,top10[i].getName(),qgrams)) {
                    similarity=Qgrams.similarity(searchterm,top10[i].getName(),qgrams);
                    PlaceLocation aux=top10[i];
                   top10[i]=candidate;
                   candidate=aux;
                }
            }
        }
        return top10;
    }
}
