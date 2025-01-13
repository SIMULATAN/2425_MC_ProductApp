package me.simulatan.productapp.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.simulatan.productapp.ProductViewModel

@Composable
fun MainScreen(productViewModel: ProductViewModel = viewModel()) {
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = "input_screen"
	) {
		composable("input_screen") {
			ProductInputScreen(
				productViewModel = productViewModel,
				onNavigateToList = {
					navController.navigate("list_screen")
				}
			)
		}
		composable("list_screen") {
			ProductListScreen(
				productViewModel = productViewModel,
				onNavigateBack = { navController.popBackStack() }
			)
		}
	}
}
