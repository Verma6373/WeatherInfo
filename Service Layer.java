@Service
public class WeatherService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private WeatherApiClient weatherApiClient;

    @Autowired
    private GeocodeApiClient geocodeApiClient;

    public String getWeatherForPincode(String pincode, LocalDate forDate) {
        Optional<Location> location = locationRepository.findByPincode(pincode);
        if (location.isPresent()) {
            return getWeather(location.get(), forDate);
        } else {
            // Convert pincode to lat/long using Geocode API
            Location newLocation = geocodeApiClient.getLatLong(pincode);
            locationRepository.save(newLocation);
            return getWeather(newLocation, forDate);
        }
    }

    private String getWeather(Location location, LocalDate forDate) {
        // Check cache for existing weather data
        Optional<WeatherInfo> weatherInfo = weatherRepository
            .findByLatitudeAndLongitudeAndForDate(location.getLatitude(), location.getLongitude(), forDate);
        
        if (weatherInfo.isPresent()) {
            return weatherInfo.get().getWeatherData();
        } else {
            // Fetch weather from external API and save
            String weatherData = weatherApiClient.getWeather(location.getLatitude(), location.getLongitude());
            WeatherInfo newWeatherInfo = new WeatherInfo();
            newWeatherInfo.setLatitude(location.getLatitude());
            newWeatherInfo.setLongitude(location.getLongitude());
            newWeatherInfo.setWeatherData(weatherData);
            newWeatherInfo.setForDate(forDate);
            weatherRepository.save(newWeatherInfo);
            return weatherData;
        }
    }
}
