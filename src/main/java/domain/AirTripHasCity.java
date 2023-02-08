package domain;

public class AirTripHasCity {

    private int cityId;
    private int airTripId;
    private String name;

    public AirTripHasCity(int cityId, int airTripId) {
        this.cityId = cityId;
        this.airTripId = airTripId;
    }

    public AirTripHasCity(int cityId, int airTripId, String name) {
        this.cityId = cityId;
        this.airTripId = airTripId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirTripHasCity() {
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAirTripId() {
        return airTripId;
    }

    public void setAirTripId(int airTripId) {
        this.airTripId = airTripId;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
