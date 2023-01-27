/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_1;

import Menu.Menu;

/**
 *
 * @author yamila
 */

/*Para crear los paquetes de esta manera, se deben crear desde el paquete principal, sería nos
paramos en el paquete tienda -> Click derecho -> New Java Package y creamos los paquetes.
También es importante agregar en “Libraries” la librería “MySQL JDBC Driver” para permitir
conectar la aplicación de Java con la base de datos MySQL. Esto se explica en el Instructivo
que ya leíste al final de esta guía.
Paquete persistencia
En este paquete estará la clase DAO encarga de conectarse con la base de datos y de
comunicarse con la base de datos para obtener sus datos. Además, estará las clases de
EntidadDaoExt para cada entidad / tabla de nuestro proyecto.
Es importante tener la conexión creada a la base de datos, como lo explica el Instructivo en la
pestaña de Services en Netbeans.
Paquete entidades:
Dentro de este paquete se deben crear todas las clases necesarias que vamos a usar de la
base de datos. Por ejemplo, una de las clases a crear dentro de este paquete es la clase
“Producto.java” con los siguientes atributos:
• private int codigo;
• private String nombre;
• private double precio;
• private int codigoFabricante;
Agregar a cada clase el/los constructores necesarios y los métodos públicos getters y setters
para poder acceder a los atributos privados de la clase. La llave foránea se pondrá como dato
nada más, no como objeto.
Paquete servicios:
En este paquete se almacenarán aquellas clases que llevarán adelante lógica del negocio. En
general se crea un servicio para administrar cada una de las entidades y algunos servicios
para manejar operaciones muy específicas como las estadísticas.
Realizar un menú en Java a través del cual se permita elegir qué consulta se desea realizar.
Las consultas a realizar sobre la BD son las siguientes:
a) Lista el nombre de todos los productos que hay en la tabla producto.
b) Lista los nombres y los precios de todos los productos de la tabla producto.
c) Listar aquellos productos que su precio esté entre 120 y 202.
d) Buscar y listar todos los Portátiles de la tabla producto.
e) Listar el nombre y el precio del producto más barato.
f) Ingresar un producto a la base de datos.
g) Ingresar un fabricante a la base de datos
h) Editar un producto con datos a elección.*/

public class Tienda_1 {

    public static void main(String[] args) {
        
        Menu menu = new Menu();
        menu.menuPrincipal();
        
    }
    
}
