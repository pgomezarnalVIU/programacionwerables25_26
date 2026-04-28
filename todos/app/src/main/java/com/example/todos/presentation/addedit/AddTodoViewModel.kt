package com.example.todos.presentation.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todos.presentation.UiEvent
import com.example.todos.presentation.model.Todo
import com.example.todos.repository.TodoRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import com.example.todos.utils.Result

class AddTodoViewModel(val repository: TodoRepository, id: Int = -1) : ViewModel() {

    private val _todo = mutableStateOf(Todo(-1, -1, "", false))
    val todo: State<Todo> = _todo


    init {
        viewModelScope.launch {
            if (id != -1) {
                val res = repository.getTodo(id)
                when (res) {
                    is Result.Error -> println("Error loading todo")
                    is Result.Loading -> println("Loading todo")
                    is Result.Success -> {
                        _todo.value = res.data ?: Todo()
                        println(res.data)
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditTodoEvent) {
        when (event) {
            is AddEditTodoEvent.EnteredTitle -> {
                _todo.value = _todo.value.copy(title = event.title)
            }

            AddEditTodoEvent.SaveTodo -> {
                addOrUpdateTodo(todo.value)
            }

        }

    }

    private fun addOrUpdateTodo(todo: Todo) {
        viewModelScope.launch {
            var res:Result<Todo>
            if (todo.id == -1) {
                res = repository.createTodo(todo)
            } else {
                res = repository.updateTodo(todo)
            }
            when(res) {
                is Result.Error -> println("Error loading todos")
                is Result.Loading -> println("Loading todos")
                is Result.Success -> {
                    println(res.data)
                }
            }
        }
    }


}

