package com.miguelsantos.principal

import com.miguelsantos.model.Game
import com.miguelsantos.services.ApiConsumer
import java.util.*

private var game: Game? = null
private val scanner = Scanner(System.`in`)

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Enter the game code you want: ")
    val gameCode = scanner.nextLine().trim().toInt()
    runCatching {
        val gameInfo = ApiConsumer().obtainData(gameCode)
        game = Game(gameInfo.info.title, gameInfo.info.thumb)
    }.onFailure {
        println("Erro: Jogo não encontrado! Insira outro ID")
        main()
    }.onSuccess {
        println("Deseja inserir uma descrição personalizada? [Y/N]")
        val res = scanner.nextLine()
        if (res.equals("y", ignoreCase = true)) {
            println("Insiria sua descrição do jogo:")
            game?.description = scanner.nextLine().toString()
        } else game?.description = game?.title
        println(game)
    }.onSuccess {
        println("Busca finalizada com sucesso.")
    }
}