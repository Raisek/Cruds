package bandcrud

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LocalListServiceSpec extends Specification {

    LocalListService localListService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new LocalList(...).save(flush: true, failOnError: true)
        //new LocalList(...).save(flush: true, failOnError: true)
        //LocalList localList = new LocalList(...).save(flush: true, failOnError: true)
        //new LocalList(...).save(flush: true, failOnError: true)
        //new LocalList(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //localList.id
    }

    void "test get"() {
        setupData()

        expect:
        localListService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<LocalList> localListList = localListService.list(max: 2, offset: 2)

        then:
        localListList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        localListService.count() == 5
    }

    void "test delete"() {
        Long localListId = setupData()

        expect:
        localListService.count() == 5

        when:
        localListService.delete(localListId)
        sessionFactory.currentSession.flush()

        then:
        localListService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        LocalList localList = new LocalList()
        localListService.save(localList)

        then:
        localList.id != null
    }
}
