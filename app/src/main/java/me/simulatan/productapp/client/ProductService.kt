package me.simulatan.productapp.client

import me.simulatan.productapp.Product
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface ProductService {
	@GET("products")
	suspend fun getProducts(): List<Product>

	@POST("products")
	suspend fun createProduct(@Body product: Product)

	@DELETE("products/{id}")
	suspend fun deleteProduct(@Path("id") id: UUID)
}
