@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private double latitude;
    private double longitude;
    
    // Getters and setters...
}

@Entity
public class WeatherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double latitude;
    private double longitude;
    private String weatherData;
    private LocalDate forDate;

    // Getters and setters...
}
