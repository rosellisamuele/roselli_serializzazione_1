package client;


import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class AppClient
{
    public static String ip = "localhost";
    public static int port = 6789;

    
    public static void main( String[] args ) throws JsonProcessingException
    {
        Scanner inputScanner = new Scanner(System.in);

        String messageFromServer = "";

        Client client = new Client();
        client.start(ip,port);

        messageFromServer = client.receive();
        System.out.println(messageFromServer);


        User u = new User();
        InsertUserDataFromInput(u);

        client.send(u.getCognome());
        client.send(u.getNome());
        client.send(String.valueOf(u.getEta()));

        messageFromServer = client.receive();
        
        XmlMapper xmlMapper = new XmlMapper();
        
        User xmlReponse = xmlMapper.readValue(messageFromServer, User.class);

        messageFromServer = client.receive();
        ObjectMapper jsonMapper = new ObjectMapper();

        User jsonResponse = jsonMapper.readValue(messageFromServer, User.class);
        
        System.out.println("XML Response: "+xmlReponse.toString());
        System.out.println("JSON Response: "+jsonResponse.toString());

        inputScanner.close();
        client.close();
    }

    public static void InsertUserDataFromInput(User u){
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Inserire il nome:");
        u.setCognome(consoleIn.next());

        System.out.println("Inserire il cognome:");
        u.setNome(consoleIn.next());

        System.out.println("Inserire l'eta:");
        u.setEta(consoleIn.nextInt());

        consoleIn.close();
    }
}