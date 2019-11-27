package com.mdb;

/**
 * Created by pasztor on 2015.11.22..
 */
public class Celeb {
    private String name;
    private String movies;
    private int img;

    public Celeb(String name, String movies, int img) {
        this.name = name;
        this.movies = movies;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
