package com.potalainfotech.tibetdailynews.dashboard.home;

/**
 * Created by tenzi on 4/24/2017.
 */

public class HomeData {

    String featuredImageUrl,title,description,date,category,author;


    public HomeData(String featuredImageUrl, String title, String description, String date, String category, String author) {
        this.featuredImageUrl = featuredImageUrl;
        this.title = title;
        this.description = description;
        this.date = date;
        this.category = category;
        this.author = author;
    }

    public HomeData(String featuredImageUrl, String title, String date, String category) {
        this.featuredImageUrl = featuredImageUrl;
        this.title = title;
        this.date = date;
        this.category = category;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }
}
