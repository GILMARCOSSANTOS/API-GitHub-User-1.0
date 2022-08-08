package com.example.githubusers20_kharismarizqi.ui.data.model

data class User(

    /* 01 = CF: Atributos da classe dentista */
    val login: String,
    val id: Int,
    val avatar: String
) {
    /* 01 = CF: Método 'To String = Code + Generate + ToString': */
    override fun toString(): String {
        return "User(login='$login', id=$id, avatar='$avatar')"
    }
}
