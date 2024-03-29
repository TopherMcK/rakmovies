package com.learning.ramovies.login

import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.learning.ramovies.R
import com.learning.ramovies.base.activity.BaseActivity
import com.learning.ramovies.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.apache.commons.lang3.StringUtils
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : BaseActivity() {
    private lateinit var loginViewModel: LoginViewModel

    private lateinit var signInBtn: MaterialButton
    private lateinit var unET : EditText
    private lateinit var pwET : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setToBlockbusterFont(textView = usernameLabel)
        setToBlockbusterFont(textView = passwordLabel)
        setToBlockbusterFont(textView = justAnOr)
    }

    override fun onResume() {
        super.onResume()

        loginViewModel = getViewModel()

        setupTextChangeListeners()
        setupButtons()
        restoreInput()
    }

    private fun setupTextChangeListeners() {
        unET = findViewById(R.id.usernameET)
        unET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(username: Editable?) {
                loginViewModel.validateUsername(username.toString())
                updateSignInBtn()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        pwET = findViewById(R.id.passwordET)
        pwET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(password: Editable?) {
                loginViewModel.validatePassword(password.toString())
                updateSignInBtn()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(po: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    private fun setupButtons() {
        signInBtn = findViewById(R.id.signInBtn)
        signInBtn.setOnClickListener {
            sendToMain()
        }

        val skpButton : Button = findViewById(R.id.skipBtn)
        skpButton.setOnClickListener {
            sendToMain()
        }

        setToBlockbusterFont(signInBtn)
        setToBlockbusterFont(skpButton)
        updateSignInBtn()
    }

    private fun updateSignInBtn() {
            signInBtn.isEnabled = loginViewModel.hasValidSubmission()
    }

    private fun sendToMain() {
        launchNewActivity(MainActivity.createIntent(loginViewModel.getUsername(), this))
    }

    private fun restoreInput() {
        if(StringUtils.isNotEmpty(loginViewModel.getUsername())) {
            unET.text = SpannableStringBuilder(loginViewModel.getUsername())
        }
        if(StringUtils.isNotEmpty(loginViewModel.getPassword())) {
            pwET.text = SpannableStringBuilder(loginViewModel.getPassword())
        }
    }

    override fun layoutRes(): Int {
        return R.layout.activity_login
    }

    override fun currentActivity(): AppCompatActivity {
        return this
    }
}