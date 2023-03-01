package com.example.myfragmentactivityapplication.util

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


object MyFragmentController {
/*
//If you don't want later pop more than one back stack, but still want to pop one at a time.
            // Do this even if you won't explicitly call popToBackStack() but instead will let the back press
            // default implementation handle the back stack.
 */
    fun setFragment(
        context: Context,
        replaceViewId: Int,
        bundle: Bundle?,
        backPressed: Boolean,
        fragmentClass: Class<out Fragment>
    ) {
        try {
            val fragment = fragmentClass.newInstance()
            if (bundle != null) fragment.arguments = bundle
            val transaction =
                (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(replaceViewId, fragment)

            if (backPressed) transaction.addToBackStack(null)
            transaction.commit()
        } catch (ex: Exception) {

        }
    }

    /*
    If you don't want the back press or call popBackStack() explicitly.
    It will ensure that no part of the code is using. addToBackStack().
     */
    fun setFragmentWithoutStack(
        context: Context,
        replaceViewId: Int,
//        bundle: Bundle?,
        backPressed: Boolean,
        fragmentClass: Class<out Fragment>
    ) {
        try {
            val fragment = fragmentClass.newInstance()
//            if (bundle != null) fragment.arguments = bundle
            val transaction =
                (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(replaceViewId, fragment)
            //transaction can never be reversed.

            if (backPressed) transaction.disallowAddToBackStack()
            transaction.commit()
            val manager: FragmentManager = context.supportFragmentManager
            manager.popBackStack()
        } catch (ex: Exception) {
        }
    }

// if you want later popToBackStack(String name, int flags) to pop more than one back stack.
    fun setFragmentbackStack(
        context: Context,
        replaceViewId: Int,
        bundle: Bundle?,
        backPressed: Boolean,
        fragmentClass: Class<out Fragment>
    ) {
        try {
            val fragment = fragmentClass.newInstance()
            if (bundle != null) fragment.arguments = bundle
            val transaction =
                (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(replaceViewId, fragment)

            if (backPressed) transaction.addToBackStack("Tag")
            transaction.commit()
        } catch (ex: Exception) {

        }
    }


    fun setFragmentOn(
        context: Context,
        replaceViewId: Int,
        bundle: Bundle?,
        backPressed: Boolean,
        fragmentClass: Class<out Fragment>
    ) {
        try {
            val fragment = fragmentClass.newInstance()
            if (bundle != null) fragment.arguments = bundle
            val manager = (context as AppCompatActivity).supportFragmentManager
            val transaction =
                context.supportFragmentManager.beginTransaction()
            transaction.add(replaceViewId, fragment)
            if (backPressed) transaction.addToBackStack(null)
            transaction.commit()
        } catch (ex: Exception) {
        }
    }

    fun clearBackStack(context: Context) {
        val manager: FragmentManager = (context as AppCompatActivity).supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first: FragmentManager.BackStackEntry = manager.getBackStackEntryAt(1)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }



}