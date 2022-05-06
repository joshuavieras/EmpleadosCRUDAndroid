package cr.ac.menufragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cr.ac.menufragment.entity.Empleado
import cr.ac.menufragment.repository.EmpleadoRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditEmpleadoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditEmpleadoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var empleado: Empleado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            empleado=it.get(ARG_PARAM1) as Empleado?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View =inflater.inflate(R.layout.fragment_edit_empleado, container, false)

        val nombre=view.findViewById<TextView>(R.id.nombreEmpleado)
        nombre.setText(empleado?.nombre)

        val identificacion=view.findViewById<TextView>(R.id.identificacionEmpleado)
        identificacion.setText(empleado?.id)

        val puesto=view.findViewById<TextView>(R.id.puestoEmpleado)
        puesto.setText(empleado?.puesto)

        val departamento=view.findViewById<TextView>(R.id.departamentoEmpleado)
        departamento.setText(empleado?.departamento)

        view.findViewById<Button>(R.id.editEliminar).setOnClickListener{ OnClickEliminar(identificacion.text.toString()) }
        view.findViewById<Button>(R.id.editGuardar).setOnClickListener{ OnClickGuardar(identificacion.text.toString()) }

        return view
    }

    fun OnClickEliminar(identificacion:String){

        val builder = AlertDialog.Builder(context)
        builder.setMessage("¿Desea modificar el registro?")
            .setCancelable(false)
            .setPositiveButton("Sí") { dialog, id ->

                EmpleadoRepository.instance.delete(identificacion)
                var fragmento : Fragment = CamaraFragment.newInstance("Camara" )
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.home_content, fragmento)
                    ?.commit()
                activity?.setTitle("Camara")

            }
            .setNegativeButton(
                "No"
            ) { dialog, id ->
                // logica del no
            }
        val alert = builder.create()
        alert.show()

        /**/
    }
    fun OnClickGuardar(identificacion:String){
        val depa:String= view?.findViewById<TextView>(R.id.departamentoEmpleado)?.text.toString()
        val puesto:String= view?.findViewById<TextView>(R.id.puestoEmpleado)?.text.toString()
        val nombre:String= view?.findViewById<TextView>(R.id.nombreEmpleado)?.text.toString()
        val builder = AlertDialog.Builder(context)
        builder.setMessage("¿Desea modificar el registro?")
            .setCancelable(false)
            .setPositiveButton("Sí") { dialog, id ->

                val empleado : Empleado  =  Empleado(identificacion,nombre, depa,puesto,0)
                EmpleadoRepository.instance.save(empleado)
                var fragmento : Fragment = CamaraFragment.newInstance("Camara" )
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.home_content, fragmento)
                    ?.commit()
                activity?.setTitle("Camara")

            }
            .setNegativeButton(
                "No"
            ) { dialog, id ->
                // logica del no
            }
        val alert = builder.create()
        alert.show()

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditEmpleadoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(empleado: Empleado) =
            EditEmpleadoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, empleado)
                }
            }
    }
}