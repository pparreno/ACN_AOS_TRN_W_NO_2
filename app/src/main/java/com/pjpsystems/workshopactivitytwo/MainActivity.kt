package com.pjpsystems.workshopactivitytwo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pjpsystems.workshopactivitytwo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureBottomText()

        binding.loginBtnEmail.setOnClickListener {
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configureBottomText() {
        val ss = SpannableString("By signing up you confirm that you accept our Privacy Policy and Terms of Services")

        val clickableSpanPP: ClickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
                Log.d("DEMO", "Clicked Privacy Policy spanned text")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.WHITE
                ds.isUnderlineText = true
            }
        }
        ss.setSpan(clickableSpanPP, 46, 60, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val clickableSpanToS: ClickableSpan = object : ClickableSpan() {

            override fun onClick(p0: View) {
                Log.d("DEMO", "Clicked ToS spanned text")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.WHITE
                ds.isUnderlineText = true
            }
        }
        ss.setSpan(clickableSpanToS, 65, 82, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.bottomText.text = ss
        binding.bottomText.movementMethod = LinkMovementMethod.getInstance()

    }

}