package com.example.scott.ohemem;

/**
 * Created by Scott on 2/26/2016.
 */
public class Technique implements Comparable<Technique>{
    private String name,
                description,
                category,
                vidUrl,
                picUrl;

    /**
     *  Constructor with all fields entered
     * @param name  String name of technique.
     * @param description   String description of technique
     * @param category  String category of technique (should fall into one of several)
     * @param vidUrl    String URL of youtube video
     * @param picUrl    String URL of technique picture
     */
    public Technique(String name, String description, String category, String vidUrl, String picUrl) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.vidUrl = vidUrl;
        this.picUrl = picUrl;
    }

    /**
     *
     * @return  Technique name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name  String name of Technique
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return  Description of Technique
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVidUrl() {
        return vidUrl;
    }

    public void setVidUrl(String vidUrl) {
        this.vidUrl = vidUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     *
     * @return Category and Technique name, with description on next line.
     */
    @Override
    public String toString() {
        return category + " " + name + "\n" +
                description;
    }

    /**
     *
     * @param that Technique to compare against.
     * @return  Compares two Techniques by Category first, then
     *      Technique name.
     */
    @Override
    public int compareTo(Technique that) {
        int BEFORE = -1;
        int EQUAL = 0;
        int AFTER = 1;

        // if the object is null
        if(this == null){
            return AFTER;
        }
        // variables to compare Categories and Names
        int compareCategory = this.getCategory().compareToIgnoreCase(that.getCategory());
        int compareName = this.getName().compareToIgnoreCase(that.getName());
        // compare the artists
        if(compareCategory != EQUAL){
            return compareCategory;
        }
        // compare the titles
        if(compareName != EQUAL){
            return compareName;
        }
        // if they have the same artist and title...
        return EQUAL;
    }
}
