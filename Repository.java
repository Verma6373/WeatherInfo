@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByPincode(String pincode);
}

@Repository
public interface WeatherRepository extends JpaRepository<WeatherInfo, Long> {
    Optional<WeatherInfo> findByLatitudeAndLongitudeAndForDate(double latitude, double longitude, LocalDate forDate);
}
