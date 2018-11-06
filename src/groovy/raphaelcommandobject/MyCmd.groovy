package raphaelcommandobject

import grails.validation.Validateable

@Validateable
class MyCmd {
    SomeType someType
    String description

    void setSomeType(Object jsonValue) {
        this.someType = SomeType.fromJson(jsonValue)
    }
}
