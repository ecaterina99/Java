import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarFilter {

    public List<Car> filteredCars(List<Car> cars, FilterCriteria criteria, int filterType) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (matchesFilter(car, filterType, criteria)) {
                result.add(car);
            }
        }
        return result;
    }

    private boolean matchesFilter(Car car, int filterType, FilterCriteria criteria) {
        switch (filterType) {
            case 1: // Manufacturer filter
                return car.getManufacturer() != null &&
                        car.getManufacturer().toLowerCase().contains(criteria.getManufacturer().toLowerCase());

            case 2: // Production year filter
                return car.getProductionYear() >= criteria.getMinYear();

            case 3: // Consumption filter
                if (car.getConsumption() == null || !car.getConsumption().equals(criteria.getConsumption())) {
                    return false;
                }

                if (criteria.isCheckConsumptionRange()) {
                    return car.getConsumptionValue() >= criteria.getMinConsumption() &&
                            car.getConsumptionValue() <= criteria.getMaxConsumption();
                }
                return true;

            case 4: // Show all cars
                return true;

            default:
                return false;
        }
    }
}