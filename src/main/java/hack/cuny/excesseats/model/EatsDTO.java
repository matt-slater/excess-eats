package hack.cuny.excesseats.model;

import java.util.Date;

public class EatsDTO {
    private long id;
    private String description;
    private String producer;
    private long producerId;
    private boolean expired;
    private Date expires;
    private double price;
    private double discount;
    private double discountedPrice;
    private String imgUrl;
    private long rating;
    private String distanceString;
    private double distance;

    public EatsDTO(Eats eats) {
        id = eats.getId();
        producer = eats.getProducer().getName();
        description = eats.getDescription();
        expired = eats.isExpired();
        expires = eats.getExpires();
        price = eats.getPrice();
        discount = eats.getDiscount();
        discountedPrice = eats.getPrice()*(1-eats.getDiscount());
        producerId = eats.getProducer().getId();
        imgUrl = "img/" + id + ".jpg";
        rating = eats.getRating();
        distanceString = eats.getDistanceString();
        distance = eats.getDistance();
    }

    public EatsDTO() {}

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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
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

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public long getProducerId() {
        return producerId;
    }

    public void setProducerId(long producerId) {
        this.producerId = producerId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
        return "EatsDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", producer='" + producer + '\'' +
                ", producerId=" + producerId +
                ", expired=" + expired +
                ", expires=" + expires +
                ", price=" + price +
                ", discount=" + discount +
                ", discountedPrice=" + discountedPrice +
                '}';
    }
}
