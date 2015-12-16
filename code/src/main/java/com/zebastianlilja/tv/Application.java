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
import java.util.ArrayList;
import javax.xml.bind.Marshaller;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;


/**
 * @author Zebastian Lilja
 * @since 1.0
 */
public class Application {


    public static void main(String[] args){
       try {
        //User input
        String userInputShowName = "HappY Emdings";

        //creates client and sets web target for REST
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target("http://api.tvmaze.com");

        //Creates new show, send with it the search term the User put in, the client and the webtarget.
        //So it knows what to look for and where.
        Show show = new Show(userInputShowName, client, target);

        //Uses the arraylist the class Show creates prints each episode in that show out to log.
        ArrayList<Episode> showEpisodes = show.getArray();
        for (int i = 0 ; i < showEpisodes.size(); i++) {
            if (showEpisodes.get(i).getEpisodeNumber() == 1) {
                System.out.println(" ");
            }
            System.out.println(showEpisodes.get(i).getEpisode());
        }

           Shows shows = new Shows();
           shows.add(show);
           File file = new File("C:\\Users\\Zebastian\\Desktop\\Repo\\SaveFiles\\AutoTVSaveFile.xml");
           JAXBContext jaxbContext = JAXBContext.newInstance(Shows.class);
           Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
           // output pretty printed
           jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

           jaxbMarshaller.marshal(shows, file);
           jaxbMarshaller.marshal(shows, System.out);


    }catch (JAXBException error) {
        error.printStackTrace();
        }
    }
}
