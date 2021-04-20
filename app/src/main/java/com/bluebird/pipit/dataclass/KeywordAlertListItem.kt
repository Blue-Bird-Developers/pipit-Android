package com.bluebird.pipit.dataclass

data class KeywordAlertListItem (
    var id: Int,
    var url: String,
    var category: String,
    var title: String,
    var team: String,
    var source: String,
    var uploadTime: String,
    var state: Int
)