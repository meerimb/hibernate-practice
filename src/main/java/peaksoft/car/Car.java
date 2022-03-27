package peaksoft.car;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String color;
    private int realiseOfYear;
    private int price;

    public Car() {
    }

    public Car(String brand, String color, int realiseOfYear, int price) {
        this.brand = brand;
        this.color = color;
        this.realiseOfYear = realiseOfYear;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRealiseOfYear() {
        return realiseOfYear;
    }

    public void setRealiseYear(int realisOfeYear) {
        this.realiseOfYear = realiseOfYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", realiseYear=" + realiseOfYear +
                ", price=" + price +
                '}';
    }
}
