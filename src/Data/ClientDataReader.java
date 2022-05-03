package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClientDataReader  {
    public static Client[] readFile(String fileName) throws FileNotFoundException {
        final int linesNumber =  countLinesWithoutHeader(fileName);
        Client[] clients = new Client[linesNumber];
        try(Scanner scanner = new Scanner(new File(fileName))){
            scanner.nextLine();
            for (int i=0; i< linesNumber; i++){
                String csvLine = scanner.nextLine();
                clients[i] = createClientFromCsv(csvLine);
            }
        }
        return clients;
    }

    private static Client createClientFromCsv(String csvLine) {
        String[] data = csvLine.split(",");
        int id = Integer.parseInt(data[0]);
        String firstName = data[1];
        String lastName = data[2];
        String country = data[3];
        double value = Double.parseDouble(data[4]);
        return  new Client(id, firstName, lastName, country, value);
    }

    private static int countLinesWithoutHeader(String fileName) throws FileNotFoundException {
        int lines = 0;
        try (Scanner sc = new Scanner(new File(fileName))){
            sc.nextLine();
            while (sc.hasNextLine()){
                sc.nextLine();
                lines++;
            }
        }
        return lines;
    }
}
