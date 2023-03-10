/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptor.multicapa;

import java.io.File;


public class Principal 
{
    private Ejemplos ejemplos;
    private Perceptor perceptor;
    
    private void ejecutar()
    { 
        ejemplos = new Ejemplos("src/file/informacion.txt");
        perceptor = new Perceptor(ejemplos.Entrenamiento,5);                
    }      
    
    public static void main(String[] args)
    {
       new Principal().ejecutar();
    }
}    
    

