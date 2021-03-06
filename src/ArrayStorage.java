import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int storageSize;

    public void clear() {
        Arrays.fill(storage, 0, storageSize, null);
        storageSize = 0;
    }

    public void save(Resume resume) {
        if (storageSize < storage.length) {
            storage[storageSize] = resume;
            storageSize++;
        } else {
            System.out.println("Массив переполнен и новая запись невозможна");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storageSize--;
            storage[index] = storage[storageSize];
            storage[storageSize] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        if (storageSize == 0) {
            System.out.println("Массив с резюме пуст");
        }
        return Arrays.copyOfRange(storage, 0, storageSize);
    }

    public int size() {
        return storageSize;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        System.out.println("Не найдено резюме с идентификатором " + uuid);
        return -1;
    }
}
