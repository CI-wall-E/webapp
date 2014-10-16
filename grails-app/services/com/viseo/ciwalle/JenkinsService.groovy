package com.viseo.ciwalle

import grails.transaction.Transactional
import groovy.json.JsonSlurper

@Transactional
class JenkinsService {
    def retrieveJobs(String url) {
        String urlToCall = "$url/api/json"

        def uri = urlToCall.toURL()

        def slurper = new JsonSlurper().parseText(uri.getText())
        def jobs = []
        slurper.jobs.each {
            jobs += new Job(name: it.name, status: it.color, lastCommiter: "blabla")
        }
        jobs
    }
}
