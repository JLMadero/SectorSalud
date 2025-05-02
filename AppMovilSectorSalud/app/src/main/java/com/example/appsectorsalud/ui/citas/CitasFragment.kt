package com.example.appsectorsalud.ui.citas

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appsectorsalud.R
import com.example.appsectorsalud.databinding.FragmentCitasBinding
import java.util.Calendar

class CitasFragment : Fragment() {

    private var _binding: FragmentCitasBinding? = null
    private lateinit var editTextFecha: EditText


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val citasViewModel =
            ViewModelProvider(this).get(CitasViewModel::class.java)

        _binding = FragmentCitasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        editTextFecha = binding.editTextFecha

        editTextFecha.setOnClickListener {
            showDatePickerDialog()
        }

        return root
    }


    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                // Al seleccionar fecha
                val fechaSeleccionada = "${"%02d".format(selectedDayOfMonth)}/" +
                        "${"%02d".format(selectedMonth + 1)}/$selectedYear"
                editTextFecha.setText(fechaSeleccionada)
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}