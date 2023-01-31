package com.melyseev.testremoteconfig.presentation.message_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.melyseev.testremoteconfig.R

private const val MESSAGE = "message"
class MessageFragment : Fragment() {
    private var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            message = it.getString(MESSAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.message).text = message
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            MessageFragment().apply {
                arguments = Bundle().apply {
                    putString(MESSAGE, param1)
                }
            }
    }
}