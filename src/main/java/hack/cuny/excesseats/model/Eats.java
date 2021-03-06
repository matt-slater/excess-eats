package hack.cuny.excesseats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Eats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    private Date expires;
    private boolean expired;
    private double price;
    private double discount;
    private long rating;
    private String distanceString;
    private double distance;

    public Eats() {}

    public Eats(String description, Producer producer, Date expires, boolean expired, double price, double discount, long rating) {
        this.description = description;
        this.producer = producer;
        this.expires = expires;
        this.expired = expired;
        this.price = price;
        this.discount = discount;
        this.rating = rating;
    }

    public Eats(EatsPostDTO eatsDTO, Producer producer) {
        this.description = eatsDTO.getDescription();
        this.producer = producer;
        this.expires = eatsDTO.getExpires();
        this.expired = eatsDTO.isExpired();
        this.price = eatsDTO.getPrice();
        this.discount = eatsDTO.getDiscount();

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

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getDistanceString() {
        return distanceString;
    }

    public void setDistanceString(String distanceString) {
        this.distanceString = distanceString;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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
