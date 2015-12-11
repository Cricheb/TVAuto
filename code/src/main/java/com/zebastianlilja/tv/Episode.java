package com.zebastianlilja.tv;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Zebastian on 2015-12-10.
 */
@XmlRootElement
public class Episode {

    String showName;
    int seasonNumber;
    int episodeNumber;
    String episodeName;
    boolean aquired;
    boolean watched;

    public Episode() {
    }

    @XmlElement
    public void setShowName (String sName){
        showName = sName;
    }

    public String getShowName (){
        return showName;
    }

    @XmlElement
    public void setSeasonNumber (int season){
        seasonNumber = season;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    @XmlElement
    public void setEpisodeNumber (int episode){
        episodeNumber = episode;
    }

    public int getEpisodeNumber (){
        return episodeNumber;
    }

    @XmlElement
    public void setEpisodeName (String eName){
        episodeName = eName;
    }

    public String getEpisodeName (){
        return episodeName;
    }

    @XmlElement
    public void setAquired (boolean atf){
        aquired = atf;
    }

    public boolean getAquired (){
        return aquired;
    }

    @XmlElement
    public void setWatched (boolean wtf) {
        watched = wtf;
    }

    public boolean getWatched (){
        return watched;
    }

    public String getEpisode (){
        String epiNumberString = String.format("%02d", episodeNumber);
        String seasonNumberString = String.format("%02d", seasonNumber);
        return showName + " E" + epiNumberString + "S" + seasonNumberString + " " + episodeName;
    }




}
