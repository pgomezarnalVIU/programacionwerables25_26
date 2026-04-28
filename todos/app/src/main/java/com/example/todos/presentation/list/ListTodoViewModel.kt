package com.example.todos.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todos.presentation.model.Todo
import com.example.todos.presentation.UiEvent
import com.example.todos.repository.TodoRepository
import com.example.todos.utils.Result
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ListTodoViewModel(repository: TodoRepository) : ViewModel() {
    private val _todos: MutableState<List<Todo>> = mutableStateOf(emptyList())
    var todos: State<List<Todo>> = _todos


    init {
        viewModelScope.launch {
                val res = repository.getTodos()

            when(res) {
                is Result.Error -> println("Error loading todos")
                is Result.Loading -> println("Loading todos")
                is Result.Success -> {
                    _todos.value = res.data ?: emptyList()
                    println(res.data)
                }
            }
        }
    }

}
