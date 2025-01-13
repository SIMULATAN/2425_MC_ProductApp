package me.simulatan.productapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.simulatan.productapp.client.RetrofitClient

class ProductViewModel : ViewModel() {
	private val _products: MutableList<Product> = mutableStateListOf()
	val products: List<Product> get() = _products

	init {
		viewModelScope.launch {
			try {
				val products = RetrofitClient.products.getProducts()
				_products.addAll(products)
			} catch (e: Exception) {
				e.printStackTrace()
			}
		}
	}

	fun addProduct(product: Product) {
		_products.add(product)
		viewModelScope.launch {
			try {
				RetrofitClient.products.createProduct(product)
			} catch (e: Exception) {
				e.printStackTrace()
			}
		}
	}

	fun deleteProduct(product: Product) {
		_products.remove(product)
		viewModelScope.launch {
			try {
				RetrofitClient.products.deleteProduct(product.id)
			} catch (e: Exception) {
				e.printStackTrace()
			}
		}
	}
}
