package com.example.jhserviceapp.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jhserviceapp.domain.entity.article.ArticleDTO
import com.example.jhserviceapp.domain.usecase.AddArticleUseCase
import com.example.jhserviceapp.domain.usecase.GetDefaultArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val addArticleUseCase: AddArticleUseCase,
    private val getDefaultArticlesUseCase: GetDefaultArticlesUseCase
) : ViewModel() {
    private var _defaultList = MutableStateFlow<List<ArticleDTO>>(emptyList())
    val defaultList get() = _defaultList.asStateFlow()

    init {
        updateDefaultList()
    }


    fun addDefaultArticle(number: String, name: String) {
        viewModelScope.launch {
            val numberLong = number.toLong()
            addArticleUseCase.addArticles(ArticleDTO(numberLong, name, true))
            updateDefaultList()
        }
    }

    private fun updateDefaultList() {
        viewModelScope.launch {
            _defaultList.value = getDefaultArticlesUseCase.getDefaultArticles()
        }
    }

    fun removeDefaultArticle(article: ArticleDTO) {
        viewModelScope.launch {
            article.isDefault = false
            addArticleUseCase.addArticles(article)
            updateDefaultList()
        }
    }
}