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
        String userInputShowName = "HappY Emdings";

        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target("http://api.tvmaze.com");

        Show show = new Show(userInputShowName, client, target);

        userInputShowName = "quantico";
        show = new Show(userInputShowName, client, target);


        //System.out.println("Show name: " + name + System.getProperty("line.separator") + "Show ID: " + showId);
        //System.out.println(builder.get(String.class));
        //System.out.println(embedded);
        //System.out.println(userInputShowName);
        //System.out.println(epiName);
        //System.out.println(idBuilder.get(String.class));
        //System.out.println(episodeNumber);
        //System.out.println(show.getName());
    }

}
