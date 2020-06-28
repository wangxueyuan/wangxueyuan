package reflect;

import reflect.Pets.Manx;
import reflect.Pets.Pet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(
            Arrays.asList(reflect.Pets.Cat.class,
                    reflect.Pets.Cymric.class,
                    reflect.Pets.Dog.class,
                    reflect.Pets.Hamster.class,
                    reflect.Pets.EgyptianMau.class,
                    reflect.Pets.Manx.class,
                    reflect.Pets.Mouse.class,
                    reflect.Pets.Pet.class,
                    reflect.Pets.Mutt.class,
                    reflect.Pets.Pug.class,
                    reflect.Pets.Rodent.class)
    );

    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Manx.class), allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return allTypes;
    }
}
