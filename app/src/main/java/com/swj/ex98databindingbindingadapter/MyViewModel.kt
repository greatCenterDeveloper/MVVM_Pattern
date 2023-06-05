package com.swj.ex98databindingbindingadapter

import androidx.databinding.ObservableField
import java.util.Date

class MyViewModel {

    // 1) 이미지의 URL 변수 [ 관찰 가능한 타입 - ObservableXXX ]
    var img: ObservableField<String> =
        ObservableField("https://cdn.pixabay.com/photo/2018/07/16/16/08/island-3542290_640.jpg")

    // 1-1) 버튼 클릭 이벤트 콜백에서 호출하는 메소드
    fun changeImage() {
        img.set("https://cdn.pixabay.com/animation/2022/11/27/16/24/16-24-57-744_512.gif")
    }

    // 2) 리사이클러뷰가 보여줄 대량의 데이터 컬렉션
    val items:ObservableField<MutableList<Item>> =
        ObservableField(
            mutableListOf(
                Item("sam", "Hello"),
                Item("robin", "Nice")
            )
        )

    // 2-1) 버튼 클릭 이벤트 콜백에서 호출하는 메소드
    fun addItem() {
        val list:MutableList<Item> = mutableListOf()
        list.add(Item("NEW", Date().toString()))
        list.addAll(items.get()!!)
        items.set(list)
    }
}