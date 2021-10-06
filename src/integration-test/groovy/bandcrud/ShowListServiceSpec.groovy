package bandcrud

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ShowListServiceSpec extends Specification {

    ShowListService showListService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ShowList(...).save(flush: true, failOnError: true)
        //new ShowList(...).save(flush: true, failOnError: true)
        //ShowList showList = new ShowList(...).save(flush: true, failOnError: true)
        //new ShowList(...).save(flush: true, failOnError: true)
        //new ShowList(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //showList.id
    }

    void "test get"() {
        setupData()

        expect:
        showListService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ShowList> showListList = showListService.list(max: 2, offset: 2)

        then:
        showListList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        showListService.count() == 5
    }

    void "test delete"() {
        Long showListId = setupData()

        expect:
        showListService.count() == 5

        when:
        showListService.delete(showListId)
        sessionFactory.currentSession.flush()

        then:
        showListService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ShowList showList = new ShowList()
        showListService.save(showList)

        then:
        showList.id != null
    }
}
