package com.viseo.ciwalle

import grails.converters.JSON
import grails.transaction.Transactional
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo

@Transactional(readOnly = true)
class JobController {
    def scaffold=true

    def websocket() {

    }

    @MessageMapping("/job")
    @SendTo("/topic/job")
    private def job(def id) {
        JSON.excludeForWeb(Job, ['class'])

        def json

        JSON.use('excludeForWeb') {
            json = new JSON(new Job(name: "TOTO", status: "blue", lastCommiter: "personne"))
        }

        json.toString()
    }
}
