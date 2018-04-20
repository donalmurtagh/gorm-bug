package com.example


class Evidence {

    String customer
    static hasMany = [images: String]

    static constraints = {
        images minSize: 1, nullable: false
    }
}
