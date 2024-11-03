import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GenerarArchivo extends Resultados{

    public void guardar(Map<String, String> historial) {
        if(historial.isEmpty() || historial.containsValue(null)){
            System.out.println("No se pudo generar el archivo");
        }else {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            try{
                FileWriter escritura = new FileWriter("Historial de conversiones.json");
                escritura.write(gson.toJson(historial));
                escritura.close();
                System.out.println("Archivo 'Historial de conversiones.json' creado exitosamente");
            } catch (IOException e) {
                System.out.println("No ha sido posible crear el archivo");
                throw new RuntimeException(e);
            }
        }
    }
}
