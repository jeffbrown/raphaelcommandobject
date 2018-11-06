package raphaelcommandobject

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(RegistrationController)
class RegistrationControllerSpec extends Specification {

    void "test binding json to command object"() {
        when: 'json is posted to the controller action'
        request.method = 'POST'
        request.json = '''
                            {"description":"Some Description",
                             "someType": "foos"
                            }
                       '''
        controller.myAction() // note how this silently fails: data binding yields `someType == null`.

        then: 'verify the binding happened'
        response.text == 'Description: Some Description, Type Name: Foo'
    }
}
