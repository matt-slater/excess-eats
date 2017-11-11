package hack.cuny.excesseats.model;


import javax.persistence.*;
import java.util.List;


@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private String phone;
    private String hours;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producer")
    private List<Eats> eats;

    public Producer() {}

    public Producer(String name) {
        this.name = name;
    }

    public Producer(String name, String address, String phone, String hours) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public List<Eats> getEats() {
        return eats;
    }

    public void setEats(List<Eats> eats) {
        this.eats = eats;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", hours='" + hours + '\'' +
                ", eats=" + eats +
                '}';
    }
}
