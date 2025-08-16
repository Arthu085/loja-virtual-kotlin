package com.loja.models

data class Cliente(
    val id: Int,
    val nome: String,
    var saldo: Double
) {
    fun adicionarSaldo(valor: Double) {
        saldo += valor
        println("Saldo atualizado: R$ $saldo")
    }
}
