import java.util.List;

public class FilterManager {
    private final CarXMLParser parser;
    private final CarFilter filter;
    private final InputValidator inputHandler;

    public FilterManager(InputValidator inputHandler) {
        this.parser = new CarXMLParser();
        this.filter = new CarFilter();
        this.inputHandler = inputHandler;
    }

    public void processFilter(int filterType) throws Exception {
        FilterCriteria criteria = inputHandler.getFilterCriteria(filterType);

        List<Car> allCars = parser.parseXMLFile();
        List<Car> filteredCars = filter.filteredCars(allCars, criteria, filterType);

        displayResults(filteredCars);
    }

    private void displayResults(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars found matching your criteria.");
        } else {
            cars.forEach(Car::display);
            System.out.println("Total cars found: " + cars.size());
        }
    }
}