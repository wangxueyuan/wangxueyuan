package reflect;

import reflect.Pets.Pet;

import java.util.List;
import java.util.Random;

public abstract class PetCreator {
    private Random random = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pet[] createPetArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }
}
