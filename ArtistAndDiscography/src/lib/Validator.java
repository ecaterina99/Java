package lib;

import java.time.LocalDate;

public class Validator {

    public static ValidationResult validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return ValidationResult.fail("Artist name cannot be empty.");
        }
        return ValidationResult.ok();
    }


    public static ValidationResult validateArtistType(String type) {
        if (!type.equalsIgnoreCase("solo") && !type.equalsIgnoreCase("band")) {
            return ValidationResult.fail("Invalid type. Please enter 'solo' or 'band'");
        }
        return ValidationResult.ok();
    }


    public static ValidationResult validateNewArtistType(String type) {
        if (type == null || type.trim().isEmpty()) {
            return ValidationResult.ok();
        }
        return validateArtistType(type);
    }


    public static ValidationResult validateLaunchYear(String launchYear) {
        LocalDate currentDate = LocalDate.now();
        if (launchYear == null || launchYear.trim().isEmpty()) {
            return ValidationResult.fail("Launch year cannot be empty.");
        }
        return getValidationResult(launchYear, currentDate);
    }


    public static ValidationResult validateNewLaunchYear(String launchYear) {
        LocalDate currentDate = LocalDate.now();
        if (launchYear == null || launchYear.trim().isEmpty()) {
            return ValidationResult.ok();
        }
        return getValidationResult(launchYear, currentDate);
    }


    private static ValidationResult getValidationResult(String launchYear, LocalDate currentDate) {
        try {
            int year = Integer.parseInt(launchYear);
            if (year < 1900 || year > currentDate.getYear()) {
                return ValidationResult.fail("Launch year must be between 1900 and " + currentDate.getYear());
            }
        } catch (NumberFormatException e) {
            return ValidationResult.fail("Launch year must be a valid number.");
        }
        return ValidationResult.ok();
    }


    public static ValidationResult validateSplitYear(String splitYear, int launchYear) {
        LocalDate currentDate = LocalDate.now();
        if (splitYear == null || splitYear.trim().isEmpty()) {
            return ValidationResult.ok();
        }
        try {
            int year = Integer.parseInt(splitYear.trim());
            if (year < launchYear || year > currentDate.getYear()) {
                return ValidationResult.fail("Split year must be between launch year (" + launchYear + ") and " + currentDate.getYear());
            }
        } catch (NumberFormatException e) {
            return ValidationResult.fail("Split year must be a valid number.");
        }
        return ValidationResult.ok();
    }


    public static ValidationResult validateWebsite(String website) {
        if (website.isEmpty()) {
            return ValidationResult.ok();
        } else if (!website.startsWith("http://") && !website.startsWith("https://") && !website.startsWith("www.")) {
            return ValidationResult.fail("Invalid website. Please try again.");
        }
        return ValidationResult.ok();
    }


    public static ValidationResult validateNumberFormat(String id) {
        if(id.matches("\\d+")){
            return ValidationResult.ok();
        }
        return ValidationResult.fail("Invalid input format. Please try again.");
    }

}
