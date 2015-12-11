package com.zebastianlilja.tv;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.lang.annotation.Target;
import java.util.ArrayList;

/**
 * Created by Zebastian on 2015-12-10.
 */

@XmlRootElement
public class Show {
    String name ;
    Client client;
    WebTarget target;

    ArrayList<Episode> showEpisodes = new ArrayList<Episode>();


    public Show(String userInputShowName,Client inClient, WebTarget inTarget){
        name = userInputShowName;
        client = inClient;
        target = inTarget;

        //Searches for the Users input show name in the Webtarget.
        target = target.path("/singlesearch/shows").queryParam("q", name).queryParam("embed", "episodes");
        Invocation.Builder builder = target.request();


        // Loades the JSONdata from the Webtarget
        String str = builder.get(String.class);
        JSONObject obj = new JSONObject(str);

        //Takes the name of the show from the JSONdata
        name = obj.getString("name");

        //Looks for episodesdata embedded in the JSONdata and make and a JSONArray of found data
        JSONObject embedded = obj.getJSONObject("_embedded");
        JSONArray episodes = embedded.getJSONArray("episodes");

        //Loops through the JSONArray and loads each episodes data into variables.
        for (int i = 0 ; i < episodes.length(); i++){
            JSONObject epiJson = episodes.getJSONObject(i);
            String epiName = epiJson.getString("name");
            int epiNumber = epiJson.getInt("number");
            int epiSeason = epiJson.getInt("season");

            //Creates a new Episode for each post in the JSONArray.
            Episode e = new Episode();

            //Sets the Episodes information
            e.setShowName(name);
            e.setEpisodeName(epiName);
            e.setEpisodeNumber(epiNumber);
            e.setSeasonNumber(epiSeason);
            e.setAquired(false);
            e.setWatched(false);

            // Adds each episode to a ListArray called showEpisodes, for safekeeping.
            showEpisodes.add(e);

            try {

                File file = new File("C:\\Users\\Zebastian\\Desktop\\Repo\\SaveFiles\\AutoTVSaveFile.xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(Episode.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshaller.marshal(e, file);
                jaxbMarshaller.marshal(e, System.out);

            } catch (JAXBException error) {
                error.printStackTrace();
            }
        }


    }

    public String getName(){
        return name;
    }

    public ArrayList getArray(){
        return showEpisodes;

    }

    public static void main(String[] args){

    }
}
