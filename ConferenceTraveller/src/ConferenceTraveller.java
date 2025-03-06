/*
Write a conference picker function that takes in two arguments:

Cities visited, a list of cities that Lucy has visited before, given as an array of strings.
Cities offered, a list of cities that will host SECSR conferences this year, given as an array of strings.
Cities offered will already be ordered in terms of the relevance (from the most to the least relevant).
The function should return the city that Lucy should visit, as a string.

You should allow for the possibility that Lucy hasn't visited any city before.
SECSR organizes at least two conferences each year.
If all of the offered conferences are hosted in cities that Lucy has visited before,
the function should return "No worthwhile conferences this year!" (Nothing in Haskell)
 */

import java.util.ArrayList;

public class ConferenceTraveller {
    public static void main(String[] args) {

        String[] citiesVisited = {"Milano", "Paris"};

        String[] citiesOffered = {"Milano", "Paris","Bucharest","Moscow"};


        ArrayList<String> unvisitedCities = new ArrayList<>();

        for (String cityOffered : citiesOffered) {
            boolean found = false;
            for (String cityVisited : citiesVisited) {
                if (cityOffered.equals(cityVisited)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                unvisitedCities.add(cityOffered);
            }
        }

        if (!unvisitedCities.isEmpty()) {
            System.out.println("Next conference city: " + unvisitedCities.get(0));
        } else {
            System.out.println("No worthwhile conferences this year!");
        }
    }
}

/*
  return Arrays.stream(citiesOffered)
                .filter(city -> !Arrays.asList(citiesVisited).contains(city))
                .findFirst()
                .orElse("No worthwhile conferences this year!");
 */