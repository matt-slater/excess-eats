package hack.cuny.excesseats.model;

import java.util.List;
import java.util.stream.Collectors;

public class ProducerDTO {

    private long id;
    private String name;
    private String address;
    private String phone;
    private String hours;
    private List<EatsDTO> eats;

    public ProducerDTO(Producer producer) {
        id = producer.getId();
        name = producer.getName();
        address = producer.getAddress();
        phone = producer.getPhone();
        hours = producer.getHours();
        eats = producer.getEats().stream().map(eat -> new EatsDTO(eat)).collect(Collectors.toList());
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

    public List<EatsDTO> getEats() {
        return eats;
    }

    public void setEats(List<EatsDTO> eats) {
        this.eats = eats;
    }
}
