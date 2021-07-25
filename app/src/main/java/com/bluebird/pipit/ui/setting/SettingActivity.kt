package com.bluebird.pipit.ui.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.setting.changepw.CheckPasswordActivity
import com.bluebird.pipit.ui.welcome.WelcomeSettingFragment
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    private var dataList: MutableList<String> = mutableListOf()

    private lateinit var recyclerAdapter: SettingRecyclerAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        makeDataList()
        setListeners()
        setRecyclerView()
    }

    private fun setListeners(){
        backBtn.setOnClickListener { finish() }
    }

    private fun setRecyclerView(){
        recyclerAdapter = SettingRecyclerAdapter(dataList, recyclerViewItemListener)
        recyclerAdapter.notifyDataSetChanged()
        recyclerView = findViewById(R.id.settingRecyclerView)
        recyclerView.adapter = recyclerAdapter
    }

    private fun makeDataList(){
        dataList.add(getString(R.string.change_password))
        dataList.add(getString(R.string.ask))
        dataList.add(getString(R.string.processing_policy))
        dataList.add(getString(R.string.open_licence))
        dataList.add(getString(R.string.withdrawal))
    }

    private fun openWithdrawalBottomSheet(){
        val bottomSheet = WithdrawalFragment()
        bottomSheet.isCancelable = false
        bottomSheet.show(supportFragmentManager, bottomSheet.tag)
    }

    private val recyclerViewItemListener = { pos: Int ->
        when(pos){
            0 -> {
                val intent = Intent(this, CheckPasswordActivity::class.java)
                startActivity(intent)
            }
            4 -> openWithdrawalBottomSheet()
        }
    }

}