package space.ifel.directoryserver.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import space.ifel.legacy.utilities.CommandHandler;

/**
 * @author cin_dansantos created on 10/10/2020
 */

@Slf4j
public class ServerThread extends Thread {

    private static Character DELIMITER = ';';

    private Socket client;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @SneakyThrows
    @Override
    public void run() {
        log.info("M=run, msg=Client: " + client.getInetAddress().getLocalHost() + " Connected to server");
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //Read messages from clients
        char caracter;
        int count = 1;
        StringBuilder stringReceived = new StringBuilder();
        CommandHandler commandHandler = new CommandHandler();

        while ( (caracter = (char) br.read()) != -1) {
            stringReceived.append(Character.toString(caracter));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            if (Character.toString(caracter).equals(DELIMITER)){
                String commandResponse = commandHandler.getResponse(stringReceived.toString());
                log.info("M=run, msg=commandReceived:" + stringReceived.toString());
                log.info("M=run, msg=commandResponse:" + commandResponse);
                bw.write(commandResponse);
                bw.flush();
                stringReceived.delete(0, stringReceived.length());
            }
            count ++;
        }
        log.info("M=run, msg=Client: " + client.getInetAddress().getLocalHost() + " finishing connection!");
        br.close();
        this.client.close();
    }

    private String getAccountId(StringBuilder sb) {
        return sb.substring(sb.indexOf(" "), sb.indexOf(" ", sb.indexOf(" ")+1)).trim();
    }
}

//C 0 idof "DirectoryServer";A0 objid="39685688";
//C 1 sel 39685688 get RDOOpenSession;A1 RDOOpenSession="#165267116";
//C 2 sel 165267116 call RDOMapSegaUser "^" "%dodgerid";A2 res="%";
//C 3 sel 165267116 call RDOLogonUser "^" "%dodgerid","%AppleDigi123";A3 res="#0";
//C 4 sel 165267116 call RDOEndSession "*" ;A4 ;

// log.info("M=run, msg=Received: " + sb.toString());
//         if(Idof.){
//         accountId = sb.substring(sb.indexOf(" "), sb.indexOf(" ", sb.indexOf(" ")+1)).trim();
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//         bw.write("A"+accountId+" objid=\"39685688\";");
//         log.info("M=run, msg=Response: A"+accountId+" objid=\"39685688\";");
//         bw.flush();
//         count = 0;
//         sb.delete(0, sb.length());
//         }else if (sb.toString().contains("get RDOOpenSession")){
//         accountId = sb.substring(sb.indexOf(" "), sb.indexOf(" ", sb.indexOf(" ")+1)).trim();
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//         StringBuilder sbResponse = new StringBuilder();
//         sbResponse.append("A").append(accountId).append(" RDOOpenSession=\"#165267116\";");
//         bw.write(sbResponse.toString());
//         log.info("M=run, msg=Response: " + sbResponse.toString());
//         bw.flush();
//         count = 0;
//         sb.delete(0, sb.length());
//         }else if (sb.toString().contains("call RDOMapSegaUser")){
//         accountId = sb.substring(sb.indexOf(" "), sb.indexOf(" ", sb.indexOf(" ")+1)).trim();
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//         StringBuilder sbResponse = new StringBuilder();
//         sbResponse.append("A").append(accountId).append(" res=\"%\";");
//         bw.write(sbResponse.toString());
//         log.info("M=run, msg=Response: " + sbResponse.toString());
//         bw.flush();
//         count = 0;
//         sb.delete(0, sb.length());
//         }else if(sb.toString().contains("call RDOLogonUser")){
//         accountId = sb.substring(sb.indexOf(" "), sb.indexOf(" ", sb.indexOf(" ")+1)).trim();
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//         StringBuilder sbResponse = new StringBuilder();
//         sbResponse.append("A").append(accountId).append(" res=\"#0\";");
//         bw.write(sbResponse.toString());
//         log.info("M=run, msg=Response: " + sbResponse.toString());
//         bw.flush();
//         count = 0;
//         sb.delete(0, sb.length());
//         }else if(sb.toString().contains("call RDOEndSession")){
//         accountId = sb.substring(sb.indexOf(" "), sb.indexOf(" ", sb.indexOf(" ")+1)).trim();
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//         StringBuilder sbResponse = new StringBuilder();
//         sbResponse.append("A").append(accountId).append(";");
//         bw.write(sbResponse.toString());
//         log.info("M=run, msg=Response: " + sbResponse.toString());
//         bw.flush();
//         count = 0;
//         sb.delete(0, sb.length());
//         break;
//         }