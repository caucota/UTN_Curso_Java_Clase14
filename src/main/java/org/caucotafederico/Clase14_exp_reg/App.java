package org.caucotafederico.Clase14_exp_reg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Expresiones Regulares
1. Realice un programa que tome como parámetros un archivo y una expresión regular,
para cada línea, debe escribir el número y si la misma se corresponde con la expresión
regular o no
2. A partir del programa anterior, hacer lo mismo, solo que la expresión regular debe
tener grupos y por cada línea se deben imprimir los grupos o textos extraídos de la
misma.
 */
public class App 
{
    public static void main( String[] args )
    {
        String rutaArchivo = "src\\resources\\archivo.txt";
        String expRegular = "\\b(año|AÑO):\\d{4} Nombre:.+";
        String linea;
        int nroLinea = 0;
        String correspondeConRexExp = "No se corresponde con la Expresión Regular";
		final Pattern pattern = Pattern.compile(expRegular, Pattern.MULTILINE);
		Matcher matcher;
        
        if(args.length == 0) {
        //	System.out.print("Faltan las rutas de los archivos");
        //	System.exit(88);
        }else {
        	rutaArchivo = args[0];
        	if (args.length > 1) {
        		expRegular = args[1];
        	}
        		
        }
        
        
        System.out.println("---------------------------------------------");
        System.out.println("               Ejercicio 1");
        System.out.println("---------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while ((linea = br.readLine()) != null) {
            	matcher = pattern.matcher(linea);
            	if (matcher.find()) {
            		correspondeConRexExp = "SI se corresponde con la Expresión Regular";
            	}else {
            		correspondeConRexExp = "NO se corresponde con la Expresión Regular";
            	}
                System.out.println("Linea " + nroLinea + "-->" + correspondeConRexExp + " ----> " + linea);
                nroLinea++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }		
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        
        nroLinea = 0;
        System.out.println("---------------------------------------------");
        System.out.println("               Ejercicio 2");
        System.out.println("---------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while ((linea = br.readLine()) != null) {
            	correspondeConRexExp = "";
            	matcher = pattern.matcher(linea);
            	/*
            	if (matcher.find()) {
            		correspondeConRexExp = "SI se corresponde con la Expresión Regular";
            	}else {
            		correspondeConRexExp = "NO se corresponde con la Expresión Regular";
            	}
            	*/
                System.out.println("Linea " + nroLinea + "- TEXTO:" + linea);
                while (matcher.find()) {
            		correspondeConRexExp = "SI se corresponde con la Expresión Regular!!!!!";
        			System.out.println(correspondeConRexExp);
        			System.out.println("Full match: " + matcher.group(0));

        			for (int i = 1; i <= matcher.groupCount(); i++) {
        				System.out.println("Grupo " + i + ": " + matcher.group(i));
        			}
        		}
                if(correspondeConRexExp.equals("")) {
                	System.out.println("NO se corresponde con la Expresión Regular");

                }
                System.out.println("");
                nroLinea++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }		
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------");
        /*

		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));

			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}
        */
        
        
    }
}
