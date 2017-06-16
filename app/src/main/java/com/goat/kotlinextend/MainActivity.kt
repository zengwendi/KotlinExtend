package com.goat.kotlinextend


// 使用来自主代码集的 R.layout.activity_main
import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_layout.view.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var dialog: Dialog
    val textview: TextView by lazy(LazyThreadSafetyMode.NONE) {
        Log.d(TAG, "使用时再加载")
        findViewById(R.id.hello) as TextView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener { textview.text = "你好世界" }
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null)
        dialog = Dialog(this)
        dialog.setContentView(dialogView)
        show_dialog.setOnClickListener {
            dialog.show()
        }
        dialogView.hello.setOnClickListener { dialog.dismiss() }
        dialogView.confirm.setOnClickListener { dialog.dismiss() }
    }
}
