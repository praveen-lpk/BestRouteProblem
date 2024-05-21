package lucidity;

public class Consumer {
    private final String name;
    private final GeoLocation location;

    public Consumer(String name, GeoLocation location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public GeoLocation getLocation() {
        return location;
    }
}
