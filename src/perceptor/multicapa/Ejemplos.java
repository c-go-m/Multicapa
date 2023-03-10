package perceptor.multicapa;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejemplos {

    public double Validacion[][];
    public double Entrenamiento[][];
    private double General[][];

    Ejemplos(String url) {
        File archivo = ObtenerArchivo(url);
        
        int filas = ObtenerFilas(url);
        int columnas = ObtenerColumnas(archivo);
        
        General = new double[columnas][filas];
        
        LeerArchivo(archivo);
        
        AsignarValoresMatrices(filas, columnas);
    }

    private File ObtenerArchivo(String url) {        
        return new File(url);
    }

    private void LeerArchivo(File archivo) {
        try {
            Scanner scanner = new Scanner(archivo);
            int fila = 0;
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split("/");

                CrearMatrizGeneral(datos, fila);
                fila = fila + 1;
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        }
    }

    private void CrearMatrizGeneral(String[] valores, int fila) {
        for (int i = 0; i < valores.length; i++) {
            General[i][fila]= Double.parseDouble(valores[i]);
        }
    }

    private int ObtenerFilas(String archivo) {
        try {
            Path file = Paths.get(archivo);
            long filas = Files.lines(file).count();
            return (int)filas;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return 0;
    }

    private int ObtenerColumnas(File archivo) {
        try {
            Scanner scanner = new Scanner(archivo);
            
            String linea = scanner.nextLine();
            String[] datos = linea.split("/");            
            
            scanner.close();
            
            return datos.length;
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        }
        return 0;
    }
    
    private void AsignarValoresMatrices(int filas,int columnas){                
        Validacion = new double[columnas][(int)(filas * 0.2)];
        Entrenamiento = new double[columnas][(int)(filas * 0.8)];
        
        List<Integer> numeros = GenerarListaAleatoria(filas);
            
        int filaE = 0;
        boolean inicioConteofilaE = false;
        
        for (int i = 0; i < numeros.size(); i++) {             
            
            for (int j = 0; j < columnas; j++) {                  
                
                if(Validacion[j].length > i ){
                    Validacion[j][i] = General[j][numeros.get(i)];                    
                }
                
                if(Validacion[j].length <= i && Entrenamiento[j].length > filaE){
                    inicioConteofilaE = true;
                    Entrenamiento[j][filaE] = General[j][numeros.get(i)];                                        
                }                
            }   
            if(inicioConteofilaE){
            filaE = filaE + 1;
            }
            
        }
    }
    
    private List<Integer> GenerarListaAleatoria(int filas){
        List<Integer> numeros = new ArrayList<Integer>();
            
        int numero;
        
        for (int i = 1; i <= filas; i++) {
            numero = (int) (Math.random() * filas);
            if (numeros.contains(numero)) {
                i--;
            } else {
            numeros.add(numero);
            }
        }
        return numeros;
    }
}
