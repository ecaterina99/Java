public class Server {
    public int id;
    public String name;

    public enum serverStatus {
        STOPPED, RUNNING, UNKNOWN;
    }

    public serverStatus status;

    public Server(String input) {
        String[] iputArray = input.split("&");

        this.id = Integer.parseInt(iputArray[0].split("=")[1]);
        this.name = iputArray[1].split("=")[1].toString();
        this.status = getStatus(iputArray[2].split("=")[1].toUpperCase().toString());
    }

    public serverStatus getStatus(String status) {

        serverStatus res = serverStatus.UNKNOWN;

        try {
            res = serverStatus.valueOf(status);
        } catch (Exception e) {
            System.out.println("There is an error.");
        }
        return res;
    }

    public String showInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(this.id).append(", ");
        builder.append("Name: ").append(this.name).append(", ");
        builder.append("Status: ").append(this.status).append(".");
        return builder.toString();

    }
}
