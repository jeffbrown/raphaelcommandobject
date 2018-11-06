package raphaelcommandobject

import grails.validation.Validateable
import org.grails.databinding.BindUsing

@Validateable
class MyCmd {
    @BindUsing({ newCmd, jsonMap ->
        SomeType.fromJson(jsonMap['some'])
    })
    SomeType some

    String description

    void setSome(Object jsonValue) {
        this.some = SomeType.fromJson(jsonValue)
    }
}
