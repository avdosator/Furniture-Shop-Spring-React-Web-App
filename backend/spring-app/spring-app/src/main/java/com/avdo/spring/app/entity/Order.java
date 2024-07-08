package com.avdo.spring.app.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "\"order\"")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "date_created", updatable = false)
    private Date dateCreated;

    public Order() {
    }

    public Long getId() {
        return this.id;
    }

    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        final Order other = (Order) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userEntity = this.getUserEntity();
        final Object other$userEntity = other.getUserEntity();
        if (this$userEntity == null ? other$userEntity != null : !this$userEntity.equals(other$userEntity))
            return false;
        final Object this$orderItems = this.getOrderItems();
        final Object other$orderItems = other.getOrderItems();
        if (this$orderItems == null ? other$orderItems != null : !this$orderItems.equals(other$orderItems))
            return false;
        if (Double.compare(this.getTotalAmount(), other.getTotalAmount()) != 0) return false;
        final Object this$orderStatus = this.getOrderStatus();
        final Object other$orderStatus = other.getOrderStatus();
        if (this$orderStatus == null ? other$orderStatus != null : !this$orderStatus.equals(other$orderStatus))
            return false;
        final Object this$dateCreated = this.getDateCreated();
        final Object other$dateCreated = other.getDateCreated();
        if (this$dateCreated == null ? other$dateCreated != null : !this$dateCreated.equals(other$dateCreated))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userEntity = this.getUserEntity();
        result = result * PRIME + ($userEntity == null ? 43 : $userEntity.hashCode());
        final Object $orderItems = this.getOrderItems();
        result = result * PRIME + ($orderItems == null ? 43 : $orderItems.hashCode());
        final long $totalAmount = Double.doubleToLongBits(this.getTotalAmount());
        result = result * PRIME + (int) ($totalAmount >>> 32 ^ $totalAmount);
        final Object $orderStatus = this.getOrderStatus();
        result = result * PRIME + ($orderStatus == null ? 43 : $orderStatus.hashCode());
        final Object $dateCreated = this.getDateCreated();
        result = result * PRIME + ($dateCreated == null ? 43 : $dateCreated.hashCode());
        return result;
    }

    public String toString() {
        return "Order(id=" + this.getId() +
                ", userEntityId=" + this.getUserEntity().getId() +
                ", orderItems=" + this.getOrderItems() +
                ", totalAmount=" + this.getTotalAmount() +
                ", orderStatus=" + this.getOrderStatus() +
                ", dateCreated=" + this.getDateCreated() + ")";
    }
}
