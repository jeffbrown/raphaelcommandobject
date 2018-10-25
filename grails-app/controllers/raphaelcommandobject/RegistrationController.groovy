package raphaelcommandobject

class RegistrationController {

    def myAction(MyCmd cmd) {
        // Render the data just to verify that the binding happened
        render "Description: ${cmd.description}, Type Name: ${cmd.someType.name}"
    }
}
