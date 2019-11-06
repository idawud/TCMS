package io.turntabl.persistance;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc Storing & Retrieving Client Information from a File
 */
public class ClientInformationPersistence {
    private static final Path FILEPATH = Paths.get("./resources/clientsInformation.txt");

    private boolean fileIsReady() throws IOException {
        if (!Files.isDirectory(Paths.get("./resources"))){
            Files.createDirectory(Paths.get("./resources"));
        }
        if ( Files.notExists(FILEPATH)) {
            Files.createFile(FILEPATH);
        }
        return true;
    }

    private List<String> readFile() throws IOException {
        if ( fileIsReady()) {
            List<String> allLines = Files.readAllLines(FILEPATH);
                return  allLines.stream()
                        .filter(line -> !line.isEmpty() && !line.equals("0,,,,"))
                        .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }


    public boolean store(String name, String address, String telephoneNumber, String email) throws IOException {
        int id = generateId();
        ClientData clientData = new ClientData(id, name, address, telephoneNumber, email);

        if ( clientDoesNotExists(clientData)) {
            String csv = clientData.toCSV();

            if (fileIsReady()) {
                Files.write(FILEPATH, csv.getBytes(), StandardOpenOption.APPEND);
            }
            return true;
        }
        return false;
    }

    private boolean clientDoesNotExists(ClientData clientData) throws IOException {
        List<ClientData> allData = retrieveAll();
        return ( allData.stream().noneMatch(clientData1 -> clientData1.equals(clientData)) );
    }

    public List<ClientData> retrieveAll() throws IOException {
        List<String> allData = readFile();
        return allData.stream()
                .map(this::stringToClientData)
                .collect(Collectors.toList());
    }

    private ClientData stringToClientData(String s) {
        String[] split = s.split(",");
        if ( split.length != 5){
            return new ClientData(0,"","", "","");
        }
        int id = Integer.parseInt(split[0]);
        return new ClientData(id, split[1], split[2], split[3], split[4]);
    }

    private String clientDataToCsvString(ClientData clientData){
        String[] split = clientData.toCSV().split(",");
        if (split.length != 5){
            return "";
        }
        return ( split[0] + "," + split[1] + "," + split[2] + "," + split[3] + "," + split[4] + "\n");
    }

    public List<ClientData> search(String name) throws IOException {
        List<String> allData = readFile();
        return allData.stream()
                .filter(s -> (s.split(",")[1]).equals(name))
                .map(this::stringToClientData)
                .collect(Collectors.toList());
    }

    public boolean delete(int id) throws IOException {
        if ( fileIsReady()) {
            List<String> allLines = Files.readAllLines(FILEPATH);
                if (allLines.size() > 0) {
                    List<ClientData> removed = readFile()
                                                    .stream()
                                                    .filter(line -> !isSameId(id, line))
                                                    .map(this::stringToClientData)
                                                    .collect(Collectors.toList());

                    Files.delete(FILEPATH);
                    if (fileIsReady()) {
                        removed.forEach(clientData -> {
                            try {
                                Files.write(FILEPATH, clientDataToCsvString(clientData).getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
                else {
                    return false;
                }
        }
        return false;
    }

    private boolean isSameId(int id, String line) {
        int x = Integer.parseInt(line.split(",")[0]);
        return (x == id);
    }

    private int generateId() throws IOException {
        List<String> allData = readFile();
        int collectionSize = allData.size();
        if ( collectionSize == 0){
            return 1;
        }

        String ints = allData.get(collectionSize - 1).split(",")[0];
        return  ( Integer.parseInt(ints) +1);
    }

}
