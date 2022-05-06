package cr.ac.menufragment.repository

import cr.ac.menufragment.entity.Empleado

class EmpleadoRepository {
    val empleados:HashMap<String, Empleado> =HashMap()
    companion object {
        @JvmStatic
        val instance by lazy {
            EmpleadoRepository().apply {  }
        }
    }
    constructor(){
        save(Empleado("117830351","Joshua Viera","Recursos Humanos","Secretario",0))
        save(Empleado("117830352","Juan Castro","Suministros","Tesorero",0))
        save(Empleado("117830353","Eduardo Fonseca","Cafetería","Barista",0))
        save(Empleado("117830354","Yadir Castro","Recursos Humanos","Secretario",0))
        save(Empleado("117830355","Andres Sandi","Recursos Humanos","Secretario",0))
        save(Empleado("117830356","Bernardo Jesus","Recursos Humanos","Secretario",0))
        save(Empleado("117830356","Jesus Castro","Recursos Humanos","Secretario",0))
        save(Empleado("117830357","Marietta Castro","Recursos Humanos","Secretaria",0))
        save(Empleado("117830358","Jose Perez","Recursos Humanos","Secretario",0))
        save(Empleado("117830359","Francini Vega","Recursos Humanos","Secretario",0))
        save(Empleado("117830359","Sara Rodriguez","Recursos Humanos","Secretario",0))
        save(Empleado("117830350","Naza Camacho","Recursos Humanos","Secretario",0))
        save(Empleado("117830369","Talisha Montero","Recursos Humanos","Secretario",0))
        save(Empleado("117830379","Bernardo Castro","Recursos Humanos","Secretario",0))
        save(Empleado("117830389","Amalia Sandí","Recursos Humanos","Secretario",0))
    }

    fun save(empleado: Empleado){
        empleados.put(empleado.id, empleado)
    }


    fun delete(id:String){
        empleados.remove(id)
    }

    fun datos():List<Empleado>{
        return empleados.values.toList()
    }

}