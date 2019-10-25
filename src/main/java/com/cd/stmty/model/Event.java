package com.cd.stmty.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    @Type(type = "text")
    private String description;
    @Column(name = "image")
    @Type(type = "text")
    private String image;
    @Column(name = "banner")
    private String banner;
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date date;
    @Column(name = "price")
    private String price;
    @Column(name = "address")
    private String address;
    @Column(name = "timeStart")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date timeStart;
    @Column(name = "timeEnd")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date timeEnd;
    @Column(name = "organizer")
    private String organizer;
    @Column(name = "type")
    private String type;
    @Column(name = "addressType")
    private String addressType;
    @Column(name = "category")
    private String category;
    @Column(name = "status")
    private String status;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
