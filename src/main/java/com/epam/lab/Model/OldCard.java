package com.epam.lab.Model;

public class OldCard {
    private int id;
    private String theme;
    private String cardType;
    private String status;
    private String country;
    private String year;
    private String author;
    private String valuable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setCardType(String type) {
        this.cardType = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setValuable(String valuable) {
        this.valuable = valuable;
    }

    public String getTheme() {
        return this.theme;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCountry() {
        return this.country;
    }

    public String getYear() {
        return this.year;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getValuable() {
        return this.valuable;
    }

    @Override
    public String toString() {
        return String.format("Old Card:: ID = %s, Theme = %s, Type = %s,Status = %s,Country = %s,Year = %s,Author = %s,Valuable = %s;",
                this.id, this.theme, this.cardType, this.status, this.country, this.year, this.author, this.valuable);
    }
}
