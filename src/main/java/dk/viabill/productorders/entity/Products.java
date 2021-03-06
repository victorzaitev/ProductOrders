package dk.viabill.productorders.entity;
// Generated Dec 8, 2018 4:40:16 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name = "Products")
public class Products implements java.io.Serializable {

    private int id;
    private String name;
    private BigDecimal unitPrice;
    private Date createAt;
    private Date modifiedAt;
    private boolean active;
    private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

    public Products() {
    }

    public Products(int id) {
        this.id = id;
    }

    public Products(int id, String name, BigDecimal unitPrice, Date createAt) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.createAt = createAt;
    }

    public Products(int id, String name, BigDecimal unitPrice, Date createAt, Date modifiedAt, Set<OrderDetails> orderDetailses) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.orderDetailses = orderDetailses;
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

    @Column(name = "name", nullable = false, length = 150)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "unitPrice", nullable = false, precision = 10)
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createAt", nullable = false, length = 23)
    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifiedAt", length = 23)
    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    public Set<OrderDetails> getOrderDetailses() {
        return this.orderDetailses;
    }

    public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
        this.orderDetailses = orderDetailses;
    }

    @Column(name = "isActive")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Products other = (Products) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
