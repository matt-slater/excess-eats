package hack.cuny.excesseats.model;

import java.util.Date;

public class EatsPostDTO {
    private String description;
    private boolean expired;
    private Date expires;
    private double price;
    private double discount;

    public EatsPostDTO() {

    }

    public EatsPostDTO(String description, Boolean expired, Date expires, double price, double discount) {
        this.description = description;
        this.expired = expired;
        this.expires = expires;
        this.price = price;
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
