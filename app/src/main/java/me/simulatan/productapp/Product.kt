package me.simulatan.productapp

import java.util.UUID

data class Product(
	val id: UUID,
	val name: String,
	val unit: String,
	val price: Double,
)
