package raphaelcommandobject

import grails.validation.Validateable

@Validateable
class MyCmd {
    SomeType someType
    String description
}
