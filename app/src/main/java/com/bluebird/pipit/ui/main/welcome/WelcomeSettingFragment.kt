package com.bluebird.pipit.ui.main.welcome

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bluebird.pipit.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.RuntimeException

class WelcomeSettingFragment : BottomSheetDialogFragment() {
    private var mListener: OnButtonClickListener? = null

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        val v = inflater.inflate(R.layout.bottom_sheet_setting_notice, container, false)
//        val button = v.findViewById<TextView>(R.id.settingBtn)
//        button.setOnClickListener {
//            dismiss()
//        }
//        return v
//    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setContentView(R.layout.bottom_sheet_setting_notice)
        dialog.setOnShowListener{
            val bottomSheet = (it as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            val behavior = BottomSheetBehavior.from(bottomSheet!!)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }
                // BottomSheet 드래그해서 숨겨지는거 막기위해
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_DRAGGING)
                        behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            })
        }
        val button = dialog.findViewById<TextView>(R.id.settingBtn)
        button!!.setOnClickListener {
            dismiss()
        }
        return dialog
    }

    interface OnButtonClickListener{
        fun onWelcomeSettingFragmentButton()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnButtonClickListener){
            mListener = context
        }else{
            throw RuntimeException("$context must implement onButtonClickListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }
}