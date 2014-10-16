package com.viseo.ciwalle

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(JenkinsService)
class JenkinsServiceSpec extends Specification {
    def jenkinsService

    def testRetrieveJobs() {
        given:
        def url='http://172.30.251.240:8090'

        when:
        def jobs = jenkinsService.retrieveJobs(url)

        then:
        jobs.each {
            it.name in ['test%20javascript', 'test']
        }
    }
}
