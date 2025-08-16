package com.loja

import com.loja.models.Cliente
import com.loja.models.Produto
import com.loja.services.CarrinhoDeCompras
import com.loja.services.Loja

fun main() {
    val produto1 = Produto(1, "Notebook", 4500.0, 5)
    val produto2 = Produto(2, "Mouse Gamer", 250.0, 10)

    val cliente = Cliente(1, "Ana", 5000.0)

    val carrinho = CarrinhoDeCompras()
    val loja = Loja(listOf(produto1, produto2))

    loja.listarProdutos()

    carrinho.adicionarProduto(produto1, 1)
    carrinho.adicionarProduto(produto2, 2)

    carrinho.exibirCarrinho()

    loja.finalizarCompra(cliente, carrinho)

    println("\nSaldo restante do cliente: R$ ${cliente.saldo}")
    loja.listarProdutos()
}
