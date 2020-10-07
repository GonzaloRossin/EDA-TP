import model.PlaceLocation;
import utils.QGrams;
import utils.Stop;
import utils.StopType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ResourceReader {
    private static List<PlaceLocation> getSites(){

        String Path="G:\\EDA\\EDA-TP\\src\\main\\resources\\espacios-culturales.csv";
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
    public static List<Stop> getStops() {
        String Path="G:\\EDA\\EDA-TP\\src\\main\\resources\\paradas-de-colectivo.csv";
        String line;

        List<Stop> stops = new ArrayList<>();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(Path));
            buffer.readLine();
            List<PlaceLocation> sites = new ArrayList<>();
            while((line=buffer.readLine())!=null){
                String[] value=line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                stops.add(new Stop(value[8], value[2], Double.parseDouble(value[3]), Double.parseDouble(value[4]), StopType.LINE));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Path="G:\\EDA\\EDA-TP\\src\\main\\resources\\estaciones-de-subte.csv";
        try {//Se cargan paradas de subte
            BufferedReader buffer = new BufferedReader(new FileReader(Path));
            buffer.readLine();
            while((line=buffer.readLine())!=null){
                String[] value=line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                stops.add(new Stop(value[4], value[3], Double.parseDouble(value[1]), Double.parseDouble(value[0]), StopType.SUBWAY));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stops;
    }

    public static PlaceLocation[] getTop10(String searchTerm){
        int qGrams = 2;
        searchTerm = searchTerm.toUpperCase();
        PlaceLocation[] top10 = new PlaceLocation[10];
        boolean flag;
        Arrays.fill(top10,null);
        for(PlaceLocation database : getSites()) {
            flag = false;
            double similarity = QGrams.similarity(searchTerm, database.getName(), qGrams);
            PlaceLocation candidate = database;
            for(int i = 0 ; i < top10.length && !flag; i++){
                if(top10[i] == null){
                    top10[i] = candidate;
                    flag = true;
                } else if(similarity > QGrams.similarity(searchTerm, top10[i].getName(), qGrams)) {
                    similarity = QGrams.similarity(searchTerm, top10[i].getName(), qGrams);
                    PlaceLocation aux= top10[i];
                    top10[i] = candidate;
                    candidate = aux;
                }
            }
        }
        return top10;
    }
}
