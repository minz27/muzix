package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int trackId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("artist")
    private String artist;
    private String trackComments;

    public Track(int trackId, String trackName, String trackArtist, String trackComments) {
        this.trackId = trackId;
        this.name = trackName;
        this.artist = trackArtist;
        this.trackComments = trackComments;
    }

    public Track() {
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrackComments() {
        return trackComments;
    }

    public void setTrackComments(String trackComments) {
        this.trackComments = trackComments;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", trackComments='" + trackComments + '\'' +
                '}';
    }
}
