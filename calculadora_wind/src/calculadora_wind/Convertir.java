

package calculadora_wind;

import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Convertir {
    private BigInteger numeroDecimal;//este es el que se convierte a los otros formatos   
    private ArrayList<BigInteger> resultadoConver = new ArrayList<>();     
    private ArrayList<BigInteger> numeroEntero ;
    public Convertir() {
    }
  
    public void convertirFormatoBiDeOcHex(BigInteger  NumeroConvertir,BigInteger base/*2,8 ó 16*/,JTextArea im){//funcion para convertir el número ingresado a los otros formatos       
       resultadoConver.clear();
       while(NumeroConvertir.compareTo(BigInteger.ZERO)!=0){// se compara para ver si es diferente de 0
           resultadoConver.add(NumeroConvertir.mod(base));// dividimos el numero entre la base y se captura el resto
           NumeroConvertir = NumeroConvertir.divide(base);// dividiomos entre la base                      
       }
       im.setText("");
       for (int i = resultadoConver.size()-1; i >=0; i--) {
           if(base.compareTo(new BigInteger("16")) == 0){
               if(resultadoConver.get(i).compareTo(new BigInteger("10"))==0) im.setText(im.getText()+"A");
               else if(resultadoConver.get(i).compareTo(new BigInteger("11"))==0) im.setText(im.getText()+"B");
               else if(resultadoConver.get(i).compareTo(new BigInteger("12"))==0) im.setText(im.getText()+"C");
               else if(resultadoConver.get(i).compareTo(new BigInteger("13"))==0) im.setText(im.getText()+"D");
               else if(resultadoConver.get(i).compareTo(new BigInteger("14"))==0) im.setText(im.getText()+"E");
               else if(resultadoConver.get(i).compareTo(new BigInteger("15"))==0) im.setText(im.getText()+"F");
               else im.setText(im.getText()+resultadoConver.get(i));
           }
           else im.setText(im.getText()+resultadoConver.get(i));
      }
     }
  public void convertirAdecimal( BigInteger base/*2,8 ó 16 esta base es la que esta el numero ingresado pot teclado para convertit */){
        numeroDecimal = new BigInteger("0");
        int cantiNum = numeroEntero.size();
        BigInteger r;
        for(int i=0;i<numeroEntero.size();i++){ //convertir numero ingresado a formato decimal
             cantiNum --;
             r = base.pow(cantiNum);
             numeroDecimal = numeroDecimal.add(numeroEntero.get(i).multiply(r));// se suman 
        }       
  }
  public void pasarNumeroLetraAentero(String numero){     // funcion convierte las letras a numeros enteros   
        numeroEntero = new ArrayList<>();
        for (int i = 0; i < numero.length(); i++) {
            if(Character.isDigit(numero.charAt(i))){
                numeroEntero.add(new BigInteger(""+numero.charAt(i)));// si es un numero se convirte a bitInteger y se agrega al array
            }
            else{
                 if(numero.charAt(i)=='a'||numero.charAt(i)=='A')  numeroEntero.add(new BigInteger("10"));
                 else if(numero.charAt(i)=='b'||numero.charAt(i)=='B')  numeroEntero.add(new BigInteger("11"));
                 else if(numero.charAt(i)=='c'||numero.charAt(i)=='C')  numeroEntero.add(new BigInteger("12"));
                 else if(numero.charAt(i)=='d'||numero.charAt(i)=='D')  numeroEntero.add(new BigInteger("13"));
                 else if(numero.charAt(i)=='e'||numero.charAt(i)=='E')  numeroEntero.add(new BigInteger("14"));
                 else if(numero.charAt(i)=='f'||numero.charAt(i)=='F')  numeroEntero.add(new BigInteger("15"));
            }
        }
    }

    public BigInteger getNumeroDecimal() {
        return numeroDecimal;
    }
  
}
