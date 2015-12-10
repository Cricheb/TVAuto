package com.zebastianlilja.tv;

/**
 * Created by Zebastian on 2015-12-10.
 */
public class Episode {

    String showName;
    int seasonNumber;
    int episodeNumber;
    boolean aquired;
    boolean watched;

    public Episode(String name,int season, int episode){
        showName = name;
        seasonNumber = season;
        episodeNumber = episode;

    }

    public void setAquired (boolean atf){
        aquired = atf;
    }

    public void setWatched (boolean wtf) {
        watched = wtf;
    }
}
