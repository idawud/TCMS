package io.turntabl.persistance;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Desc Storing & Retrieving Client Information from a File
 */
public class ClientInformationPersistence {
    public static final Path FILEPATH = Paths.get("./resources/clientsInformation.txt");
    public static final Path ARCHIVEPATH = Paths.get("./resources/archive.txt");

    private boolean fileIsReady() throws IOException {
        if (!Files.isDirectory(Paths.get("./resources"))){
            Files.createDirectory(Paths.get("./resources"));
        }
        if ( Files.notExists(FILEPATH)) {
            Files.createFile(FILEPATH);
        }
        if ( Files.notExists(ARCHIVEPATH)) {
            Files.createFile(ARCHIVEPATH);
        }
        return true;
    }

    private List<String> readFile(Path path) throws IOException {
        if ( fileIsReady()) {
            List<String> allLines = Files.readAllLines(path);
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
        List<String> allData = readFile(FILEPATH);
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

    public List<ClientData> search(String name, Path path) throws IOException {
        List<String> allData = readFile(path);
        return allData.stream()
                .filter(s -> (s.split(",")[1]).toLowerCase().trim().contains(name.toLowerCase().trim()))
                .map(this::stringToClientData)
                .collect(Collectors.toList());
    }

    public boolean delete(int id) throws IOException {
        if ( fileIsReady()) {
                if (Files.readAllLines(FILEPATH).size() > 0) {
                    List<ClientData> updatedRecord = filterClientDataOutById(id, FILEPATH);
                    Optional<ClientData> removed = removedClientData(id, FILEPATH);

                    writingFilteredClientDataToFile(updatedRecord, FILEPATH);
                    removed.ifPresent(archive -> {
                        try {
                            moveClientTo(archive, ARCHIVEPATH);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    return true;
                }
                else {
                    return false;
                }
        }
        return false;
    }

    private void writingFilteredClientDataToFile(List<ClientData> removed, Path path) throws IOException {
        Files.delete(path);
        if (fileIsReady()) {
            removed.forEach(clientData -> {
                try {
                    Files.write(path, clientDataToCsvString(clientData).getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private List<ClientData> filterClientDataOutById(int id, Path path) throws IOException {
        return readFile(path)
                    .stream()
                    .filter(line -> !hasSameId(id, line))
                    .map(this::stringToClientData)
                    .collect(Collectors.toList());
    }

    private void moveClientTo(ClientData archive, Path path) throws IOException {
        if (fileIsReady()) {
            List<ClientData> dataList = readFile(path)
                    .stream()
                    .map(this::stringToClientData)
                    .collect(Collectors.toList());
            dataList.add(archive);
            dataList.sort(Comparator.comparing(ClientData::toCSV));

            Files.delete(path);
            if (fileIsReady()) {
                dataList.forEach(clientData -> {
                    try {
                        Files.write(path, clientDataToCsvString(clientData).getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    private Optional<ClientData> removedClientData(int id, Path path) throws IOException {
        return readFile(path)
                .stream()
                .filter(line -> hasSameId(id, line))
                .map(this::stringToClientData)
                .findFirst();
    }

    private boolean hasSameId(int id, String line) {
        int x = Integer.parseInt(line.split(",")[0]);
        return (x == id);
    }

    private int generateId() throws IOException {
        List<String> allData = readFile(FILEPATH);
        int collectionSize = allData.size();
        if ( collectionSize == 0){
            return 1;
        }

        String ints = allData.get(collectionSize - 1).split(",")[0];
        return  ( Integer.parseInt(ints) +1);
    }

    public boolean recover(int id) throws IOException {
        if (fileIsReady()){
            List<ClientData> updatedRecord = filterClientDataOutById(id, ARCHIVEPATH);
            Optional<ClientData> removed = removedClientData(id, ARCHIVEPATH);
            writingFilteredClientDataToFile(updatedRecord, ARCHIVEPATH);

            removed.ifPresent(archive -> {
                try {
                    moveClientTo(archive, FILEPATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return false;
    }
}
