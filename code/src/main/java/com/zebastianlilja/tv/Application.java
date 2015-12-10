/*
    Copyright 2015 Zebastian Lilja

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.zebastianlilja.tv;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * @author Zebastian Lilja
 * @since 1.0
 */
public class Application {


    public static void main(String[] args){
        //User input
        String userInputShowName = new String ("quantico");

        //Single show search
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target("http://api.tvmaze.com");
        target = target.path("singlesearch/shows").queryParam("q", userInputShowName);

        Invocation.Builder builder = target.request();
        // Response response = builder.get();


        //Parse JSON into useful pieces
        String str = builder.get(String.class);
        JSONObject obj = new JSONObject(str);
        String name = obj.getString("name");
        int showId = obj.getInt("id");
        JSONArray arr = obj.getJSONArray("genres");
        for (int i = 0; i < arr.length(); i++)
           System.out.println(arr.getString(i));

        Client idClient = ClientBuilder.newBuilder().newClient();
        WebTarget idTarget = idClient.target("http://api.tvmaze.com");
        idTarget = idTarget.path("/shows/" + showId + "/episodes");

        Invocation.Builder idBuilder = idTarget.request();

        String idStr = idBuilder.get(String.class);
        JSONObject idObj = new JSONObject(str);
        //JSONArray arr = idObj.getJSONArray("episodes");
        //for (int i = 0; i < arr.length(); i++)
        //   System.out.println(arr.getInt(i));
        //int episodeNumber = idObj.getInt("season");



        System.out.println("Show name: " + name + System.getProperty("line.separator") + "Show ID: " + showId);
        System.out.println(builder.get(String.class));
        System.out.println(userInputShowName);
        //System.out.println(idBuilder.get(String.class));
        //System.out.println(episodeNumber);
    }

}
