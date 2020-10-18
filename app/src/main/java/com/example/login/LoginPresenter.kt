package com.sematec.basic.login

import com.example.login.LoginRequestEntity
import com.sematec.basic.api.WebService
import com.sematec.basic.utils.AppUtils
import org.jetbrains.annotations.Contract

class LoginPresenter(val view: LoginContract.View) : LoginContract.Presenter {


    override fun login(username: String, password: String) {
        Thread {
            val apiCall = WebService.api.login(
                LoginRequestEntity(
                  client_id = "s5UaaqL4rdYooJDBkZxX3Q6O1uSiugD3",
                    client_secret = "gpwemA8xu1X6keaW8Gz9yGFAsBep_Kyb_p7Xd4TOCSaMXTrwf7x0Ymp4X3whwtWC",
                    audience = "https://dev-o3tn3b4f.eu.auth0.com/api/v2/",
                    grant_type = "client_credentials"
                )
            ).execute()

            when {
                apiCall.isSuccessful -> {
                    AppUtils.setData("token", apiCall.body()?.access_token)
                    view.onLoginSuccess(apiCall.body())
                }
                apiCall.code() == 401 -> {
                    view.onLoginFailed("User/Pass wrong")
                }
                else -> {
                    view.onLoginFailed("error in server")
                }
            }
        }.start()

    }

}