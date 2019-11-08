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
    public static final Path IDPATH = Paths.get("./resources/id.txt");

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

    public boolean moveRecord(int id, Path fromPath, Path toPath) throws IOException {
        if ( fileIsReady()) {
                if (Files.readAllLines(fromPath).size() > 0) {
                    List<ClientData> updatedRecord = filterClientDataOutById(id, fromPath);
                    Optional<ClientData> removed = removedClientData(id, fromPath);

                    writingFilteredClientDataToFile(updatedRecord, fromPath);
                    removed.ifPresent(archive -> {
                        try {
                            moveClientTo(archive, toPath);
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
        if ( Files.notExists(IDPATH)) {
            Files.createFile(IDPATH);
            Files.write(IDPATH, String.valueOf(0).getBytes(), StandardOpenOption.WRITE);
        }

        List<String> allLines = Files.readAllLines(IDPATH);
        if ( allLines.size() > 1){
            return 1;
        }

        String ints = allLines.get(0).trim();
        int value = Integer.parseInt(ints) + 1;
        Files.write(IDPATH, String.valueOf(value).getBytes(), StandardOpenOption.WRITE);
        return  value;
    }

}
