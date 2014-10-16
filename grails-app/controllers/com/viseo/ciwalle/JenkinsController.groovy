package com.viseo.ciwalle
import grails.transaction.Transactional
import org.apache.commons.logging.LogFactory

@Transactional(readOnly = true)
class JenkinsController {
    private static final log = LogFactory.getLog(this)
    def scaffold = true
    def jenkinsService

    def importJobs = {
        Jenkins jenkins = Jenkins.findById(params.id)
        def jobs = jenkinsService.retrieveJobs(jenkins.url)
        jobs.each {
            it.jenkins = jenkins
            it.save flush: true
        }
        redirect(action: show, params: params)
    }
}
