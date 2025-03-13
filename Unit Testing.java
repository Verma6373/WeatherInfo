@SpringBootTest
public class WeatherServiceTest {

    @MockBean
    private LocationRepository locationRepository;

    @MockBean
    private WeatherRepository weatherRepository;

    @MockBean
    private WeatherApiClient weatherApiClient;

    @MockBean
    private GeocodeApiClient geocodeApiClient;

    @Autowired
    private WeatherService weatherService;

    @Test
    public void testGetWeatherWithExistingLocation() {
        Location mockLocation = new Location();
        mockLocation.setPincode("411014");
        mockLocation.setLatitude(18.5204);
        mockLocation.setLongitude(73.8567);

        WeatherInfo mockWeatherInfo = new WeatherInfo();
        mockWeatherInfo.setWeatherData("Sunny");

        when(locationRepository.findByPincode("411014")).thenReturn(Optional.of(mockLocation));
        when(weatherRepository.findByLatitudeAndLongitudeAndForDate(anyDouble(), anyDouble(), any())).thenReturn(Optional.of(mockWeatherInfo));

        String weather = weatherService.getWeatherForPincode("411014", LocalDate.now());
        assertEquals("Sunny", weather);
    }

    @Test
    public void testGetWeatherWithNewLocation() {
        // Implement similar test case for new location
    }
}
