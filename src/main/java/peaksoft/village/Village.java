package peaksoft.village;

import javax.persistence.*;

@Entity
@Table(name = "villages")
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameOfVillage;
    private double population;
    private String language;
    private String currencyName;

    public Village() {
    }

    public Village(String nameOfVillage, double population, String language, String currencyName) {
        this.nameOfVillage = nameOfVillage;
        this.population = population;
        this.language = language;
        this.currencyName = currencyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfVillage() {
        return nameOfVillage;
    }

    public void setNameOfCity(String nameOfCity) {
        this.nameOfVillage = nameOfCity;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", nameOfVillage='" + nameOfVillage + '\'' +
                ", population=" + population +
                ", language='" + language + '\'' +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }
}
