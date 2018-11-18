package com.example.valdefreaks.checkmeout;

/**
 * Created by valdefreaks on 18/10/18.
 *
 * Clase que contiene los codigos usados para mantener
 * la integridad en las interacciones entre actividades y fragmentos
 */

public class ConstantsClass {

    //Transicion Home -> Detalle
    public static final int DETAIL_CODE = 100;

    //Transicion Detalle -> Actualizacion
    public static final int UPDATE_CODE = 101;

    //Puerto para la conexion. Queda en blanco porque esta configurado por default
    private static final String HOST_PORT = ":80";

    //Direccion ip del emulador
    private static final String IP = "http://127.0.0.1";

    //URLs del web service
    //Esto no me va a servir ya que voy a utilizar mas archivos para las demas tablas de la base de datos
    //Pero lo voy a utilizar para probar el web service con la tabla tutor
    public static final String GET = IP + HOST_PORT + "/checkmeout/obtener_tutores.php";
    public static final String GET_BY_ID = IP + HOST_PORT + "/checkmeout/obtener_tutor_por_id.php";
    public static final String UPDATE = IP + HOST_PORT + "/checkmeout/actualizar_tutor.php";
    public static final String DELETE = IP + HOST_PORT + "/checkmeout/borrar_tutor.php";
    public static final String INSERT = IP + "/checkmeout/insertar_tutor.php";

    //Clave para el valor extra que representa al identificador de un tutor
    public static final String EXTRA_ID = "IDEXTRA";

}
