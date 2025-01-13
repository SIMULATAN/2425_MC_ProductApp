package me.simulatan.productapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.simulatan.productapp.Product
import me.simulatan.productapp.ProductViewModel

@Composable
fun ProductListScreen(
	productViewModel: ProductViewModel = viewModel(),
	onNavigateBack: () -> Unit
) {
	val products = productViewModel.products
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		verticalArrangement = Arrangement.spacedBy(8.dp)
	) {
		Text("Product List", style =
		MaterialTheme.typography.headlineSmall)
		products.forEach { product ->
			ProductRow(product) {
				productViewModel.deleteProduct(product)
			}
		}
		Spacer(modifier = Modifier.height(16.dp))
		Button(
			onClick = { onNavigateBack() },
			modifier = Modifier.fillMaxWidth()
		) {
			Text("Back to Input")
		}
	}
}

@Composable
fun ProductRow(product: Product, deleteProduct: () -> Unit) = Row(
	horizontalArrangement = Arrangement.SpaceBetween,
	verticalAlignment = Alignment.CenterVertically,
	modifier = Modifier.fillMaxWidth()
) {
	Text("${product.name}, in ${product.unit}, for ${product.price}")
	IconButton(onClick = deleteProduct) {
		Icon(Icons.Filled.Delete, contentDescription = "Delete this product")
	}
}
