package utils;

import java.util.List;
import java.util.Set;

public class NodeMatrix {
    final int ROW = 100;
    final int COL = 100;
    double minLat = 0 , minLon = 0 , maxLat = 0 , maxLon = 0 ;
    private NodeSet[][] matrix;
    public NodeMatrix(List<BusStop> busStopList) {
        matrix = new NodeSet[ROW][COL];
        getMaxMinData(busStopList);
    }

    private void getMaxMinData(List<BusStop> busStops) {
        BusStop aux = busStops.get(0);
        minLat = maxLat = aux.getLatitude();
        minLon = maxLon = aux.getLongitude();
        for(BusStop busStop : busStops) {
            double busLat = busStop.getLatitude();
            double busLon = busStop.getLongitude();
            if(busLat >= maxLat) maxLat = busLat;
            if(busLat <= minLat) minLat = busLat;
            if(busLon >= maxLon) maxLon = busLon;
            if(busLon <= minLon) minLon = busLon;
        }
    }

    public NodeSet[][] getMatrix() {
        return matrix;
    }

    private double getNodeXRange() {
        return (maxLon - minLon) / ROW;
    }

    private double getNodeYRange() {
        return (maxLat - minLat) / COL;
    }

    private int longitudeToRow(double longitude) {
        int r = (int) (Math.floor((longitude - minLon) / getNodeXRange()));
        return r == 100 ? 99 : r;
    }

    private int latitudeToCol(double latitude) {
        int r = (int) (Math.floor((latitude - minLat) / getNodeYRange()));
        return r == 100 ? 99 : r;
    }

    public void insertBusStop(BusStop busStop) {
        int row = longitudeToRow(busStop.getLongitude());
        int col = latitudeToCol(busStop.getLatitude());
        if(matrix[row][col] == null) {
            matrix[row][col] = new NodeSet();
        }
        matrix[row][col].getNodeSet().add(new Node(busStop));
    }


}
