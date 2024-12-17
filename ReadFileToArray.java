import java.io.*;
import java.util.ArrayList;

public class ReadFileToArray {
    public static String[] readFile (String arg) {
        /**Crear file*/
        File file = new File(arg);        
        /**para almacenar temporalmente las líneas del archivo*/
        ArrayList<String> list = new ArrayList<String>();
        /**Crear arreglo para exportar*/
        String[] array;

        try {
            /** leer texto línea por línea.*/
            BufferedReader in = new BufferedReader(new FileReader(file));
            String s;
            /**Lee línea del archivo,si no hay más líneas, devuelve null.*/
            s = in.readLine();
            while(s!=null) {
                list.add(s);
                s = in.readLine();
            }
            /**Cierra el buffer*/
            in.close();

        } catch (FileNotFoundException e1) {

            System.err.println("File not found: " + file);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        /**Convertir a arreglo*/
        array = list.toArray(new String[0]);

        return array;
    }
}