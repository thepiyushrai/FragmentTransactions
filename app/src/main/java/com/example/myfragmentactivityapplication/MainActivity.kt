package com.example.myfragmentactivityapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfragmentactivityapplication.fragments.FirstFragment
import com.example.myfragmentactivityapplication.fragments.SecondFragment
import com.example.myfragmentactivityapplication.fragments.ThirdFragment
import com.example.myfragmentactivityapplication.util.MyFragmentController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
callFragment1()
callFragment2()
callFragment3()
    }

    private fun callFragment3() {
        val bundle = Bundle()
        bundle.putSerializable("bundelid", "it.mdata!")
        MyFragmentController.setFragmentOn(
            this,
            R.id.root_container,
            bundle,
            false,
            ThirdFragment::class.java
        )
        val manager = (this as AppCompatActivity).supportFragmentManager
        System.out.println("validationBack" + manager.backStackEntryCount)
        MyFragmentController.clearBackStack(this)
    }

    private fun callFragment1() {
        val bundle = Bundle()
        bundle.putSerializable("bundelid", "it.mdata!")
        MyFragmentController.setFragment(
            this,
            R.id.root_container,bundle, true, FirstFragment::class.java
        )
    }
    private fun callFragment2() {
        val bundle = Bundle()
        bundle.putSerializable("bundelid", "it.mdata!")
        MyFragmentController.setFragmentWithoutStack(
            this,
            R.id.root_container,
            true,
            SecondFragment::class.java
        )
    }
}