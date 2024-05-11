package org.d3if0059.assesment02.navigation

import org.d3if0059.assesment02.screen.KEY_ID_RESEP

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
    data object FormBaru: Screen("detailscreen")
    data object FormUbah: Screen("detailscreen/{$KEY_ID_RESEP}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}