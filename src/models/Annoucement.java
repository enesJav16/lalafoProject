package models;

public class Annoucement {
    private Long id;
    private String name;
    private String description;
    private int price;
    private User owner;

    public Annoucement(Long id, String name, String description, int price, User owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.owner = owner;
    }

    public Annoucement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Annoucement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", owner=" + owner +
                '}';
    }
}
