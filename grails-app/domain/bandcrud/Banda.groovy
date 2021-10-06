package bandcrud
import grails.rest.Resource

@Resource(uri='/api/banda', formats=['json'])

class Banda {

    String banda
    String genero

    static hasMany = [showList: ShowList]
}

