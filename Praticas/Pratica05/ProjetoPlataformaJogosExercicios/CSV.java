import java.io.BufferedReader;
import java.io.FileReader;

public class CSV {
    public char separador;

    public readCSV(String csv, char separador, String caminho){
        String row;
        String[] dataBase = new String[3];
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(caminho));
            for (int i = 0; i < 3; i++) {
                row = csvReader.readLine();
                if (row != null) {
                    dataBase[i] = row.split(";")[1];
                } else {
                    System.out.println("Nenhum usuario registrado.");
                    break;
                }
            }
            csvReader.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Arquivo \"" + caminho + "\" nao encontrado");
            System.out.println(e);
            return false;
        }
    }
}