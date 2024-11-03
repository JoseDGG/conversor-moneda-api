package com.jdgg.conversor.principal;

import com.jdgg.conversor.servicios.Consultador;
import com.jdgg.conversor.servicios.GenerarArchivo;
import com.jdgg.conversor.ui.Menu;
import com.jdgg.conversor.ui.Resultados;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int eleccionUsuario = 0;
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu(input);
        Consultador consultador = new Consultador();
        Resultados resultados = new Resultados();
        GenerarArchivo generarArchivo = new GenerarArchivo();

        while (eleccionUsuario != 9) {
            menu.imprimirMenu();

            //verifica que input sea un número
            try {
                eleccionUsuario = input.nextInt();

                menu.eleccionDelMenu(eleccionUsuario);
                consultador.setBaseCurrency(menu.getBaseCurrency());

                //Verifica que la opción del menú elegida sea un número del 1 al 7 para llamar a la API
                if (menu.getIsValidOption()){
                    System.out.println("Ingrese el valor que desea convertir");
                    Double baseValue = input.nextDouble();

                    //Se hace el llamado a la API que devuelve un mapa
                    Map<String,Double> mapAPI = consultador.getConversionRates();

                    resultados.guardarEnElHistorial(mapAPI, menu.getBaseCurrency(), menu.getTargetCurrency(), baseValue);
                    resultados.imprimirUltimaConversion();
                }

                if (eleccionUsuario == 8){
                    resultados.imprimirHistorial();
                    generarArchivo.guardar(resultados.getMapHistorial());
                }

            } catch (InputMismatchException e) {
                System.out.println("No es una opción valida");
                input.nextLine(); //Limpia la entrada para no entrar en bucle
            }
        }
    }
}
