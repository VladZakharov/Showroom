package model.car;

import javax.persistence.*;

/**
 * Created by vlad on 10.11.15.
 */
@Entity
//@Table(name = "car_spec")
public class CarSpecifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Car car;

    @OneToOne
    private Color color;

    private float acceleration;

    private int engineVolume;

    private int horsePowers;

    private int topSpeed;

    public CarSpecifications() {
    }

    public CarSpecifications(Car car, int engineVolume, int topSpeed, float acceleration, int horsePowers, Color color) {
        this.car = car;
        this.engineVolume = engineVolume;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.horsePowers = horsePowers;
        this.color = color;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    public void setHorsePowers(int horsePowers) {
        this.horsePowers = horsePowers;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
