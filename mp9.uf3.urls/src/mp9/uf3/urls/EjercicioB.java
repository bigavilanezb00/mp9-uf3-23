package mp9.uf3.urls;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
public class EjercicioB {

    private static void executePost(URL url,String nombre, boolean respuesta) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());

        if (respuesta) {
            outputStreamWriter.write("entry.835030737="+nombre+"&entry.1616686619=Si");
        } else {
            outputStreamWriter.write("entry.835030737="+nombre+"&entry.1616686619=NO");
        }

        outputStreamWriter.flush();
        outputStreamWriter.close();
        connection.getInputStream();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String enlace = "https://docs.google.com/forms/d/e/1FAIpQLSdV5QvhChK0fBpAMo5pN7sIvktqwHGu1vdoWJFvBguCeMvYUw/viewform";
        System.out.println("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println();
        System.out.println("Si o no: ");
        String respuesta = scanner.nextLine();

        boolean correcto = respuesta.equals("si") || respuesta.equals("Si") || respuesta.equals("SI");

        EjercicioB.executePost(new URL(enlace),nombre,correcto);
    }
}
