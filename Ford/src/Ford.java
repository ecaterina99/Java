public class Ford {
    public static void main(String[] args) {
        String carMake = "Ford";
        int doors = 4;
        // outer switch
        switch (carMake) {

            case "Ford":

                // inner switch
                switch (doors) {

                    case 3:
                        System.out.println("You drive a Ford with three doors.");
                        break;

                    case 4:
                        System.out.println("You drive a Ford with four doors.");
                        break;

                    case 5:
                        System.out.println("You drive a Ford with five doors.");
                        break;
                }
                break;

            default:    // this default belongs to outer switch
                System.out.println("We're sorry. You do not drive a Ford car.");
                break;
        }
    }
}
