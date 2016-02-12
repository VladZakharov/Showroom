package model.customer;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vlad on 10.11.15.
 */
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    private String lastName;

    @OneToOne
    private CustomerInfo info;

    @OneToMany
    private List<CustomerDemands> demands;

    public Customer() {
    }

    public Customer(String firstName, String middleName, String lastName, CustomerInfo info, List<CustomerDemands> demands) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.info = info;
        this.demands = demands;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerInfo getInfo() {
        return info;
    }

    public void setInfo(CustomerInfo info) {
        this.info = info;
    }

    public List<CustomerDemands> getDemands() {
        return demands;
    }

    public void setDemands(List<CustomerDemands> demands) {
        this.demands = demands;
    }
}
