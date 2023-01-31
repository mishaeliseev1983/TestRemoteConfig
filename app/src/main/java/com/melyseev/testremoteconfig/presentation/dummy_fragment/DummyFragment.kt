package com.melyseev.testremoteconfig.presentation.dummy_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.melyseev.testremoteconfig.databinding.FragmentDummyBinding

class DummyFragment : Fragment() {

    private var _binding: FragmentDummyBinding? = null
    private val binding: FragmentDummyBinding
        get() = _binding ?: throw RuntimeException("Object FragmentDummyBinding is null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDummyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val sportsEventAdapter = SportsEventAdapter()
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = sportsEventAdapter

        sportsEventAdapter.submitList(
            listOf(
                SportsEventUI(1),
                SportsEventUI(2),
                SportsEventUI(3),
            )
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = DummyFragment()
    }
}