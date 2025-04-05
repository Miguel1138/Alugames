package com.miguelsantos.services

import com.google.gson.Gson
import com.miguelsantos.model.Info
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsumer {

    fun obtainData(gameCode: Int): Info {
        val ADDRESS = "https://www.cheapshark.com/api/1.0/games?id=$gameCode"
        val gson = Gson()

        val client: HttpClient = HttpClient.newHttpClient()
        val request =
            HttpRequest.newBuilder().uri(URI.create(ADDRESS)).build()
        val response = client.send(request, BodyHandlers.ofString())
        val json = response.body()

        return gson.fromJson(json, Info::class.java)
    }

}