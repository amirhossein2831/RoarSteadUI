package com.example.roarui.Models;

import com.example.roarui.Component.Annotations.Exclude;

import java.net.URL;
import java.util.Date;

public class Profile {
    @Exclude
    private Image profImage;
    @Exclude
    private Image headerImage;

    private String bio;
    private String location;

    private URL websiteLink;

    private Date createdAt;

    public Image getProfImage() {
        return profImage;
    }

    public void setProfImage(Image profImage) {
        this.profImage = profImage;
    }

    public Image getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(Image headerImage) {
        this.headerImage = headerImage;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public URL getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(URL websiteLink) {
        this.websiteLink = websiteLink;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
