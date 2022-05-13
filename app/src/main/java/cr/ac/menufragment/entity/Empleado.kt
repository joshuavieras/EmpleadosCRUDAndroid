package cr.ac.menufragment.entity

import java.io.Serializable

class Empleado(val idEmpleado: Int?, var identificacion:String, var nombre:String, var departamento:String, var puesto:String, var avatar:String) :
    Serializable {
}