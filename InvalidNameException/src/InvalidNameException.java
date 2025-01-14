public class InvalidNameException {
    public static void main(String[] args) {

        try {
            User user = new User(-5, "Bob", "Ross", "bobross@.com");
        } catch (InvalidIdException ex) {
            System.out.println("Invalid ID");
        } catch (InvalidFirstNameException ex) {
            System.out.println("Invalid first name");
        } catch (InvalidLastNameException ex) {
            System.out.println("Invalid last name");
        } catch (InvalidEmailException ex) {
            System.out.println("Invalid email");
        }


    }
}
