package raphaelcommandobject

enum SomeType {
    Foo(17, "foos"),
    Bar(19, "barista")

    int id
    String jsonName

    SomeType(id, jsonName) {
        this.id = id
        this.jsonName = jsonName
    }

    static SomeType byJsonName(String name) {
        for (SomeType st : values() ) {
            if (st.jsonName == name) {
                return st
            }
        }

        return null
    }

    static SomeType byId(int id) {
        for (SomeType st : values() ) {
            if (st.id == id) {
                return st
            }
        }

        return null
    }

    /**
     * Handles all kinds of parameter types -- who knows what we find in the JSON!
     */
    static SomeType fromJson(Object jsonValue) {
        if (jsonValue == null || jsonValue instanceof SomeType) {
            return jsonValue
        }  else if (jsonValue instanceof String) {
            SomeType st = byJsonName(jsonValue as String)
            if ( null != st ) {
                return st
            } else {
                throw new IllegalArgumentException("No case with this name: $jsonValue")
            }
        } else if ( jsonValue instanceof Number ) {
            if ( (jsonValue as Number) > Integer.MAX_VALUE ) {
                throw new IllegalArgumentException("No case with this ID: $jsonValue")
            }

            SomeType st = byId((jsonValue as Number).shortValue())
            if ( null != st ) {
                return st
            } else {
                throw new IllegalArgumentException("No case with this ID: $jsonValue")
            }
        } else {
            throw new IllegalArgumentException("Can not convert this into a case: $jsonValue")
        }
    }
}