package main;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "launch_year", nullable = false)
    private int launchYear;

    @Column(name = "split_year", nullable = true)
    private Integer splitYear;

    @Column(name = "website", nullable = true)
    private String website;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Album> albums;

    public Artist() {
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