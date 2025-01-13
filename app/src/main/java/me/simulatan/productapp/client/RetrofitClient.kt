package me.simulatan.productapp.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
	val retrofit: Retrofit = Retrofit.Builder()
		.baseUrl("http://10.0.2.2:3000/")
		.addConverterFactory(GsonConverterFactory.create())
		.build()

	val products: ProductService = retrofit.create(ProductService::class.java)
}
