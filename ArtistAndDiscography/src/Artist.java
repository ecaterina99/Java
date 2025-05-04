public class Artist {
    private int id;
    private String name;
    private String type;
    private int launchYear;
    private Integer splitYear;
    private String website;

    public Artist(String name, String type, int launchYear, Integer splitYear, String website) {
        this.name = name;
        this.type = type;
        this.launchYear = launchYear;
        this.splitYear = splitYear;
        this.website = website;
    }

    public Artist(String name, String type, int launchYear, Integer splitYear, String website, int id) {
        this.name = name;
        this.type = type;
        this.launchYear = launchYear;
        this.splitYear = splitYear;
        this.website = website;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public Integer getSplitYear() {
        return splitYear;
    }

    public String getWebsite() {
        return website;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public void setSplitYear(int splitYear) {
        this.splitYear = splitYear;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Artist ID: ").append(id)
                .append(", Name: ").append(name)
                .append(", Type: ").append(type)
                .append(", Launch Year: ").append(launchYear);

        if (splitYear != null) {
            sb.append(", Split Year: ").append(splitYear);
        } else {
            sb.append(", Status: Active");
        }

        if (website != null && !website.isEmpty()) {
            sb.append(", Website: ").append(website);
        } else {
            sb.append(", No website");
        }

        return sb.toString();

    }

}