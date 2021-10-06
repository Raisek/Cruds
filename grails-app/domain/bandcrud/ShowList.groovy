package bandcrud
import grails.rest.Resource

@Resource(uri='/api/showList', formats=['json'])
class ShowList {
    String local
    Date data


    static hasMany = [ banda: Banda ]
    static belongsTo = [ banda: Banda]

    static constraints = {
    }
}
