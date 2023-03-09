package com.geektech.android3dz1mvvm.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.android3dz1mvvm.model.ModelBook

class SecondViewModel: ViewModel() {

    private val bookModelList:ArrayList<ModelBook> = ArrayList()
    private var list= MutableLiveData<String>()
    var listString: LiveData<String> = list

    fun getListOfCatHTP(): ArrayList<ModelBook> {

        bookModelList.clear()
        bookModelList.add(
            ModelBook(
                "https://static.detmir.st/media_out/494/929/4929494/450/0.jpg?1662437224508",
                " lost World"
            )
        )
        bookModelList.add(
            ModelBook(
                "https://www.mann-ivanov-ferber.ru/assets/images/covers/37/21737/1.00x-thumb.png",
                "Дети капитана Гранта"
            )
        )
        bookModelList.add(
            ModelBook(
                "https://www.storytel.com/images/640x640/0001156746.jpg",
                "самурай без меча"
            )
        )
        bookModelList.add(
            ModelBook(
                "https://img4.labirint.ru/rc/fba9dddb9b67ef95831c7174b4c2eb8c/363x561q80/books16/150746/cover.jpg?1280394613",
                "Гарри Поттер и дары смерти"
            )
        )
        bookModelList.add(
            ModelBook(
                "https://img4.labirint.ru/rc/c5593938783bcf5a3a3617ea89dbf73b/363x561q80/books46/459698/cover.jpg?1566211871",
                "Макс Фрай: чужак"
            )
        )
        bookModelList.add(
            ModelBook(
                "https://cv9.litres.ru/pub/c/cover_200/48428994.jpg",
                "Ведьмин котел"
            )
        )
        return bookModelList
    }

}