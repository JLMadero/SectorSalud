package com.example.appsectorsalud.ui.expedientes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appsectorsalud.databinding.FragmentExpedientesBinding

class ExpedientesFragment : Fragment() {

    private var _binding: FragmentExpedientesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val expedientesViewModel =
            ViewModelProvider(this).get(ExpedientesViewModel::class.java)

        _binding = FragmentExpedientesBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}