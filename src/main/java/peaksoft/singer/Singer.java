package peaksoft.singer;

import javax.persistence.*;

@Entity
@Table(name = "singers")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nickNameOfSinger;
    private String genre;
    private int age;
    private String country;

    public Singer() {
    }

    public Singer(String nickNameOfSinger, String genre, int age, String country) {
        this.nickNameOfSinger = nickNameOfSinger;
        this.genre = genre;
        this.age = age;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickNameOfSinger() {
        return nickNameOfSinger;
    }

    public void setNickNameOfSinger(String nickNameOfSinger) {
        this.nickNameOfSinger = nickNameOfSinger;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", nickNameOfSinger='" + nickNameOfSinger + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
