package com.viseo.ciwalle

class Jenkins {
    String name
    String url
    String description

    static hasMany = [job: Job]

    static constraints = {
        url url: true
    }
}
