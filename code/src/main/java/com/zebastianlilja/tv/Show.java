package com.zebastianlilja.tv;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import java.lang.annotation.Target;
import java.util.ArrayList;

/**
 * Created by Zebastian on 2015-12-10.
 */
public class Show {
    String name ;
    ArrayList<Episode> showEpisodes;
    Client client;
    WebTarget target;

    public Show(String userInputShowName,Client inClient, WebTarget inTarget){
        name = userInputShowName;
        client = inClient;
        target = inTarget;


        target = target.path("/singlesearch/shows").queryParam("q", name).queryParam("embed", "episodes");

        Invocation.Builder builder = target.request();



        String str = builder.get(String.class);
        JSONObject obj = new JSONObject(str);
        name = obj.getString("name");
        JSONObject embedded = obj.getJSONObject("_embedded");
        JSONArray episodes = embedded.getJSONArray("episodes");
        for (int i = 0 ; i < episodes.length(); i++){
            JSONObject epiJson = episodes.getJSONObject(i);
            String epiName = epiJson.getString("name");
            int epiNumber = epiJson.getInt("number");
            int epiSeason = epiJson.getInt("season");
            Episode e = new Episode(epiName, epiSeason, epiNumber);
            //showEpisodes.add(e);
        }


    }

    public String getName(){
        return name;
    }

    public static void main(String[] args){

    }
}
