package com.bluebird.pipit.ui.setting

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.login.LoginMainActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_withdrawal.*


class WithdrawalFragment : BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setContentView(R.layout.bottom_sheet_withdrawal)
        dialog.setOnShowListener {
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
        val cancelBtn = dialog.cancelBtn
        cancelBtn!!.setOnClickListener {
            dismiss()
        }
        val leavingBtn = dialog.leavingBtn
        leavingBtn.setOnClickListener {
            // TODO: 2021/07/01 탈퇴하기 구현
            directLoginMainActivity()
        }

        return dialog
    }

    private fun directLoginMainActivity(){
        val intent = Intent(activity, LoginMainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}