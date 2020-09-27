import model.BusInPath;
import model.PlaceLocation;
import utils.Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {
    public List<PlaceLocation> getSites(){
        String Path="C:\\Users\\gonza\\Downloads\\TP EDA - Base\\src\\main\\resources\\espacios-culturales";
        String line;
        List<PlaceLocation> sites=new ArrayList<>();
        try {
            FileReader file=new FileReader(Path);
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
    public static void main(String[] args){
        String Path="C:\\Users\\gonza\\Downloads\\TP EDA - Base\\src\\main\\resources\\paradas-de-colectivo.csv";
        String line;
        Graph busGraph=new Graph(false);
        try {
            FileReader file=new FileReader(Path);
            BufferedReader buffer= new BufferedReader(new FileReader(Path));
            buffer.readLine();
            List<PlaceLocation> sites=new ArrayList<>();
            while((line=buffer.readLine())!=null){
                String[] value=line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                busGraph.addNode();
                sites.add(new PlaceLocation(value[3], Double.parseDouble(value[13]), Double.parseDouble(value[14])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }

}
