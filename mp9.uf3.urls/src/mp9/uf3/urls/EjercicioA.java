package mp9.uf3.urls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjercicioA {
    private static void printContent(URL url, String ETIQUETA){
        InputStream inputStream;
        BufferedReader bufferedReader;


        try {
            inputStream = url.openStream();
            InputStreamReader inr = new InputStreamReader(inputStream);

            bufferedReader = new BufferedReader(inr);

            String line = bufferedReader.readLine();

            while (line != null){
                if (line.contains(ETIQUETA)){
                    System.out.println(line);
                }
                line = bufferedReader.readLine();
            }


            System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(EjercicioA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        String enlace = args[0];
        String etiqueta = args[1];

        try {
            EjercicioA.printContent(new URL(enlace), etiqueta);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
