package peaksoft.sport;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sports")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String kindOfSport;
    private String trainingDay;
    private LocalDate startTime;
    private int price;

    public Sport() {
    }

    public Sport(String kindOfSport, String trainingDay, LocalDate startTime, int price) {
        this.kindOfSport = kindOfSport;
        this.trainingDay = trainingDay;
        this.startTime = startTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKindOfSport() {
        return kindOfSport;
    }

    public void setKindOfSport(String kindOfSport) {
        this.kindOfSport = kindOfSport;
    }

    public String getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(String trainingDay) {
        this.trainingDay = trainingDay;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", kindOfSport='" + kindOfSport + '\'' +
                ", trainingDay='" + trainingDay + '\'' +
                ", startTime=" + startTime +
                ", price=" + price +
                '}';
    }
}
