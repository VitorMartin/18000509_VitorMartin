// Vitor Martin Simoni - RA 18.00050-9

import java.util.Random;

public class T {
    public static String gerarQRCode(Conta c, double valor){
        String id = c.getID(), nome = c.getNome();
        String code = "";
        int key = getRandomNumberInRange(1000, 9999);
        
        code += String.format("%s;%s;%f;%d", id, nome, valor, key);

        return code;
    }

    public static boolean transferir(Conta quemPaga, Conta quemRecebe, String code){
        String[] dados = code.split(";");
        String id = dados[0];
        String nome = dados[1];
        double valor = Double.parseDouble(dados[2].replace(",", "."));
        int key = Integer.parseInt(dados[3]);

        if(!id.equals(quemRecebe.getID())){
            System.out.println("ID diferente do QRCode");
            return false;
        }
        else{
            if(quemPaga.getSaldo() >= valor){
                quemPaga.sacar(valor);
                quemRecebe.depositar(valor);
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}