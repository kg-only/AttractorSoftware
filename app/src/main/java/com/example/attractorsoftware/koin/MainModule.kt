package com.example.attractorsoftware.koin

import com.example.attractorsoftware.repository.RepositoryJson
import com.example.attractorsoftware.ui.first_screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create(): Module = module {
        factory { MainViewModel(RepositoryJson()) }
    }
}