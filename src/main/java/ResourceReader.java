import model.BusInPath;
import model.PlaceLocation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {

    public static void main(String[] args) {
        String Path="G:\\EDA\\EDA-TP\\src\\main\\resources\\espacios-culturales.csv";
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

    }
}
