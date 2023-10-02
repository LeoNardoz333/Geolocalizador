package com.example.geolocalizadorpro.ui.administrador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.geolocalizadorpro.R
import com.example.geolocalizadorpro.databinding.FragmentAdministradorBinding
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import android.widget.EditText
import android.widget.Toast
import android.widget.Button

class AdministradorFragment : Fragment() {
    private var _binding: FragmentAdministradorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(AdministradorViewModel::class.java)

        _binding = FragmentAdministradorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etusuario:EditText=binding.etUsuarioAdmin
        val etpass:EditText=binding.etPasswordAdmin
        // Ahora puedes obtener una referencia al botón en onViewCreated
        val ingresar: Button = binding.btnIngresarAdmin

        ingresar.setOnClickListener {
            // Aquí puedes manejar el clic en el botón
            val usuario:String=etusuario.text.toString()
            val pass:String=etpass.text.toString()
            val url="http://192.168.0.14/geolocalizador/usuarios.php?usuario=$usuario&pass=$pass"
            val requestQueue: RequestQueue = Volley.newRequestQueue(requireContext())

            val stringRequest=StringRequest(
                Request.Method.GET,url,Response.Listener { response ->
                    val elementos=response.split("も")
                    if(elementos.size>=5) {
                        val id = elementos[0]
                        val nombre = elementos[1]
                        val user = elementos[2]
                        val pass = elementos[3]
                        val permisos = elementos[4]
                        Toast.makeText(requireContext(),"Acceso correcto.",Toast.LENGTH_SHORT).show()
                    }else
                        Toast.makeText(requireContext(),"Usuario u contraseña incorrectos.",Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { error ->
                    // Manejar errores de la solicitud
                    Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_SHORT).show()
                }
            )
            requestQueue.add(stringRequest)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}