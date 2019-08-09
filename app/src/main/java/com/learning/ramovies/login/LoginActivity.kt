package com.learning.ramovies.login

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.learning.ramovies.R
import com.learning.ramovies.base.BaseActivity
import com.learning.ramovies.main.MainActivity
import com.learning.ramovies.util.PARAM_HAS_ENTERED
import com.learning.ramovies.util.PARAM_IS_GUEST
import com.learning.ramovies.util.PARAM_UN
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity : BaseActivity() {
    var loginViewModel: LoginViewModel? = null

    var signInBtn: Button? = null

    override fun onResume() {
        super.onResume()

        loginViewModel = getViewModel()

        setupTextChangeListeners()
        setupButtons()
    }

    private fun setupTextChangeListeners() {
        val unET : EditText = findViewById(R.id.usernameET)
        unET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(username: Editable?) {
                loginViewModel!!.validateUsername(username.toString())
                updateSignInBtn()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        val pwET : EditText = findViewById(R.id.passwordET)
        pwET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(password: Editable?) {
                loginViewModel!!.validatePassword(password.toString())
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
        signInBtn?.setOnClickListener {
            sendToMain(false)
        }

        val skpButton : Button = findViewById(R.id.skipBtn)
        skpButton.setOnClickListener {
            sendToMain(true)
        }
    }

    private fun updateSignInBtn() {
        if (signInBtn != null) {
            signInBtn!!.isEnabled = loginViewModel!!.hasValidSubmission()

            val bgColor: Int = if (loginViewModel!!.hasValidSubmission()) R.color.ltBlue else R.color.ltGray
            signInBtn!!.background = this.getDrawable(bgColor)
        }
    }

    private fun sendToMain(isGuest: Boolean) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(PARAM_HAS_ENTERED, true)
        intent.putExtra(PARAM_IS_GUEST, isGuest)
        if(!isGuest) {
            intent.putExtra(PARAM_UN, loginViewModel?.getUsername())
        }
        launchNewActivity(intent)
    }

    /*
     Inherited methods
      */
    override fun layoutRes(): Int {
        return R.layout.activity_login
    }

    override fun currentActivity(): AppCompatActivity {
        return this
    }

    override fun shouldUseNav(): Boolean {
        return false
    }
}