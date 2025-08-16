package com.loja.services

import com.loja.models.Cliente
import com.loja.models.Produto

class Loja(private val produtosDisponiveis: List<Produto>) {

    fun listarProdutos() {
        println("\n=== Produtos Disponíveis ===")
        produtosDisponiveis.forEach { it.exibirDetalhes() }
    }

    fun finalizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras) {
        val produtosCarrinho = carrinho.getProdutos()
        val total = carrinho.calcularTotal()

        if (total > cliente.saldo) {
            println("Saldo insuficiente. Compra não realizada.")
            return
        }

        for ((produto, quantidade) in produtosCarrinho) {
            if (produto.estoque < quantidade) {
                println("Produto ${produto.nome} sem estoque suficiente. Compra não realizada.")
                return
            }
        }

        cliente.saldo -= total
        for ((produto, quantidade) in produtosCarrinho) {
            produto.estoque -= quantidade
        }

        println("Compra realizada com sucesso! Total: R$ $total")
        carrinho.limpar()
    }
}
