package me.simulatan.productapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.simulatan.productapp.Product
import me.simulatan.productapp.ProductViewModel
import java.util.UUID

@Composable
fun ProductInputScreen(
	productViewModel: ProductViewModel = viewModel(),
	onNavigateToList: () -> Unit
) {
	var name by remember { mutableStateOf("") }
	var unit by remember { mutableStateOf("") }
	var price by remember { mutableStateOf("") }
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		verticalArrangement = Arrangement.spacedBy(8.dp)
	) {
		TextField(
			value = name,
			onValueChange = { name = it },
			label = { Text("Product Name") },
			modifier = Modifier.fillMaxWidth()
		)
		TextField(
			value = unit,
			onValueChange = { unit = it },
			label = { Text("Unit") },
			modifier = Modifier.fillMaxWidth()
		)
		TextField(
			value = price,
			onValueChange = { price = it },
			label = { Text("Price") },
			modifier = Modifier.fillMaxWidth(),
			singleLine = true
		)
		Button(
			onClick = {
				val parsedPrice = price.toDoubleOrNull()
				if (parsedPrice != null && name.isNotBlank() &&
					unit.isNotBlank()
				) {
					productViewModel.addProduct(
						Product(
							id = UUID.randomUUID(),
							name = name,
							unit = unit,
							price = parsedPrice
						)
					)
					name = ""
					unit = ""
					price = ""
					onNavigateToList()
				}
			},
			modifier = Modifier.fillMaxWidth(),
		) {
			Text("Save Product and View List")
		}

		Button(
			onClick = {
				onNavigateToList()
			},
			modifier = Modifier.fillMaxWidth(),
		) {
			Text("View List")
		}
	}
}
