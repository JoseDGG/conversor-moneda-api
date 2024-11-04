# Conversor de Divisas

Este es un proyecto en Java que permite realizar conversiones de divisas en tiempo real utilizando la API de ExchangeRate-API. El programa también guarda un historial de conversiones y puede exportar los resultados a un archivo JSON para un fácil seguimiento.

## Características

- Conversión de varias divisas con soporte para:
  - Dólar a Peso Colombiano
  - Peso Colombiano a Dólar
  - Dólar a Real Brasileño
  - Real Brasileño a Dólar
  - Dólar a Peso Mexicano
  - Peso Mexicano a Dólar
  - Opción personalizada usando el estándar ISO 4217 para otras divisas.
- Guardado de un historial de conversiones.
- Exportación del historial de conversiones en formato JSON.

## Estructura del Proyecto

El proyecto está organizado en varias clases:

- **Principal**: Clase principal para ejecutar el programa.
- **Menu**: Clase que maneja la interacción con el usuario y permite elegir opciones de conversión por defecto.
- **Consultador**: Clase para realizar las llamadas a la API de ExchangeRate-API y obtener las tasas de conversión.
- **Resultados**: Clase para mostrar los resultados de las conversiones, guardar y gestionar el historial de conversiones.
- **GenerarArchivo**: Clase para exportar el historial de conversiones en un archivo JSON.
