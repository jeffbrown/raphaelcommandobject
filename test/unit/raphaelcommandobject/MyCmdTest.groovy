package raphaelcommandobject


import org.codehaus.groovy.grails.web.binding.DataBindingUtils
import spock.lang.Specification

class MyCmdTest extends Specification {
    void "coercion from map works"() {
        given:
        def values = [description: "Test", some: "foos"]

        when:
        def cmd = values as MyCmd

        then:
        cmd != null
        cmd.description == "Test"
        cmd.some == SomeType.Foo
    }

    void "map constructor works"() {
        given:
        def values = [description: "Test", some: "foos"]

        when:
        def cmd = new MyCmd(values)

        then:
        cmd != null
        cmd.description == "Test"
        cmd.some == SomeType.Foo
    }

    void "data bind works"() {
        given:
        def values = [description: "Test", some: "foos"]

        when:
        def cmd = new MyCmd()
        DataBindingUtils.bindObjectToInstance(cmd, values)

        then:
        cmd != null
        cmd.description == "Test"
        cmd.some == SomeType.Foo
    }
}
