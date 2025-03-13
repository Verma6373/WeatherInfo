@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public ResponseEntity<String> getWeather(@RequestBody WeatherRequest request) {
        String weatherData = weatherService.getWeatherForPincode(request.getPincode(), request.getForDate());
        return ResponseEntity.ok(weatherData);
    }
}

class WeatherRequest {
    private String pincode;
    private LocalDate forDate;

    // Getters and setters...
}
