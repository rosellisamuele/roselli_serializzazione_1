package server;

import java.io.IOException;
import java.net.ServerSocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class AppServer {
    public static int port = 6789;

    public static void main(String[] args) throws JsonProcessingException{

        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Server aperto sulla porta "+port);
        }catch(IOException e){
            System.out.println("Errore nella connessione");
            return;
        }

        Server server = new Server();
        User u = new User();

        server.accept(serverSocket);

        server.send("Connessione effettuata");

        u.setNome(server.receive());
        u.setCognome(server.receive());
        u.setEta(Integer.parseInt(server.receive()));

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(u);
        server.send(xml);

        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(u);
        server.send(json);


    }

    
}