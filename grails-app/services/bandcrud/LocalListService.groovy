package bandcrud

import grails.gorm.services.Service

@Service(LocalList)
interface LocalListService {

    LocalList get(Serializable id)

    List<LocalList> list(Map args)

    Long count()

    void delete(Serializable id)

    LocalList save(LocalList localList)

}