package utils;

import java.util.Objects;

public class BusStop {
    private Integer busLine;
    private String route;
    private String branch;
    private Double latitude;
    private Double longitude;
    private String stopName;

    public BusStop(Integer busLine, String route, String stopName, String branch, Double latitude, Double longitude) {
        this.busLine = busLine;
        this.route = route;
        this.branch = branch;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stopName = stopName;
    }

    public String getStopName() {
        return stopName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getBusLine() {
        return busLine;
    }

    public String getBranch() {
        return branch;
    }

    public String getRoute() {
        return route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return Objects.equals(busLine, busStop.busLine) &&
                Objects.equals(route, busStop.route) &&
                Objects.equals(branch, busStop.branch) &&
                Objects.equals(latitude, busStop.latitude) &&
                Objects.equals(longitude, busStop.longitude) &&
                Objects.equals(stopName, busStop.stopName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busLine, route, branch, latitude, longitude, stopName);
    }

    @Override
    public String toString() {
        return "Bus " + getBusLine() + " Route: " + getRoute() + " Branch: " + getBranch() + " Lat: " + getLatitude() + " Long: " + getLongitude();
    }
}
