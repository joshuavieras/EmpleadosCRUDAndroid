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

/**
 * A simple [Fragment] subclass.
 * Use the [AddEmpleadoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddEmpleadoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_add_empleado, container, false)
        view.findViewById<Button>(R.id.agregarCancelar).setOnClickListener{ OnClickClose() }
        view.findViewById<Button>(R.id.buttonGuardarAgregar).setOnClickListener{ OnClickGuardar() }
        view.findViewById<Button>(R.id.agregarCancelar).setOnClickListener{ OnClickClose() }
        return view
    }
    fun OnClickGuardar(){

        val depa:String= view?.findViewById<TextView>(R.id.departamentoEmpleado2)?.text.toString()
        val puesto:String= view?.findViewById<TextView>(R.id.puestoEmpleado2)?.text.toString()
        val nombre:String= view?.findViewById<TextView>(R.id.nombreEmpleado2)?.text.toString()
        val identificacion:String=view?.findViewById<TextView>(R.id.identificacionEmpleado2)?.text.toString()
        val builder = AlertDialog.Builder(context)
        builder.setMessage("¿Desea agregar el registro?")
            .setCancelable(false)
            .setPositiveButton("Sí") { dialog, id ->

                val empleado  =  Empleado(identificacion,nombre, depa,puesto,0)
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
    fun OnClickClose(){
        var fragmento : Fragment = CamaraFragment.newInstance("Camara" )
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.home_content, fragmento)
            ?.commit()
        activity?.setTitle("Camara")
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddEmpleadoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            AddEmpleadoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}