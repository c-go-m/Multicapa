/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptor.multicapa;

/**
 *
 * @author Andres
 */
public class Perceptor 
{
   private double NEntradas[][];
   private double MSalidas[];
   private double Ocultas[];
   private double EjentrSal[][];
   private double Potenciales[];
   public double lambda1;
   public double lambda2;  
   double epsilon;
   public double ECMs;
   public double pECMs;
   public double ECMv;
   public double pECMv;

    public Perceptor(double entrenamiento[][], int entradas) {
        
        LlenarEntradas(entrenamiento, entradas);
    }
   
    private void LlenarEntradas(double entrenamiento[][], int entradas){
        NEntradas = new double[entradas][entrenamiento[0].length];
        
        for(int i = 0 ; i < entrenamiento[0].length ; i++){
            System.err.println(" ");
            for(int j = 0; j < entradas; j++) {
                NEntradas[j][i] = entrenamiento[j][i];
                System.err.print(NEntradas[j][i] + " / ");
            }
        }
    }

}
