package com.viseo.ciwalle

class Job {
    String name
    String status
    String lastCommiter

    static belongsTo = [jenkins: Jenkins]

    static constraints = {
        lastCommiter blank: true, nullable: true
    }

    String toString() {
        "Job $name"
    }
}
