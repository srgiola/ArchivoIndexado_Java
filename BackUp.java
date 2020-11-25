import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

class Backup {
    public void MakeBackup(String RutaSalida) throws IOException
    {
        String Formatofecha = "dd/MM/yyyy";
        Date Fecha = new Date();
        SimpleDateFormat FechaFormateada = new SimpleDateFormat(Formatofecha);

        File original = new File("C:\\MEIA");        
        File copia = new  File(RutaSalida+"\\MEIA_BACKUP" + "--" +  FechaFormateada.format(Fecha));
        copiar_directorios(original, copia);
        JOptionPane.showMessageDialog(null, "BackUp Finalizado ubicación: ");
    }
    public static void copiar_archivos(File original, File copia)
    {
        try {
            InputStream entrada = new FileInputStream(original);
            OutputStream salida = new FileOutputStream(copia);
            byte[] buffer = new byte[1024];
            int datos;
            while ((datos = entrada.read(buffer)) > 0) 
            {
                salida.write(buffer, 0, datos);                
            }
            entrada.close();
            salida.close();
            System.out.println("Copiando" + original.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void copiar_directorios(File original, File copia)
    {
        if (original.isDirectory()) {
            if (!copia.exists()) {
                copia.mkdir();
                System.out.println("Creando directorio"+ copia.toString());
            }
            String [] archivos = original.list();
            for (int x = 0; x < archivos.length; x++) {
                copiar_directorios(new File(original, archivos[x]), new File(copia, archivos[x]));
            }
        } else
        {
            copiar_archivos(original, copia);
        }
    }
    
}