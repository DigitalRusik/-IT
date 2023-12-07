package com.marketplace.marketproject.models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "author")
    private String author;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated;
    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }
    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }

    public void setPreviewImageId(long previewImageId) {this.previewImageId = previewImageId;}
    public Long getPreviewImageId() {return previewImageId;}
    public void setId(long id) {this.id = id;}
    public Long getId() {return id;}
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setAuthor(String author) {this.author = author;}
    public String getAuthor() {
        return author;
    }
}
