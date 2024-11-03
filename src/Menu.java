import java.util.Scanner;

public class Menu {
    private String baseCurrency;
    private String targetCurrency;
    private boolean isValidOption;
    private final Scanner scan;

    public Menu(Scanner scan){
        this.scan = scan;
    }
    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public boolean getIsValidOption() {
        return isValidOption;
    }

    public void imprimirMenu() {
        System.out.println("""
                ***********************************************
                Sea Bienvenido/a al conversor de moneda
                Las opciones son:
                1.) Dólar =>> Peso Colombiano
                2.) Peso Colombiano =>> Dólar
                3.) Dólar =>> Real Brasileño
                4.) Real Brasileño =>> Dólar
                5.) Dólar =>> Peso Méxicano
                6.) Peso Méxicano =>> Dólar
                7.) Personalizado: Usa el estandard ISO 4217 para escribir código textual de la moneda. Ej: USD
                8.) Ver Historial de conversiones y generar archivo
                9.) Salir
                Digite una opción válida:
                ***********************************************""");
    }

    public void eleccionDelMenu(int eleccionUsuario){
        this.isValidOption = false;
        switch (eleccionUsuario){
            case 1:
                this.baseCurrency = "USD";
                this.targetCurrency = "COP";
                this.isValidOption = true;
                break;
            case 2:
                this.baseCurrency = "COP";
                this.targetCurrency = "USD";
                this.isValidOption = true;
                break;
            case 3:
                this.baseCurrency = "USD";
                this.targetCurrency = "BRL";
                this.isValidOption = true;
                break;
            case 4:
                this.baseCurrency = "BRL";
                this.targetCurrency = "USD";
                this.isValidOption = true;
                break;
            case 5:
                this.baseCurrency = "USD";
                this.targetCurrency = "MXN";
                this.isValidOption = true;
                break;
            case 6:
                this.baseCurrency = "MXN";
                this.targetCurrency = "USD";
                this.isValidOption = true;
                break;
            case 7:
                opcion7();
                this.isValidOption = true;
                break;
            case 8:
                //Historial no necesita actualización
                break;
            case 9:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida, intente de nuevo");
                baseCurrency = null;
                targetCurrency = null;
        }
        if (isValidOption){
            System.out.println("Opción escogida: " + eleccionUsuario + "\n" + baseCurrency + " =>> " + targetCurrency);
        }
    }

    private void opcion7(){
        scan.nextLine();
        System.out.println("Escriba el código de la moneda base a convertir:");
        baseCurrency = scan.nextLine().toUpperCase();
        System.out.println("Escriba el código de la moneda objetivo:");
        targetCurrency = scan.nextLine().toUpperCase();
    }
}
