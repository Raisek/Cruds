package bandcrud

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ShowListController {

    ShowListService showListService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond showListService.list(params), model:[showListCount: showListService.count()]
    }

    def show(Long id) {
        respond showListService.get(id)
    }

    def create() {
        respond new ShowList(params)
    }

    def save(ShowList showList) {
        if (showList == null) {
            notFound()
            return
        }

        try {
            showListService.save(showList)
        } catch (ValidationException e) {
            respond showList.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'showList.label', default: 'ShowList'), showList.id])
                redirect showList
            }
            '*' { respond showList, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond showListService.get(id)
    }

    def update(ShowList showList) {
        if (showList == null) {
            notFound()
            return
        }

        try {
            showListService.save(showList)
        } catch (ValidationException e) {
            respond showList.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'showList.label', default: 'ShowList'), showList.id])
                redirect showList
            }
            '*'{ respond showList, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        showListService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'showList.label', default: 'ShowList'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'showList.label', default: 'ShowList'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
