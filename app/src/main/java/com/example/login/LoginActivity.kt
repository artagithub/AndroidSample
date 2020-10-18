package com.sematec.basic.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.entities.UserEnity
import com.example.model.Token
import com.example.service.R
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(this)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            presenter.login(
                username = username.text.toString(), password = password.text.toString()
            )
        }


    }

    override fun onLoginSuccess(data: Token?) {
        runOnUiThread {
            data?.access_token?.toast()
        }

//        startActivity(
//            Intent(this, ImageSearchEngineActivity::class.java)
//        )
    }

    override fun onLoginFailed(msg: String) {
        runOnUiThread {
            msg.toast()
        }
    }

    override fun onLoading(show: Boolean) {

    }

}