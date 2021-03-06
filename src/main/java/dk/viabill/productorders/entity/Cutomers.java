package dk.viabill.productorders.entity;
// Generated Dec 8, 2018 4:40:16 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cutomers generated by hbm2java
 */
@Entity
@Table(name = "Cutomers")
public class Cutomers implements java.io.Serializable {

    private int id;
    private String name;
    private String email;
    private Set<Orders> orderses = new HashSet<Orders>(0);

    public Cutomers() {
    }

    public Cutomers(int id) {
        this.id = id;
    }

    public Cutomers(int id, String name, String email, Set<Orders> orderses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orderses = orderses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", length = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cutomers")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

}
