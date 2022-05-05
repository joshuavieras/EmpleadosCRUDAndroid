package cr.ac.menufragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.GravityCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import cr.ac.menufragment.entity.Empleado

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

        view.findViewById<Button>(R.id.editCancelar).setOnClickListener{ OnClickClose() }
        view.findViewById<Button>(R.id.editGuardar).setOnClickListener{ OnClickGuardar() }

        return view
    }

    fun OnClickClose(){
        var fragmento : Fragment = CamaraFragment.newInstance("Camara" )
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.home_content, fragmento)
            ?.commit()
        activity?.setTitle("Camara")
    }
    fun OnClickGuardar(){
        empleado?.departamento= view?.findViewById<TextView>(R.id.departamentoEmpleado).toString()
        empleado?.puesto= view?.findViewById<TextView>(R.id.puestoEmpleado).toString()
        println(view?.findViewById<TextView>(R.id.puestoEmpleado)?.text)
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