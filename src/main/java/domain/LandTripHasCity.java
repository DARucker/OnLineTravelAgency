package domain;

public class LandTripHasCity {

    private int cityId;
    private int landTripId;
    private String name;

    public LandTripHasCity(int cityId, int landTripId) {
        this.cityId = cityId;
        this.landTripId = landTripId;
    }

    public LandTripHasCity(int cityId, int landTripId, String name) {
        this.cityId = cityId;
        this.landTripId = landTripId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LandTripHasCity() {
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getLandTripId() {
        return landTripId;
    }

    public void setLandTripId(int landTripId) {
        this.landTripId = landTripId;
    }

    @Override
    public String toString() {

        return name.toUpperCase();
    }
}
