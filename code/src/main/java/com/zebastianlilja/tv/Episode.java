package com.zebastianlilja.tv;

/**
 * Created by Zebastian on 2015-12-10.
 */
public class Episode {

    String showName;
    int seasonNumber;
    int episodeNumber;
    String episodeName;
    boolean aquired;
    boolean watched;

    public Episode(String name,int season, int episode){
        showName = name;
        seasonNumber = season;
        episodeNumber = episode;

    }

    public Episode(String sName,int season, int episode, String eName){
        showName = sName;
        seasonNumber = season;
        episodeNumber = episode;
        episodeName = eName;

    }

    public void setAquired (boolean atf){
        aquired = atf;
    }

    public void setWatched (boolean wtf) {
        watched = wtf;
    }

    public String getEpisode (){
        String epiNumberString = String.format("%02d", episodeNumber);
        String seasonNumberString = String.format("%02d", seasonNumber);
        return showName + " E" + epiNumberString + "S" + seasonNumberString + " " + episodeName;
    }
}
