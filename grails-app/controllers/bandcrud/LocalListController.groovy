package bandcrud

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LocalListController {

    LocalListService localListService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond localListService.list(params), model:[localListCount: localListService.count()]
    }

    def show(Long id) {
        respond localListService.get(id)
    }

    def create() {
        respond new LocalList(params)
    }

    def save(LocalList localList) {
        if (localList == null) {
            notFound()
            return
        }

        try {
            localListService.save(localList)
        } catch (ValidationException e) {
            respond localList.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'localList.label', default: 'LocalList'), localList.id])
                redirect localList
            }
            '*' { respond localList, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond localListService.get(id)
    }

    def update(LocalList localList) {
        if (localList == null) {
            notFound()
            return
        }

        try {
            localListService.save(localList)
        } catch (ValidationException e) {
            respond localList.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'localList.label', default: 'LocalList'), localList.id])
                redirect localList
            }
            '*'{ respond localList, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        localListService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'localList.label', default: 'LocalList'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'localList.label', default: 'LocalList'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
