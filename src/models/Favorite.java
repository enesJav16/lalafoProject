package models;

public class Favorite {
    private Long id;
    private User whoLiked;
    private Annoucement announcement;

    public Favorite(Long id, User whoLiked, Annoucement announcement) {
        this.id = id;
        this.whoLiked = whoLiked;
        this.announcement = announcement;
    }

    public Favorite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getWhoLiked() {
        return whoLiked;
    }

    public void setWhoLiked(User whoLiked) {
        this.whoLiked = whoLiked;
    }

    public Annoucement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Annoucement announcement) {
        this.announcement = announcement;
    }

    @Override
    public String toString() {
        return "\n~~~~~~~~~~~~~~~~~~~~~~~~~" +
                "\nid          :" + id +
                "\nwhoLiked    :" + whoLiked +
                "\nannouncement:" + announcement ;
    }
}
