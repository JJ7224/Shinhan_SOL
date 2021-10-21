package com.example.shinhan_sol.data_type

import java.io.Serializable


class SignUp(
    var id: String? = null,
    var pw: String? = null,
    var phonenum: String? = null,
    var brith: String? = null,
    var name: String? = null,
    var nickname: String? = null
) : Serializable
