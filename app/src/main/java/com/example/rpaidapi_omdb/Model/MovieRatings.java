package com.example.rpaidapi_omdb.Model;

import java.util.Map;

public class MovieRatings {
    private String id="";
    private String title="";
    private String titleType="";
    private int year=1;
    private int bottomRank=1;
    private boolean canRate=false;
    private double rating=1;
    private int ratingCount=1;
    private int topRank=1;

    private Map<String, RatingDemographic> ratingsHistograms;

    // Getter and Setter methods for the fields

    public static class RatingDemographic {
        private double aggregateRating=1;
        private String demographic="";
        private Map<String, Integer> histogram=null;
        private int totalRatings=1;

        // Getter and Setter methods for the fields


        public double getAggregateRating() {
            return aggregateRating;
        }

        public void setAggregateRating(double aggregateRating) {
            this.aggregateRating = aggregateRating;
        }

        public String getDemographic() {
            return demographic;
        }

        public void setDemographic(String demographic) {
            this.demographic = demographic;
        }

        public Map<String, Integer> getHistogram() {
            return histogram;
        }

        public void setHistogram(Map<String, Integer> histogram) {
            this.histogram = histogram;
        }

        public int getTotalRatings() {
            return totalRatings;
        }

        public void setTotalRatings(int totalRatings) {
            this.totalRatings = totalRatings;
        }
    }

    public Map<String, RatingDemographic> getRatingsHistograms() {
        return ratingsHistograms;
    }

    public void setRatingsHistograms(Map<String, RatingDemographic> ratingsHistograms) {
        this.ratingsHistograms = ratingsHistograms;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getBottomRank() {
        return bottomRank;
    }

    public void setBottomRank(int bottomRank) {
        this.bottomRank = bottomRank;
    }

    public boolean isCanRate() {
        return canRate;
    }

    public void setCanRate(boolean canRate) {
        this.canRate = canRate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public int getTopRank() {
        return topRank;
    }

    public void setTopRank(int topRank) {
        this.topRank = topRank;
    }

}
