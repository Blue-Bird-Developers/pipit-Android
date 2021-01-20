package com.bluebird.pipit.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bluebird.pipit.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.RuntimeException

class WelcomeFragment : BottomSheetDialogFragment() {
    private var mListener: onButtonClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.bottom_sheet_welcome, container, false)
        val button = v.findViewById<ImageView>(R.id.nextButton)
        button.setOnClickListener {
            mListener?.onWelcomeFragmentButton()
            dismiss()
        }
        return v
    }

    interface onButtonClickListener{
        fun onWelcomeFragmentButton()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is onButtonClickListener){
            mListener = context
        }else{
            throw RuntimeException("$context must implement onButtonClickListener")
        }
    }
}