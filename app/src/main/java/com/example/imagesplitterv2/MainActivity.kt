package com.example.imagesplitterv2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.graphics.get
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    companion object {
        private const val IMAGE_PICK_CODE = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1.addTextChangedListener(textWatcher)
        editText1.addTextChangedListener(textWatcher)
        editText2.addTextChangedListener(textWatcher)

        btnPickImg.setOnClickListener() {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, IMAGE_PICK_CODE)
            textView1.text = "Filled"
        }

        btnSplit.setOnClickListener() {
            val bitmap = (myImageView.drawable as BitmapDrawable).bitmap
            val horizontal = editText1.text.toString()
            val vertical = editText2.text.toString()
            val intentSwitch = Intent(this, SplitImageActivity::class.java)

            intentSwitch.putExtra("Bitmap", bitmap)
            intentSwitch.putExtra("Vertical", vertical)
            intentSwitch.putExtra("Horizontal", horizontal)
            startActivity(intentSwitch)
        }

        reset.setOnClickListener() {
            myImageView.setImageBitmap(null)
            textView1.text = ""
            textView3.text = ""
            editText1.text = null
            editText2.text = null
        }

        close.setOnClickListener() {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            exitProcess(1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            myImageView.setImageURI(data?.data)
            var test = (myImageView.drawable as BitmapDrawable).bitmap
            textView3.text = String.format("Resolution: %s x %s", test.width.toString(), test.height.toString())
        }
    }

    private var textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            when {
                editText1.text.toString() == 0.toString() -> {
                    editText1.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText1.text.toString() == 1.toString() -> {
                    editText1.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText1.text.toString() == 6.toString() -> {
                    editText1.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText1.text.toString() == 7.toString() -> {
                    editText1.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText1.text.toString() == 8.toString() -> {
                    editText1.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText1.text.toString() == 9.toString() -> {
                    editText1.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
            }

            when {
                editText2.text.toString() == 0.toString() -> {
                    editText2.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText2.text.toString() == 1.toString() -> {
                    editText2.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText2.text.toString() == 6.toString() -> {
                    editText2.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText2.text.toString() == 7.toString() -> {
                    editText2.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText2.text.toString() == 8.toString() -> {
                    editText2.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
                editText2.text.toString() == 9.toString() -> {
                    editText2.text = null
                    Toast.makeText(this@MainActivity, "Input Number 2 - 5", Toast.LENGTH_SHORT).show()
                }
            }

            when (val stringForSplit = "") {
                editText1.text.toString() -> {
                    btnSplit.isEnabled = false
                }
                editText2.text.toString() -> {
                    btnSplit.isEnabled = false
                }
                textView1.text.toString() -> {
                    btnSplit.isEnabled = false
                }
                else -> btnSplit.isEnabled =
                    !(editText1.text.toString() == stringForSplit && editText2.text.toString() == stringForSplit && textView1.text.toString() == stringForSplit)
            }
        }
        override fun afterTextChanged(s: Editable) {}
    }
}
