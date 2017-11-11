package hack.cuny.excesseats.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Eats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;

    @ManyToOne()
    @JoinColumn(name = "producer_id")
    private Producer producer;

    private Date expires;
    private boolean expired;
    private double price;
    private double discount;

    public Eats() {}

    public Eats(String description, Producer producer, Date expires, boolean expired, double price, double discount) {
        this.description = description;
        this.producer = producer;
        this.expires = expires;
        this.expired = expired;
        this.price = price;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Eats{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", producer=" + producer.getName()  +
                ", expires=" + expires +
                ", expired=" + expired +
                ", price=" + price +
                '}';
    }
}
