package lucidity;

class GeoLocation {
    private final double latitude;
    private final double longitude;

    private static final double EARTH_RADIUS = 6371;

    public GeoLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    /**
     * This method calculates the distance with help of harvesine formula
     *
     * @param location destination location
     * @return returns harvesine distance
     */
    public double distanceTo(GeoLocation location) {

        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(location.getLatitude());
        double lon2 = Math.toRadians(location.getLongitude());

        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double squaredHalfChordLength = Math.pow(Math.sin(deltaLat / 2), 2) +
                Math.pow(Math.sin(deltaLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double centralAngle = 2 * Math.asin(Math.sqrt(squaredHalfChordLength));
        return EARTH_RADIUS * centralAngle;
    }
}
