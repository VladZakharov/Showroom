package model.customer;

import model.car.CarBrand;
import model.car.CarCondition;
import model.car.Color;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vlad on 10.11.15.
 */
@Entity
public class CustomerDemands {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CarBrand> brands;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Color> colors;

    @OneToMany(fetch = FetchType.EAGER)
    private List<CarCondition> conditions;

    private int minEngineVolume;
    private int maxEngineVolume;

    private int minHorsePower;
    private int maxHorsePower;

    private int minTopSpeed;
    private int maxTopSpeed;

    private int minPrice;
    private int maxPrice;

    public CustomerDemands() {
    }

    public CustomerDemands(List<CarBrand> brands, List<Color> colors, List<CarCondition> conditions,
                           int minEngineVolume, int maxEngineVolume,
                           int minHorsePower, int maxHorsePower,
                           int minTopSpeed, int maxTopSpeed,
                           int minPrice, int maxPrice) {
        this.brands = brands;
        this.colors = colors;
        this.conditions = conditions;
        this.minEngineVolume = minEngineVolume;
        this.maxEngineVolume = maxEngineVolume;
        this.minHorsePower = minHorsePower;
        this.maxHorsePower = maxHorsePower;
        this.minTopSpeed = minTopSpeed;
        this.maxTopSpeed = maxTopSpeed;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CarBrand> getBrands() {
        return brands;
    }

    public void setBrands(List<CarBrand> brands) {
        this.brands = brands;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<CarCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<CarCondition> conditions) {
        this.conditions = conditions;
    }

    public int getMinEngineVolume() {
        return minEngineVolume;
    }

    public void setMinEngineVolume(int minEngineVolume) {
        this.minEngineVolume = minEngineVolume;
    }

    public int getMaxEngineVolume() {
        return maxEngineVolume;
    }

    public void setMaxEngineVolume(int maxEngineVolume) {
        this.maxEngineVolume = maxEngineVolume;
    }

    public int getMinHorsePower() {
        return minHorsePower;
    }

    public void setMinHorsePower(int minHorsePower) {
        this.minHorsePower = minHorsePower;
    }

    public int getMaxHorsePower() {
        return maxHorsePower;
    }

    public void setMaxHorsePower(int maxHorsePower) {
        this.maxHorsePower = maxHorsePower;
    }

    public int getMinTopSpeed() {
        return minTopSpeed;
    }

    public void setMinTopSpeed(int minTopSpeed) {
        this.minTopSpeed = minTopSpeed;
    }

    public int getMaxTopSpeed() {
        return maxTopSpeed;
    }

    public void setMaxTopSpeed(int maxTopSpeed) {
        this.maxTopSpeed = maxTopSpeed;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }
}
