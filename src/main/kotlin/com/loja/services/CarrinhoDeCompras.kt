package com.loja.services

import com.loja.models.Produto

class CarrinhoDeCompras {
    private val produtos = mutableMapOf<Produto, Int>()

    fun adicionarProduto(produto: Produto, quantidade: Int) {
        if (quantidade <= 0) {
            println("Quantidade inválida.")
            return
        }
        produtos[produto] = produtos.getOrDefault(produto, 0) + quantidade
        println("${produto.nome} adicionado ao carrinho.")
    }

    fun removerProduto(produto: Produto) {
        if (produtos.remove(produto) != null) {
            println("${produto.nome} removido do carrinho.")
        } else {
            println("${produto.nome} não está no carrinho.")
        }
    }

    fun exibirCarrinho() {
        println("\n=== Carrinho de Compras ===")
        if (produtos.isEmpty()) {
            println("Carrinho vazio.")
            return
        }
        produtos.forEach { (produto, quantidade) ->
            println("${produto.nome} x$quantidade - R$ ${produto.preco * quantidade}")
        }
        println("Total: R$ ${calcularTotal()}")
    }

    fun calcularTotal(): Double {
        return produtos.entries.sumOf { it.key.preco * it.value }
    }

    fun getProdutos(): Map<Produto, Int> {
        return produtos.toMap()
    }

    fun limpar() {
        produtos.clear()
    }
}
