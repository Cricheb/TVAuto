package com.zebastianlilja.tv;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Zebastian on 2015-12-16.
 */
@XmlRootElement (name = "SHOWS")
public class Shows {
    ArrayList<Show> shows;

    @XmlElement
    public void setShows (ArrayList<Show> inShows){
        shows = inShows;
    }

    public void add (Show inShow){
        if (inShow == null){
            shows = new ArrayList<Show>();
        }
        shows.add(inShow);
    }

}
