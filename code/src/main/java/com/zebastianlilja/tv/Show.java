package com.zebastianlilja.tv;

import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;

/**
 * Created by Zebastian on 2015-12-10.
 */
public class Show {
    String name ;
    ArrayList<Season> showSeasons;

    public Show(String userInputShowName){
        name = userInputShowName;

        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target("http://api.tvmaze.com");
        target = target.path("singlesearch/shows").queryParam("q", name);

        Invocation.Builder builder = target.request();

        String str = builder.get(String.class);
        JSONObject obj = new JSONObject(str);
        name = obj.getString("name");
        //int showId = obj.getInt("id");


    }

    public static void main(String[] args){

    }
}
