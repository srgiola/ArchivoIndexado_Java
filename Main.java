import java.io.IOException;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Archivo H = new Archivo();
        Backup Q = new Backup();
        try {
            H.Inicializar("dfLuna");

            //Verificar si ya existe lo que se va a ingresar con  la funcion de busqueda de 3 campos 
            //para insertar
            H.Insertar("dfluna", "03/10/2019", "Carton", 25, "Una porqueria", "Feria", "dfluna");
            H.Insertar("mzamora", "1/01/1999", "PET", 40, "Un asco", "ONG", "dfluna");
            H.Insertar("dfluna", "12/11/2018", "Carton", 90, "Bastante", "Donacion", "amarillo");
            H.Insertar("dfluna", "01/11/2018", "As", 90, "Bastante", "Donacion", "amarillo");

            //Busquedad
            //Devuelve 404 cuando no encontro nada
            List<String> L = H.Buscar("mzamora");
            for (String x : L) {
                System.out.println(x);
            }
            System.out.println();
            List<String> R = H.Buscar("dfluna", "Carton");
            for (String x : R) {
                System.out.println(x);
            }
            System.out.println();
            List<String> K = H.Buscar("dfluna", "Carton", "12/11/2018");
            for (String x : K) {
                System.out.println(x);
            }
            System.out.println();
            List<String> A = H.Buscar("aputo", "Carton", "12/11/2018");
            for (String x : A) {
                System.out.println(x);
            }
            //Esta busqueda es para cuando no se tiene la llave
            System.out.println();
            List<String> B = H.BuscarSecuencial("Carton");
            for (String x : B) {
                System.out.println(x);
            }
            System.out.println();
            List<String> W = H.BuscarSecuencial("on");
            for (String x : W) {
                System.out.println(x);
            }

            //Eliminarcion
            //Devuelve true si encontro la donacion y la elimina
            //si no devuelve false
            boolean F = H.Eliminar("dfluna", "03/10/2019", "Carton");
            System.out.println(F);
            boolean F3 =  H.Eliminar("aputo", "Lata", "11/11/1999");
            System.out.println(F3);

            //Modificacion
            //Devuelve true si se realizo
            //Devuelve false porque el registro no existe
            //Se envia los siguiente numeros como penultimo campo para saber cual se va a modificar
            // 0 = Usuario || 1 = NombreMaterial || 2 = Fecha || 3 = Peso || 4 = Descripcion || 5 = Evento || 6 = UsuarioTransaccion
            // El estatus no lo modifico porque para eso esta eliminar
            //El ultimo campo es lo que se va a cambiar
            //Ejemplo si se va a cambiar el usuario se enviar en NCampo = 0 y en NuevoCampo = NuevoUsuario todo en Strings
            H.Actualizar("mzamora", "PET", "1/01/1999", 0, "mzamora2");
            H.Actualizar("mzamora2", "PET", "1/01/1999", 1, "PET2");
            H.Actualizar("mzamora2", "PET2", "1/01/1999", 2, "01/01/2000");
            H.Actualizar("mzamora2", "PET2", "01/01/2000", 4, "Archivos De Mierda");
            H.Actualizar("mzamora2", "PET2", "01/01/2000", 5, "Ahuevo Funciono");
            H.Actualizar("mzamora2", "PET2", "01/01/2000", 6, "SergioLaMeraVerga");

            //FechaInicio, FechaFinal
            List<String> R22 = H.Reporte();
            for (String linea : R22) {
                System.out.println(linea);
            }

            List<String> R2 = H.Reporte("1/1/1999", "31/12/1999");
            for(String linea : R2)
            {
                System.out.println(linea);
            }
            
            H.Reporte();
            

            Q.MakeBackup("C:\\Users\\Sergio Daniel\\Downloads\\Archivos");

        } catch (IOException ex) {}        
    }
}
