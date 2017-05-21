package logica;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import persistencia.AccesoBD;

import logica.Config;
import logica.vo.voProveedor;
import logica.vo.voTipoProveedor;

public class GenerarExcel {

	private String[] ReporteProv = {"Rut", "Nombre Oficial","Nombre Fantasia","Nombre Auxiliar", "Tipo Proveedor", "Dirección 1", "Dirección 2","Dirección 3", "Telefono 1","Telefono 2", "Telefono 3", "Celular 1", "Celular 2", "Celular 3", "Correo 1", "Correo 2", "Correo 3", "Contacto 1", "Contacto 2", "Contacto 3","Comentario", "Horario Atención"};
	private fecha f;
	
	public GenerarExcel(){
		
	}
	
	public void GenerarExcelReport (String _nombreReporte, ArrayList<voProveedor> arrProv) throws FileNotFoundException, IOException{
		boolean opcionFecha=true;
		String rutaArchivo ="";
		
		if (f==null){
			f = new fecha();
		}
		if(opcionFecha){
			System.out.println(f.getAno()+f.getMes()+f.getDia()+"-"+f.getHora().replaceAll(":",""));
			
			rutaArchivo = Config.getInstance().getProperty(Config.REPORTE_PROVEEDOR) +"/Prov_"+f.getAno()+f.getMes()+f.getDia()+"-"+f.getHora().replaceAll(":","")+".xls";
		}else{
			/*La ruta donde se creará el archivo, la ruta la guardamos en un properties*/
			rutaArchivo = Config.getInstance().getProperty(Config.REPORTE_PROVEEDOR) +"/ejemploExcelJava2.xls";
		}
		
		/*Creamos el objeto de tipo File con la ruta del archivo*/
        File archivoXLS = new File(rutaArchivo);
        /*Si el archivo existe se elimina*/
        if(archivoXLS.exists()) archivoXLS.delete();
        /*Se crea el archivo*/
        archivoXLS.createNewFile();
        
        /*Se crea el libro de excel usando el objeto de tipo Workbook*/
        Workbook libro = new HSSFWorkbook();
        /*Se inicializa el flujo de datos con el archivo xls*/
        FileOutputStream archivo = new FileOutputStream(archivoXLS);
        if(_nombreReporte.equals("Proveedor")){
        		System.out.println("Entro");
		        /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
		        Sheet hoja = libro.createSheet(_nombreReporte);
		        
		        /*ACA ENTRA LA LOGICA*/
		        //Primero deberia de contar la cantiad de datos, entonces le cargo a f la cantidad de filas
		        //Luego verificar que columnas voy a mostar, entonces le cargo a c la cantidad de celdas
		        
		        int filas= arrProv.size(), celdas=0;
		        /*Hacemos un ciclo para inicializar los valores de 10 filas de celdas*/
		        for(int i=0;i<filas;i++){
		            /*La clase Row nos permitirá crear las filas*/
		            Row fila = hoja.createRow(i);
		            System.out.println("i:" +i);
		            //Contamos la cantidad de Celdas, ver como hacerlo para varios.
		           // if (_nombreReporte.equals("Proveedor")){
		            	celdas = 22;
		          //  }
		            
		            /*Cada fila tendrá 5 celdas de datos*/
		            if(i==0){
		            	for(int c=0;c<celdas;c++){
		                /*Creamos la celda a partir de la fila actual*/
		                Cell celda = fila.createCell(c);
		                System.out.println("c:" +c);
		                /*Si la fila es la número 0, estableceremos los encabezados*/
		                celda.setCellValue(ReporteProv[c]);
		                }
		            }else{  
		            	int cAux=0;
		            	Cell celda = fila.createCell(cAux);   
		                    /*Si no es la primera fila establecemos un valor*/
		            		celda.setCellValue(arrProv.get(i).getIdProveedor());
		            		cAux = cAux+1;
		            		celda = fila.createCell(cAux);
		            		celda.setCellValue(arrProv.get(i).getNombreProveedor().toString());
		            		System.out.println(arrProv.get(i).getNombreProveedor().toString());
		            		cAux = cAux+1;
		            		celda = fila.createCell(cAux);
		            		celda.setCellValue(arrProv.get(i).getNombreFantasia().toString());
		            		cAux = cAux+1;
		            		celda = fila.createCell(cAux);
		            		celda.setCellValue(arrProv.get(i).getNombreAuxiliar().toString());
		            		cAux = cAux+1;
		            		celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getTipoProveedor().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getDir1().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getDir2().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getDir3().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getTel1().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getTel2().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getTel3().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getCel1().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getCel2().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getCel3().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getCorreo1().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getCorreo2().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getCorreo3().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getContacto1().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getContacto2().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getContacto3().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getComentarios().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    celda.setCellValue(arrProv.get(i).getHorarioAtentcion().toString());
		                    cAux = cAux+1;
		                    celda = fila.createCell(cAux);
		                    System.out.println(arrProv.get(i).getIdProveedor());
		                
		            }
		        }
        }else{
        	
        }
        
        /*Escribimos en el libro*/
        libro.write(archivo);
        /*Cerramos el flujo de datos*/
        archivo.close();
        /*Y abrimos el archivo con la clase Desktop*/
        Desktop.getDesktop().open(archivoXLS);
	}

	
	
}
