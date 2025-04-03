package com.miguelsantos

import com.google.gson.Gson
import com.miguelsantos.model.Game
import com.miguelsantos.model.Info
import com.miguelsantos.services.ApiConsumer

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val apiConsumer = ApiConsumer()
    val json = apiConsumer.obtainData()

    val gson = Gson()
    val game_info = gson.fromJson(json, Info::class.java)
    val game = Game(game_info.info.title, game_info.info.thumb)

    println(game)
}