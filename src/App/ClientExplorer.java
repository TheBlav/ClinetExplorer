package App;

import Data.Client;
import Data.ClientDataReader;
import Interface.Printer;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClientExplorer implements Printer {
    public static void main(String[] args) {
        final String fileName = "C:/clients.csv";
        try {
            Client[] clients = ClientDataReader.readFile(fileName);
            printMostValuableClient(clients);
            String country = readCountryFromUser();
            printClientsFromCountry(clients, country);
            printAverageValueFromCountry(clients, country);
        } catch (FileNotFoundException e) {
            System.err.println("brak pliku o nazwie: "+fileName);
        }
    }

    private static void printAverageValueFromCountry(Client[] clients, String country) {
        double totalValue = 0;
        int clientsFromCountry = 0;
        for (Client client : clients) {
            if (country.equals(client.getCountry())){
                totalValue+=client.getValue();
                clientsFromCountry++;
            }
        }
        if(totalValue>0){
            double avgValue = totalValue / clientsFromCountry;
            System.out.printf("średnia wartość klienta z %s to %.2f", country, avgValue);
        }
    }

    private static void printClientsFromCountry(Client[] clients, String country) {
        System.out.println("Klienci z kraju " + country);
        boolean atLeastOneClient = false;
        for (Client client : clients) {
            if (country.equals(client.getCountry())){
                System.out.println(client);
                atLeastOneClient = true;
            }
            }
        if (!atLeastOneClient){
            System.out.println("Brak klientów");
        }
    }

    private static String readCountryFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwę kraju, z którego klienci Cię interesują: ");
        return sc.nextLine();
    }

    private static void printMostValuableClient(Client[] clients) {
        Client mostValuaCLient = clients[0];
        for (Client client : clients) {
            if (client.getValue()>mostValuaCLient.getValue()) {
            mostValuaCLient = client;
            }
        }
        System.out.println("Najbardziej wartościowy klient to: ");
        System.out.println(mostValuaCLient);
    }
}
