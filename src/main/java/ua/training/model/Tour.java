package ua.training.model;

public class Tour {
    private int id;
    private String name;
    private String description;
    private int price;
    private TourType tourType;
    private int peopleAmount;
    private int stars;
    private boolean isHot;
    private String img;

    public Tour() {
    }

    public Tour(int id, String name, String description, int price, TourType tourType, int peopleAmount, int stars, boolean isHot, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.tourType = tourType;
        this.peopleAmount = peopleAmount;
        this.stars = stars;
        this.isHot = isHot;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
