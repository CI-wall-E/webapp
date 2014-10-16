package com.viseo.ciwalle

import grails.transaction.Transactional

@Transactional
class JobService {
    def brokerMessagingTemplate

    void jobStatus() {
        brokerMessagingTemplate.convertAndSend "/topic/job", "job updates"
    }
}
