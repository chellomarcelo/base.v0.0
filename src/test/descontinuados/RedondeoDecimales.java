package test.descontinuados;

/* Curso java avanzado aprenderaprogramar.com*/
public class RedondeoDecimales {

   public static void main(String[] args) {
       float numero=(float) 8.5252719;
       System.out.print("El numero 8.5252719 con 2 decimales queda "+ redondearDecimales(numero, 2));
       System.out.println(". Con 4 decimales queda "+redondearDecimales(numero, 4)+
" y con 6 decimales queda "+redondearDecimales(numero, 6));
       numero=(float) 12.5552917;
       System.out.print("El numero 12.5552917 con 2 decimales queda "+ redondearDecimales(numero, 2));
       System.out.println(". Con 4 decimales queda "+redondearDecimales(numero, 4)+
" y con 6 decimales queda "+redondearDecimales(numero, 6));
       numero= (float) -12.5566112345;
       System.out.print("El numero -12.5566112345 con 2 decimales queda "+ redondearDecimales(numero, 2));
       System.out.println(". Con 4 decimales queda "+redondearDecimales(numero, 4)+
" y con 6 decimales queda "+redondearDecimales(numero, 6));

       // get two float numbers
       float x = 1654.9874f;
       float y = -9765.134f;

       // find the closest int for these floats
       System.out.println("Math.round(" + x + ")=" + Math.round(x));
       System.out.println("Math.round(" + y + ")=" + Math.round(y));
       
   }

   public static double redondearDecimales(double valorInicial, int numeroDecimales) {
       double parteEntera, resultado;
       resultado = valorInicial;
       parteEntera = Math.floor(resultado);
       resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
       resultado=Math.round(resultado);
       resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
       return resultado;
   }


}