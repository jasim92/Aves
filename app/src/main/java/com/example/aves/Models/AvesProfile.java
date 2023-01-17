package com.example.aves.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvesProfile {


    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("alt_description")
    @Expose
    private String alt_description;


    @SerializedName("urls")
    @Expose
    private Urls urls;

    public String getAlt_description() {
        return alt_description;
    }

    public void setAlt_description(String alt_description) {
        this.alt_description = alt_description;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public class User {


        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("username")
        @Expose
        private String username;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("bio")
        @Expose
        private String bio;

        @SerializedName("location")
        @Expose
        private String location;

        @SerializedName("profile_image")
        @Expose
        private ProfileImage profileImage;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public ProfileImage getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(ProfileImage profileImage) {
            this.profileImage = profileImage;
        }
    }


    public class ProfileImage{

        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("large")
        @Expose
        private String large;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }
    }

    public class Urls{

        @SerializedName("raw")
        @Expose
        private String raw;

        @SerializedName("full")
        @Expose
        private String full;

        @SerializedName("regular")
        @Expose
        private String regular;

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }
    }
}
