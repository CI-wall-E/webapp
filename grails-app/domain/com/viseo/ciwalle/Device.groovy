package com.viseo.ciwalle

class Device {
    String name
    String type

    static constraints = {
        type inList: ['iOS', 'watch', 'android', 'arduino']
    }
}
