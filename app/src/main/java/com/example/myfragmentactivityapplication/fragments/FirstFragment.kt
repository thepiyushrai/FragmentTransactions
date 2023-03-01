package com.example.myfragmentactivityapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myfragmentactivityapplication.R
import com.example.myfragmentactivityapplication.util.MyFragmentController

class FirstFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_first, container, false)
        val sendButton: Button = requireView().findViewById(R.id.navgateto)
        val bundle = Bundle()
        bundle.putSerializable("bundelid", "it.mdata!")
        sendButton.setOnClickListener {
            MyFragmentController.setFragmentbackStack(
                requireContext(),
                R.id.root_container, bundle, true,
                FourthFragment::class.java
            )
        }
        initView()

        return mView
    }

    private fun initView() {

    }


}