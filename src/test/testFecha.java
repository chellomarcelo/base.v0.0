package test;

import logica.fecha;

public class testFecha {

	public static void main(String[] args) {
		
		fecha f = new fecha();
		//System.out.println("Año: "+f.getAno());
		//System.out.println("Mes: "+f.getMes());
		//System.out.println("Día: "+f.getDia());
		
		//System.out.println(f.getFecha());
		//System.out.println(f.listarFecha());
		
		//Pruebas de control fecha para el ingreso de productos.
		String fechaVencimiento = "2016/03/27";
		    
		if(!fechaVencimiento.matches("\\d*")){
			System.out.println("no hay numeros");
		}else{
				boolean formato = true;
				String[] fecha = fechaVencimiento.split("/");
				
				System.out.println(fecha[0]);
			    System.out.println(fecha[1]);
			    System.out.println(fecha[2]);
			    
			    
			    int anio1 = Integer.parseInt(f.getAno());
			    int anio2 = Integer.parseInt(fecha[0]);
			    int mes1 = Integer.parseInt(f.getMes());
			    int mes2 = Integer.parseInt(fecha[1]);
			    int dia1 = Integer.parseInt(f.getDia());
			    int dia2 = Integer.parseInt(fecha[2]);
			    
			    if (anio2<anio1){
			    	formato=false;
			    }else{   
			    	if(anio2==anio1){
			    		if (mes2<mes1 || mes2>12){
			    			formato=false;
			    		}else{
			    			if ((anio2 % 4 == 0) && ((anio2 % 100 != 0) || (anio2 % 400 == 0))){
			    				if ((dia2<dia1 && mes2==2) || (mes2==2 && dia2>29))
			    					formato=false;
			    			}else{
			    				if ((dia2<dia1 && mes2==mes1) || (mes2==2 && dia2>28))
			    					formato=false;
			    			}
			    			if((dia2<dia1 && mes2==mes1)|| (mes2==1 && dia2>31) || (mes2==3 && dia2>31) || (mes2==5 && dia2>31) || (mes2==7 && dia2>31) || (mes2==8 && dia2>31) || (mes2==10 && dia2>31) || (mes2==12 && dia2>31) ){
			    				formato=false;
			    			}
			    		
			    			if((dia2<dia1 && mes2==mes1) || (mes2==4 && dia2>30) || (mes2==6 && dia2>30) || (mes2==9 && dia2>30) || (mes2==11 && dia2>30)){
			    				formato=false;
			    			}
			    		}
			    }else{
			    	if (mes2>12){
		    			formato=false;
		    		}else{
		    			if ((anio2 % 4 == 0) && ((anio2 % 100 != 0) || (anio2 % 400 == 0))){
		    				if (mes2==2 && dia2>29)
		    					formato=false;
		    			}else{
		    				if (mes2==2 && dia2>28)
		    					formato=false;
		    			}
		    			if((mes2==1 && dia2>31) || (mes2==3 && dia2>31) || (mes2==5 && dia2>31) || (mes2==7 && dia2>31) || (mes2==8 && dia2>31) || (mes2==10 && dia2>31) || (mes2==12 && dia2>31) ){
		    				formato=false;
		    			}
		    		
		    			if((mes2==4 && dia2>30) || (mes2==6 && dia2>30) || (mes2==9 && dia2>30) || (mes2==11 && dia2>30)){
		    				formato=false;
		    			}
		    		}
		    	}
			    }
			    if(formato)
			    	System.out.println("ok");
		}
	}
	
		
		
}
