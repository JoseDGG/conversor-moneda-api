import java.util.HashMap;
import java.util.Map;

public class Resultados {
    private String baseHistorial;
    private String targetHistorial;
    private int instancias = 0;
    private Map<String,String> mapHistorial = new HashMap<>();

    public Map<String, String> getMapHistorial() {
        return mapHistorial;
    }

    //el metodo imprimirUltimaConversion() solo se actualiza después de guardar los datos
    public void imprimirUltimaConversion(){
        System.out.println(baseHistorial + " = " + targetHistorial);
    }

    public void guardarEnElHistorial(Map<String, Double> mapAPI, String baseCurrency, String targetCurrency, Double baseValue){
        try {
        baseHistorial = baseCurrency + " " + (mapAPI.get(baseCurrency) * baseValue );
        targetHistorial = targetCurrency + " " + (mapAPI.get(targetCurrency) * baseValue);

        instancias += 1;
        mapHistorial.put((String.valueOf(instancias)), baseHistorial + " = " + targetHistorial);
        }catch (NullPointerException e){
            System.out.println("Error, verifique los datos");
        }
    }

    public void imprimirHistorial() {
        if (mapHistorial.isEmpty()){
            System.out.println("Aún no hay un historial de conversiones");
        }else{
            for (Map.Entry<String, String> entry : mapHistorial.entrySet()) {
                System.out.println(entry.getKey() + ".) " + entry.getValue());
            }
        }
    }
}

