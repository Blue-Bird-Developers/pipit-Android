package com.bluebird.pipit.dataclass

data class HomeDataListItem (
    var url: String,
    var category: String,
    var title: String,
    var team: String,
    var source: String,
    var uploadTime: String,
    var bookmark: Boolean
)