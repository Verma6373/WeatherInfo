@Component
public class WeatherApiClient {
    private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather";

    public String getWeather(double lat, double lon) {
        // Logic for calling OpenWeather API and fetching the weather
    }
}

@Component
public class GeocodeApiClient {
    private static final String GEOCODE_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";

    public Location getLatLong(String pincode) {
        // Logic for calling Geocode API and fetching latitude and longitude
    }
}
