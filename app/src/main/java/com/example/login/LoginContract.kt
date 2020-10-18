package com.sematec.basic.login

import com.example.entities.UserEnity
import com.example.model.Token


interface LoginContract {

    interface View {
        fun onLoginSuccess(data: Token?)
        fun onLoginFailed(msg: String)
        fun onLoading(show: Boolean)
    }

    interface Presenter {
        fun login(username: String, password: String)
    }


}