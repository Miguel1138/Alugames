package com.miguelsantos.model

data class Game(
    val title: String,
    val game_cover: String,
    var description: String? = null
)