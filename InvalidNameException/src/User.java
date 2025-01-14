class InvalidEmailException extends Exception {
}

class InvalidFirstNameException extends Exception {
}

class InvalidIdException extends Exception {
}

class InvalidLastNameException extends Exception {
}

public class User {
    public int id;
    public String firstName;
    public String lastName;
    public String email;

    public User(int id, String firstName, String lastName, String email) throws InvalidIdException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailException {
        if (id < 0) {
            throw new InvalidIdException();
        } else {
            this.id = id;
        }

        if (firstName == null || firstName.equals("")) {
            throw new InvalidFirstNameException();
        } else {
            this.firstName = firstName;
        }

        if (lastName == null || lastName.equals("")) {
            throw new InvalidLastNameException();
        } else {
            this.lastName = lastName;
        }
        if (email == null || email.equals("")) {
            throw new InvalidEmailException();
        } else {
            this.email = email;
        }
    }

}