package io.turntabl.persistance;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            try (Stream<String> stream = Files.lines(FILEPATH)) {
                return stream
                        .filter(line -> !line.isEmpty() && !line.equals("0,,,,"))
                        .collect(Collectors.toList());

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }


    public boolean store(String name, String address, String telephoneNumber, String email) throws IOException {
        int id = generateId();
        ClientData clientData = new ClientData(id, name, address, telephoneNumber, email);
        String csv = clientData.toCSV();

        if ( fileIsReady()) {
            Files.write(FILEPATH, csv.getBytes(), StandardOpenOption.APPEND);
        }
        return true;
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
        int id;
        try {
            id = Integer.getInteger(split[0]);
        }catch (Exception ex){
            ex.printStackTrace();
            id = 1;
        }
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
            try (Stream<String> stream = Files.lines(FILEPATH)) {
                if (stream.count() > 0) {
                    List<ClientData> removed = Files.lines(FILEPATH)
                            .filter(line -> line.startsWith(Integer.toString(id)))
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
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private boolean matchesId(int id, String line) {
        String s = line.split(",")[0];
        return Integer.getInteger(s).equals(id);
    }

    private int generateId() throws IOException {
        List<String> allData = readFile();
        int collectionSize = allData.size();
        if ( collectionSize == 0){
            return 1;
        }
        String lastLine = allData.get(collectionSize -1);
        Integer value = Integer.getInteger(lastLine.split(",")[0]);
        return  (value + 1);
    }

}
