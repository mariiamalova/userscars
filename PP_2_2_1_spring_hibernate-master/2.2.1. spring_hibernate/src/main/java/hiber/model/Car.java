package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String model;
    private int series;

    @OneToOne(mappedBy = "car",cascade = CascadeType.ALL)
    @JoinColumn (name = "userId")
    private User user;

    public Car() {
    }

    public Car( String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && series == car.series && model.equals(car.model) && user.equals(car.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, series, user);
    }

    @Override
    public String toString() {
        return "Car{" +
                ", model='" + model + '\'' +
                ", serias=" + series +
                '}';
    }
}
