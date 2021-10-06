package bandcrud

import grails.gorm.services.Service

@Service(ShowList)
interface ShowListService {

    ShowList get(Serializable id)

    List<ShowList> list(Map args)

    Long count()

    void delete(Serializable id)

    ShowList save(ShowList showList)

}