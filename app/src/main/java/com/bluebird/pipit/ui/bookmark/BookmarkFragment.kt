package com.bluebird.pipit.ui.bookmark

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bluebird.pipit.R
import com.bluebird.pipit.ui.WebViewActivity

class BookmarkFragment : Fragment() {

    private lateinit var recyclerAdapter: BookmarkRecyclerAdapter
    private lateinit var viewModel: BookmarkViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(BookmarkViewModel::class.java)
        viewModel.setData()
        viewModel.openActionLiveData.observe(viewLifecycleOwner, Observer {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url", it.url)
            intent.putExtra("title", it.title)
            startActivity(intent)
        })
//        viewModel.checkBoxLiveData.observe(viewLifecycleOwner,  Observer(checkBoxClickListener))
        viewModel.checkBoxLiveData.observe(viewLifecycleOwner,  Observer{ checkBoxClickListener(it) })

        recyclerAdapter = BookmarkRecyclerAdapter(viewModel)
        recyclerAdapter.notifyDataSetChanged()
        recyclerView = view.findViewById(R.id.bookmarkRecyclerView)
        recyclerView.adapter = recyclerAdapter
    }

    private val checkBoxClickListener = { view: View ->
        if (view is CheckBox) {
            if (view.isChecked) {
                makeToast(getString(R.string.saved_bookmark_explanation), view.isChecked)
            }else{
                makeToast(getString(R.string.unsaved_bookmark_explanation), view.isChecked)
            }
        }
    }

    private fun makeToast(toastMessage: String, checked: Boolean) {
        var layout = layoutInflater.inflate(R.layout.toast_layout, null)
        var textView: TextView = layout.findViewById(R.id.toastText)
        textView.text = toastMessage
        var imageView: ImageView = layout.findViewById(R.id.toastImage)
        if (checked) {
            imageView.setImageResource(R.drawable.ic_bookmark_fill_16)
        } else {
            imageView.setImageResource(R.drawable.ic_bookmark_16)
        }
        with(Toast(context)) {
            setGravity(Gravity.BOTTOM, 0, 180)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }
}