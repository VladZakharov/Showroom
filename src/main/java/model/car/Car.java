package model.car;

import javax.persistence.*;

/**
 * Created by vlad on 10.11.15.
 */
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private CarBrand brand;

    @OneToOne
    private CarCondition condition;

    private String extras;

    @Column(name = "grad_year")
    private int graduationYear;

    @Column(nullable = false)
    private int price;

    public Car() {
    }

    public Car(CarBrand brand, int graduationYear, String extras, CarCondition condition, int price) {
        this.brand = brand;
        this.graduationYear = graduationYear;
        this.extras = extras;
        this.condition = condition;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public CarCondition getCondition() {
        return condition;
    }

    public void setCondition(CarCondition condition) {
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
