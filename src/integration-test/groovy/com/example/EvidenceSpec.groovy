package com.example

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class EvidenceSpec extends Specification {

    void "save evidence"() {

        when:
        def evidence = new Evidence(customer: 'foo')

        evidence.addToImages('first')
        evidence.addToImages('second')
        Evidence savedEvidence = evidence.save(failOnError: true)

        then:
        Evidence.count == old(Evidence.count) + 1
        savedEvidence.refresh().images.size() == 2
    }

    void "save evidence without images"() {

        when:
        Evidence unsavedEvidence = new Evidence(customer: 'foo').save()

        then:
        Evidence.count == old(Evidence.count)
        !unsavedEvidence
    }
}
